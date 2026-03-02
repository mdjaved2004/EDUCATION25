package com.education25.controller.userController.calculatorController;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.education25.service.userService.calculatorService.CircleSolveService;
import com.education25.service.userService.calculatorService.CircleSolveServiceImpl;

@WebServlet("/viewPages/user-view-pages/calculator-view-pages/circle-solve")
public class CircleSolveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.setAttribute("id",request.getParameter("id"));
		String operator=null;
		float circle_redious=0;
		String resultArray[] =new String[2];
				
		circle_redious=Float.parseFloat(request.getParameter("circle_redious_input"));
		operator=(String)request.getParameter("operator");
		
		if(operator!=null || circle_redious!=0) {		
			try {
				CircleSolveService circleSolveServiceImpl = new CircleSolveServiceImpl();
				
				resultArray = circleSolveServiceImpl.circleSolveService(operator,circle_redious);
			} catch (Exception e) {
				resultArray=null;
				resultArray[1]="Something wrong, try again and enter right value";
			}
		
		}else {
			resultArray[1]="Empty value not allow, Enter value";
		}

		request.setAttribute("old_value",circle_redious+"");
		request.setAttribute("operator",operator);
		request.setAttribute("result_value",resultArray[0]);	
		request.setAttribute("result_text",resultArray[1]);
		
		RequestDispatcher rd = request.getRequestDispatcher("/viewPages/user-view-pages/calculator-view-pages/circle.jsp");
		rd.forward(request, response);
		return;
	}
}