package com.education25.controller.userController.calculatorController;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viewPages/user-view-pages/calculator-view-pages/matrix-templet")
public class MatrixTempletServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int number_of_matrix =Integer.parseInt(request.getParameter("number_of_matrix"));
		request.setAttribute("id",request.getParameter("id"));
		    
		for(int i=0;i<number_of_matrix;i++) {
			String temp1="matrix_row"+(i+1);
			String temp2="matrix_colomn"+(i+1);
			int rowValue = Integer.parseInt(request.getParameter(temp1));
		    int columnValue = Integer.parseInt(request.getParameter(temp2));
		    request.setAttribute(temp1,rowValue);
		    request.setAttribute(temp2,columnValue);		    
		}
		request.setAttribute("number_of_matrix",number_of_matrix);
		request.setAttribute("number_of_matrix",number_of_matrix);
		request.setAttribute("matrix_message_row_coloumn","complete");
		RequestDispatcher rd = request.getRequestDispatcher("/viewPages/user-view-pages/calculator-view-pages/matrix-main.jsp");
		rd.forward(request, response);
		return;
	}
}