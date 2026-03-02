package com.education25.controller.adminController.coursesControlController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/admin_course_context_play_video")
public class AdminCourseContextPlayVideo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String lecture_id=null;
		lecture_id = request.getParameter("lecture_id");
		if(lecture_id!=null) {
			session.setAttribute("lecture_id", lecture_id);
        	response.sendRedirect(request.getContextPath()+"/viewPages/admin-view-pages/control-courses-view-pages/admin-course-context-play-video.jsp");
        	return;
        	
		}else {
		session.setAttribute("message_error", "Failed to play video");
        	response.sendRedirect(request.getContextPath()+"/viewPages/admin-view-pages/control-courses-view-pages/admin-control-courses-uplaod-video.jsp");
        	return;
		}
	}
}
