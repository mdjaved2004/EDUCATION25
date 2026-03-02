package com.education25.controller.adminController.authController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.education25.model.adminModel.authModel.AdminLoginFormInformationModel;
import com.education25.model.adminModel.authModel.AdminModel;
import com.education25.service.adminService.authService.AdminLoginService;
import com.education25.service.adminService.authService.AdminLoginServiceImpl;

@WebServlet("/viewPages/admin-view-pages/auth-view-pages/login")
public class AdminLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
    		String username=null,password=null, email=null;
        
    		email = request.getParameter("email");
    		username = request.getParameter("username");
    		password = request.getParameter("password");
    		
    		if(email!=null)email=email.trim();
    		if(username!=null)username=username.trim();
    		if(password!=null)password=password.trim();
    		
        HttpSession session = request.getSession();
        //check user information in empty or not empty.
        if (username == null || username.isEmpty() || password == null || password.isEmpty() || email== null || email.isEmpty()) {
            request.setAttribute("message_error", "Username and password and email cannot be empty!");
            RequestDispatcher rd = request.getRequestDispatcher("/viewPages/admin-view-pages/auth-view-pages/login.jsp");
			rd.forward(request, response);
			return;
        }
        
        AdminLoginFormInformationModel adminLoginModel = new AdminLoginFormInformationModel(email,username, password);       
        
        AdminLoginService service = new AdminLoginServiceImpl();

        //check validation for user information
        String validationError = service.checkValidation(adminLoginModel);
        
        if (validationError != null) {
        		request.setAttribute("message_error", validationError);
            RequestDispatcher rd = request.getRequestDispatcher("/viewPages/admin-view-pages/auth-view-pages/login.jsp");
			rd.forward(request, response);
			return;
        }
        
        //This method to call check user exist in data base.
        AdminModel admininformation = service.loginService(adminLoginModel);

        if (admininformation != null) {
            //Save user info in session
        		session.setAttribute("admin_id", Integer.toString(admininformation.getAdmin_id()));
			session.setAttribute("admin_name", admininformation.getAdmin_name());
			session.setAttribute("admin_email", admininformation.getAdmin_email());
			session.setAttribute("admin_userName", admininformation.getAdmin_username());
            		
			RequestDispatcher rd = request.getRequestDispatcher("/viewPages/admin-view-pages/admin-view-pannel/admin-home-page.jsp");
			rd.forward(request, response);
			return;
			
        } else {
        	 	request.setAttribute("message_error", "Invalid username or password.");
        	 	RequestDispatcher rd = request.getRequestDispatcher("/viewPages/admin-view-pages/auth-view-pages/login.jsp");
			rd.forward(request, response);
			return;
        }
    }
}