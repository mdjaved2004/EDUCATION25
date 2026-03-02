package com.education25.dao.adminDao.papersControlDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.http.Part;
import com.education25.dao.connections.ConnectionFactoryImpl;
import com.education25.util.ImageRelative.paperImages.DeletePaperImage;
import com.education25.util.ImageRelative.paperImages.UploadPaperImage;

public class QuestionPaperUpdateImageDaoImpl implements QuestionPaperUpdateImageDao {

	@Override
	public String[] updateImageImageDao(String paper_name, String paper_id, Part image_input, String contextPath, int AdminId) {
		String message_error=null, previus_image_link=null, saveImageLink=null; 
		
		String messageWithImageLink[] = new String[2]; 
		
		saveImageLink = new UploadPaperImage().uploadPaperImage(image_input);
		
		if(saveImageLink!=null) {
			messageWithImageLink[1] = saveImageLink;
			String getPreviusImageLinkQuery ="SELECT image_link FROM paper_name_all WHERE paper_id = ?";
			String updateImageQuery ="UPDATE paper_name_all SET image_link = ?, image_add_admin_id = ? WHERE paper_id = ?";
			
			try (Connection con = new ConnectionFactoryImpl().getConnForEducation25QuestionInfo();
					PreparedStatement getImage = con.prepareStatement(getPreviusImageLinkQuery);
			         PreparedStatement ps = con.prepareStatement(updateImageQuery)) {
				con.setAutoCommit(false);
				
				getImage.setInt(1, Integer.parseInt(paper_id));
				ResultSet executeQuery = getImage.executeQuery();
				
				if(executeQuery.next()) {
					previus_image_link = executeQuery.getString("image_link");
				}
					
				ps.setString(1, saveImageLink);
				ps.setInt(2, AdminId);
				ps.setInt(3, Integer.parseInt(paper_id));				
				int executeUpdate = ps.executeUpdate();
				
				if(executeUpdate>0) {						
					//Save image link successful.
					con.commit();
					if(previus_image_link!=null) {
						new DeletePaperImage().deleteImage(previus_image_link);
					}
				}else {
					con.rollback();
					//Current image delete, because not save in database.
					new DeletePaperImage().deleteImage(saveImageLink);
					message_error="Failed to update Image";
				}
								
		    } catch (Exception e) {
		    		message_error = "Failed to upadate image in question paper";
		        e.printStackTrace();
		    }
		}
		
		if(message_error!=null) {
			messageWithImageLink[0] = message_error;
		}
		return messageWithImageLink;
	}
	
}