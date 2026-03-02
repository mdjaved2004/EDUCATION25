package com.education25.controller.adminController.coursesControlController;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import com.education25.validation.repalcesUnvantedCharecters.ReplaceSpaceTo_;

@WebServlet("/admin_upload_video")
@MultipartConfig(maxFileSize = 1024 * 1024 * 500) // 500MB max file size
public class AdminUploadVideoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	String adminIdStr = (String) session.getAttribute("admin_id");
    	String course_name=null,sub_course_name=null,sub_course_short_id=null, title=null, description=null;
    	 	title = request.getParameter("title");
    	 	description = request.getParameter("description");
    	 	course_name = request.getParameter("course_name");
    	 	sub_course_name = request.getParameter("sub_course_name");
    	 	sub_course_short_id = request.getParameter("sub_course_short_id");
    	 	course_name =new  ReplaceSpaceTo_().replaceSpaceTo_(course_name);
    	 	sub_course_name =new ReplaceSpaceTo_().replaceSpaceTo_(sub_course_name);
        Part filePart = request.getPart("video_input");
        InputStream videoStream = filePart.getInputStream();
        
        String dbURL = "jdbc:mysql://localhost:3306/education25course_"+course_name+"";
        String dbUser = "root";  // Change if needed
        String dbPassword = "Mdjaved2004"; // Replace with actual password

        try (Connection con = DriverManager.getConnection(dbURL, dbUser, dbPassword)) {
            String video_upload_query = "INSERT INTO "+sub_course_name+"_lectures_"+sub_course_short_id+"(title, description, lecture_video, instructor_id) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(video_upload_query);
            stmt.setString(1, title);
            stmt.setString(2, description);           
            stmt.setBinaryStream(3, videoStream, (int) filePart.getSize());
            stmt.setInt(4, Integer.parseInt(adminIdStr));

            int rowsInserted = stmt.executeUpdate();
            videoStream.close();  // Close InputStream
            filePart.delete();    // Delete Temporary File

            if (rowsInserted > 0) {
            session.setAttribute("message", "Video uploaded successfully");
            } else {
            	session.setAttribute("message_error", "Failed to upload video.");
            }
            response.sendRedirect(request.getContextPath()+"/viewPages/admin-view-pages/control-courses-view-pages/admin-control-courses-uplaod-video.jsp");
            return;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
