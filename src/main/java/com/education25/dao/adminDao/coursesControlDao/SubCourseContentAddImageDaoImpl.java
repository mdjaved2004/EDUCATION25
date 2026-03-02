package com.education25.dao.adminDao.coursesControlDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.education25.dao.connections.ConnectionFactoryImpl;
import com.education25.model.adminModel.coursesControlModel.SubCourseIdWithMessageErrorModel;
import com.education25.model.adminModel.coursesControlModel.SubCourseImageUpdateModel;
import com.education25.util.ImageRelative.courseImages.DeleteCourseImage;
import com.education25.util.ImageRelative.courseImages.UploadCourseImage;

public class SubCourseContentAddImageDaoImpl implements SubCourseContentAddImageDao {

	@Override
	public SubCourseIdWithMessageErrorModel updateImageService(SubCourseImageUpdateModel model) {
		String previus_image_link=null, saveImageLink=null, message_error=null;
		int sub_course_id =0;
		SubCourseIdWithMessageErrorModel subCoutrseIdWithMessageError =null;
			
		saveImageLink = new UploadCourseImage().uploadCourseImage(model.getImage_input());
		
		if(saveImageLink!=null) {
			String getPreviusImageLinkQuery ="SELECT sub_course_Id, image_link FROM sub_courses WHERE sort_id = ?";
			String updateImageQuery ="UPDATE sub_courses SET image_link = ?, image_add_admin_id = ? WHERE sort_id = ?";
			
			try (Connection con = new ConnectionFactoryImpl().getConnForEducation25CourseInfo();
					PreparedStatement getImage = con.prepareStatement(getPreviusImageLinkQuery);
			         PreparedStatement ps = con.prepareStatement(updateImageQuery)) {
				con.setAutoCommit(false);
				
				getImage.setInt(1, Integer.parseInt(model.getSub_course_short_id()));
				ResultSet executeQuery = getImage.executeQuery();
				
				if(executeQuery.next()) {
					previus_image_link = executeQuery.getString("image_link");
					sub_course_id = executeQuery.getInt("sub_course_Id");
					subCoutrseIdWithMessageError = new SubCourseIdWithMessageErrorModel(sub_course_id, null, null);
				}
					
				ps.setString(1, saveImageLink);
				ps.setInt(2, model.getAdminId());
				ps.setInt(3, Integer.parseInt(model.getSub_course_short_id()));				
				int executeUpdate = ps.executeUpdate();
				
				if(executeUpdate>0) {						
					//Save image link successful. 	
					con.commit();
					if(previus_image_link!=null) {
						//Previous image delete 
						new DeleteCourseImage().deleteImage(previus_image_link);				
					}
				}else {
					con.rollback();	
					//Current image delete, because not save in database.
					new DeleteCourseImage().deleteImage(saveImageLink);
					message_error="Failed to update Image";
				}				
		    } catch (Exception e) {
		    		message_error="Failed to update Image";
		        e.printStackTrace();
		    }
		}
			
		if(message_error!=null) {
			subCoutrseIdWithMessageError = new SubCourseIdWithMessageErrorModel(0, "Image Update failed", null);
		}else {
			subCoutrseIdWithMessageError = new SubCourseIdWithMessageErrorModel(sub_course_id, null, saveImageLink);
		}
		return subCoutrseIdWithMessageError;
	}
}