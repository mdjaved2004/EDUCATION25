package com.education25.dao.adminDao.coursesControlDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import com.education25.dao.connections.ConnectionFactoryImpl;
import com.education25.model.ServletContextModel.CoursesInformationGetModel;
import com.education25.model.ServletContextModel.SubCourseInformationModel;
import com.education25.model.adminModel.coursesControlModel.CourseAndSubCourseWithMessageInfoModel;
import com.education25.model.adminModel.coursesControlModel.SubCourseAddNewFormModel;
import com.education25.model.adminModel.coursesControlModel.SubCourseCreateEntityReturnBasicInfoModel;
import com.education25.model.adminModel.coursesControlModel.SubHeadingContentModel;

public class SubCourseInsertDataDaoImpl implements SubCourseInsertDataDao {

	@Override
	public CourseAndSubCourseWithMessageInfoModel subCourseInsertDataDao(int adminId, SubCourseAddNewFormModel subcourseFormModel,
			Map<String, List<SubHeadingContentModel>> subCourseContent) {
		CourseAndSubCourseWithMessageInfoModel courseAndSubCourseInformation =null;
		String message_error=null;
			
		try (Connection con = new ConnectionFactoryImpl().getConnForEducation25CourseInfo()) {
			 con.setAutoCommit(false);
			 
			//Create new entity and update some entity data. 
			 SubCourseCreateEntityReturnBasicInfoModel subCourseBasicData = CreateTableAndUpdateDataForInsertingData(adminId, subcourseFormModel, con);
			
			if(subCourseBasicData.getMessage_error()!=null) {
				message_error=subCourseBasicData.getMessage_error();
				con.rollback();
			}else {
				courseAndSubCourseInformation = getCourseAndSubCourseInformation(con, subcourseFormModel, subCourseBasicData.getSub_course_id());
				con.commit();
				con.setAutoCommit(false);
				
				// Insert data in database
				message_error = subCourseContentInsert(subCourseBasicData, subCourseContent, con);
				
				if(message_error!=null) {
					con.rollback();
				}else {
					con.commit();
				}
			}
			
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		if(message_error!=null) {
			courseAndSubCourseInformation.setMessage_error(message_error);
		}
		
		return courseAndSubCourseInformation;
	}

	@Override
	public SubCourseCreateEntityReturnBasicInfoModel CreateTableAndUpdateDataForInsertingData(int adminId, SubCourseAddNewFormModel subcourseFormModel, Connection con) {
		String message_error=null, sub_course_name=null, learning_days=null, price=null;
		String sort_id_get_info=null, select_sort_id=null, add_sub_course=null, noOfSubCourses_in_couses_update=null;
		String sub_course_heading_table_name=null, sub_course_sub_heading_table_name=null;
		String sub_course_heading_table=null, sub_course_sub_heading_table=null;
		int new_sort_id=0,course_id=0, generatedSubCourseId = 0;
				
		course_id=subcourseFormModel.getCourse_id();
		sub_course_name=subcourseFormModel.getSub_course_name();
		learning_days=subcourseFormModel.getLearning_days();
		price=subcourseFormModel.getPrice();
		
		sort_id_get_info = "UPDATE id_allocated SET subcorses_last_id = subcorses_last_id + 1 WHERE id = 1 ";
		select_sort_id = "SELECT subcorses_last_id FROM id_allocated WHERE id = 1";  
		add_sub_course = "INSERT INTO sub_courses (sub_course_Name, learningDays, price, course_id, sort_id, admin_id) VALUES (?,?,?,?,?,?)";
		noOfSubCourses_in_couses_update = "UPDATE courses SET noOfSubCourses = noOfSubCourses + 1 WHERE course_id = ?";
        	
		try {
			try (PreparedStatement ps = con.prepareStatement(sort_id_get_info)) {
			    ps.executeUpdate();
			}

			try (PreparedStatement ps = con.prepareStatement(select_sort_id);
			     ResultSet rs = ps.executeQuery()) {
			    	 if (rs.next()) {
			    	// new generate short id
			        new_sort_id = rs.getInt("subcorses_last_id");
			    }
			}
			
			try (PreparedStatement ps = con.prepareStatement(add_sub_course, Statement.RETURN_GENERATED_KEYS)) {
			    ps.setString(1, sub_course_name);
			    ps.setInt(2, Integer.parseInt(learning_days));
			    ps.setInt(3, Integer.parseInt(price));
			    ps.setInt(4, course_id);
			    ps.setInt(5, new_sort_id);
			    ps.setInt(6, adminId);
			    ps.executeUpdate();
			    
			    ResultSet rs = ps.getGeneratedKeys();
			    if (rs.next()) {
			        generatedSubCourseId = rs.getInt(1);
			    }
			}

			try (PreparedStatement ps = con.prepareStatement(noOfSubCourses_in_couses_update)) {
			    ps.setInt(1, course_id);
			    ps.executeUpdate();
			}
			
			sub_course_heading_table_name= sub_course_name +"_heading_"+ new_sort_id;
			sub_course_heading_table = "CREATE TABLE " +sub_course_heading_table_name +" " 
					+ " (heading_id INT NOT NULL PRIMARY KEY, "
					+ " heading_name VARCHAR(150) DEFAULT NULL)";
			
			sub_course_sub_heading_table_name= sub_course_name +"_sub_heading_"+ new_sort_id;
			sub_course_sub_heading_table = "CREATE TABLE " + sub_course_sub_heading_table_name +" "
					+ " (sub_heading_id INT NOT NULL PRIMARY KEY, "
					+ " sub_heading_name VARCHAR(150) DEFAULT NULL, "
					+ " definition VARCHAR(5500) DEFAULT NULL, "
					+ " example VARCHAR(5500) DEFAULT NULL, "
					+ " heading_id INT DEFAULT NULL, "
					+ " FOREIGN KEY (heading_id) REFERENCES " + sub_course_name +"_heading_"+ new_sort_id +"(heading_id))"; 
			
				try (PreparedStatement ps = con.prepareStatement(sub_course_heading_table)) {
				    ps.executeUpdate();
				}
	
				try (PreparedStatement ps = con.prepareStatement(sub_course_sub_heading_table)) {
				    ps.executeUpdate();
				}
			} catch (Exception e) {
				message_error = "DATABASE OPERATION FAILED";
				e.printStackTrace();
			}
		
		return new SubCourseCreateEntityReturnBasicInfoModel(sub_course_heading_table_name, sub_course_sub_heading_table_name, message_error, generatedSubCourseId);
	}

	@Override
	public String subCourseContentInsert(SubCourseCreateEntityReturnBasicInfoModel SubCourseEntityInfo,
			Map<String, List<SubHeadingContentModel>> subCourseContent, Connection con) {
		String insert_topic_of_heading_query=null, insert_topic_of_sub_headings_query=null, message_error=null;
		int headingId = 1;
        int subHeadingId = 1;
        
		insert_topic_of_heading_query = "INSERT INTO " + SubCourseEntityInfo.getSub_course_heading_table_name() +" (heading_id, heading_name) VALUES (?, ?)";

		insert_topic_of_sub_headings_query = "INSERT INTO " + SubCourseEntityInfo.getSub_course_sub_heading_table_name() +" (sub_heading_id, sub_heading_name, definition, example, heading_id) VALUES (?, ?, ?, ?, ?)";
		
		try (PreparedStatement headingPs = con.prepareStatement(insert_topic_of_heading_query); PreparedStatement subHeadingPs = con.prepareStatement(insert_topic_of_sub_headings_query))
		{
			 for (Map.Entry<String, List<SubHeadingContentModel>> entry : subCourseContent.entrySet()) {
				 String heading = entry.getKey();
		         List<SubHeadingContentModel> subHeadingList = entry.getValue();
		         
		         headingPs.setInt(1, headingId);
		         headingPs.setString(2, heading);
		         headingPs.addBatch();
		         for (SubHeadingContentModel model : subHeadingList) {
		                subHeadingPs.setInt(1, subHeadingId);
		                subHeadingPs.setString(2, model.getSubHeadingName());
		                subHeadingPs.setString(3, model.getDefinition());
		                subHeadingPs.setString(4, model.getExample());
		                subHeadingPs.setInt(5, headingId);
		                subHeadingPs.addBatch();
		                subHeadingId++;
		            }
		         headingId++;
			 }
			 
			 headingPs.executeBatch();
		     subHeadingPs.executeBatch();
		 } catch (Exception e) {
		        e.printStackTrace();
		        message_error = "SUB_COURSE_CONTENT_INSERT_FAILED";
		   }
		
		return message_error;
	}
	
	private CourseAndSubCourseWithMessageInfoModel getCourseAndSubCourseInformation(Connection con, SubCourseAddNewFormModel subcourseFormModel, int Sub_course_id) {
		CoursesInformationGetModel course =null;
		SubCourseInformationModel subcourse =null;
		String getCourseDetailQuery = "SELECT course_id, course_name, noOfSubCourses FROM courses WHERE course_id = ? ";
		String getSubCourseDetailQuery="SELECT sub_course_Id, sub_course_Name, image_link, price, learningDays, sort_id FROM sub_courses WHERE sub_course_Id = ? ";

		try (PreparedStatement coursePs = con.prepareStatement(getCourseDetailQuery); 
			 PreparedStatement subCoursePs = con.prepareStatement(getSubCourseDetailQuery)){
			
			coursePs.setInt(1, subcourseFormModel.getCourse_id());
			ResultSet rsCourse = coursePs.executeQuery();
			
			if(rsCourse.next()) {
				course = new CoursesInformationGetModel(rsCourse.getInt("course_id"), rsCourse.getString("course_name"), rsCourse.getInt("noOfSubCourses"));
			}
			
			subCoursePs.setInt(1, Sub_course_id);
			ResultSet rsSubCourse = subCoursePs.executeQuery();
			
			if(rsSubCourse.next()) {				
				subcourse = new SubCourseInformationModel(rsSubCourse.getInt("sub_course_Id"), rsSubCourse.getString("sub_course_Name"), rsSubCourse.getString("image_link"), rsSubCourse.getInt("price"), rsSubCourse.getInt("sort_id"), rsSubCourse.getInt("learningDays"));
			}			
		 } catch (Exception e) {
		        e.printStackTrace();
		   }	
		
		return new CourseAndSubCourseWithMessageInfoModel(course, subcourse, null);	
	}
}