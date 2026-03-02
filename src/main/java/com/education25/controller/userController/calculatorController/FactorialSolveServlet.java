package com.education25.controller.userController.calculatorController;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.education25.service.userService.calculatorService.FactorialSolveService;
import com.education25.service.userService.calculatorService.FactorialSolveServiceImpl;

@WebServlet("/viewPages/user-view-pages/calculator-view-pages/factorial-solve")
public class FactorialSolveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int factorial_value=0;
		String factorial_value_string=null;
		String factorial_result_value=null;
		
		request.setAttribute("id",request.getParameter("id"));
		factorial_value_string=(String)request.getParameter("factorial_value");
		
		if(factorial_value_string!=null) {
			factorial_value=Integer.parseInt(factorial_value_string);
		}
		if (factorial_value < 0) {
			session.setAttribute("result_value","Negative value factorial not calculate");
		} else {
			try {
				//create object for calling service layer
				FactorialSolveService factorialSolveService = new FactorialSolveServiceImpl();
				factorial_result_value =factorialSolveService.factorialResult(factorial_value);
				session.setAttribute("result_value",factorial_result_value);
				
			} catch (Exception e) {
				session.setAttribute("result_value","Something wrong, try again and enter right value");								
			}
		}
		
		request.setAttribute("old_value",factorial_value);
		RequestDispatcher rd = request.getRequestDispatcher("/viewPages/user-view-pages/calculator-view-pages/factorial.jsp");
		rd.forward(request, response);
		return;		
	}
}