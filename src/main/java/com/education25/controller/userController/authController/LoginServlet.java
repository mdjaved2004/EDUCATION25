package com.education25.controller.userController.authController;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.education25.model.userModel.authModel.LoginFormInformationModel;
import com.education25.model.userModel.authModel.UserModel;
import com.education25.service.userService.authService.LoginServiceImpl;

@WebServlet("/viewPages/user-view-pages/auth-view-pages/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
    		String username=null,password=null;
    	
        username = request.getParameter("username");
        password = request.getParameter("password");
        
        if(username!=null)username=username.trim();
        if(password!=null)password=password.trim();

        HttpSession session = request.getSession();

        //check user information in empty or not empty.
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            request.setAttribute("message_error", "Username and password cannot be empty!");
            RequestDispatcher rd = request.getRequestDispatcher("/viewPages/user-view-pages/auth-view-pages/login-page.jsp");
			rd.forward(request, response);
			return;
        }
        
        LoginFormInformationModel loginModel = new LoginFormInformationModel(username, password);
        
        LoginServiceImpl service = new LoginServiceImpl();

        //check validation for user information
        String validationError = service.checkValidation(loginModel);
        if (validationError != null) {
        		request.setAttribute("message_error", validationError);
            RequestDispatcher rd = request.getRequestDispatcher("/viewPages/user-view-pages/auth-view-pages/login-page.jsp");
			rd.forward(request, response);
			return;
        }
        
        //This method to call check user exist in data base.
        UserModel user = service.loginService(loginModel);

        if (user != null) {
            //Save user info in session
        		session.setAttribute("user_id", Integer.toString(user.getUser_id()));
			session.setAttribute("user_name", user.getUser_name());
			session.setAttribute("user_email", user.getUser_email());
			session.setAttribute("user_userName", user.getUser_username());
            
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
			return;
			
        } else {
        	 	request.setAttribute("message_error", "Invalid username or password.");
        	 	RequestDispatcher rd = request.getRequestDispatcher("/viewPages/user-view-pages/auth-view-pages/login-page.jsp");
			rd.forward(request, response);
			return;
        }
    }
}