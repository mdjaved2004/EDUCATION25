package com.education25.controller.userController.calculatorController;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.education25.model.userModel.calculatorModel.MatrixAdvanceCalculateModel;
import com.education25.model.userModel.calculatorModel.MatrixAdvanceCalculateResultReturnModel;
import com.education25.service.userService.calculatorService.MatrixAdvanceCalculateService;
import com.education25.service.userService.calculatorService.MatrixAdvanceCalculateServiceImpl;

@WebServlet("/viewPages/user-view-pages/calculator-view-pages/matrix-advance-calculate")
public class MatrixCalculateAdvanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		//define variable.
		String first_matrix_number = null, operator=null;
		String rows=null,colomns=null, matrix_input_element=null;
		int number_of_matrix,first_m_n, first_m_r = 0,first_m_c = 0, i=0,j=0,k=0;
		double doubleNum;
		double[][] m1 =null;
		
		//get operator which user choose.
		operator=(String)request.getParameter("operator0");
		   
		//get total number of matrix.
		String number_of_matrix_string=(String)request.getParameter("number_of_matrix");
		number_of_matrix=Integer.parseInt(number_of_matrix_string);
		  	
		//Get first matrix number for identify which matrix choose.
		first_matrix_number=(String)request.getParameter("matrix0");
		
		//set value .
		request.setAttribute("first_matrix_number",first_matrix_number);	
		
		//convert  string to integer(matrix number).
		first_m_n=Integer.parseInt(first_matrix_number);
		
		//Get row and column for first matrix.
		for(i = 0; i < number_of_matrix; i++) {
			rows = "matrix_row" + (i + 1);
			colomns = "matrix_colomn" + (i + 1);
			String input_row=(String) request.getParameter(rows);
			String input_colomn=(String)request.getParameter(colomns);
		    if(i==(first_m_n-1) && input_row!=null && input_colomn!=null) {			
			    	first_m_r=Integer.parseInt(input_row);
			    	first_m_c=Integer.parseInt(input_colomn); 
		    }  
		}	
		
		if(first_m_r==first_m_c) {
			//define one dynamic matrix to store matrix value.
			m1 = new double[first_m_r][first_m_c];
			//Get first matrix value.
			for (i = 0; i < number_of_matrix; i++) {
				if(first_m_n==i+1) {
					for (j = 0; j < first_m_r; j++) {
						for (k = 0; k < first_m_c; k++) {
							matrix_input_element = "m" + (i + 1) + "_r" + j + "_c" + k;
							doubleNum = Double.parseDouble(request.getParameter(matrix_input_element));
							m1[j][k]= doubleNum; 
						}
					}
				}
			}
			
		}else { 
			request.setAttribute("message_error","Number of row and number of column not match. <br>So, this operator only  possible for squere matrix");	
			RequestDispatcher rd = request.getRequestDispatcher("/viewPages/user-view-pages/calculator-view-pages/matrix-main-calculation.jsp");
			rd.forward(request, response);
			return;
		}
		
		//hold value in model class.
		
		MatrixAdvanceCalculateModel matrixModel = new MatrixAdvanceCalculateModel(m1, operator, first_m_n, first_m_r, first_m_c);
			
		MatrixAdvanceCalculateService matrixService = new MatrixAdvanceCalculateServiceImpl();
		MatrixAdvanceCalculateResultReturnModel matrixSolve=null;
		try { 
			matrixSolve = matrixService.matrixSolve(matrixModel);
		} catch (Exception e) {
			if(matrixSolve.getMessage_error()==null) {
				request.setAttribute("message_error", "Somthing wrong try again");
			}else {
				request.setAttribute("message_error", matrixSolve.getMessage_error());
			}
		}
		
		if(matrixSolve.getMessage_error()==null) {
			if(operator.equals("d")) {
				request.setAttribute("result_value", String.valueOf(matrixSolve.getDeterminan()));
			}else{
				request.setAttribute("result", matrixSolve.getResult_matrix());
				request.setAttribute("r_rows", String.valueOf(first_m_r));
		        request.setAttribute("r_columns", String.valueOf(first_m_c));
			}
			if(operator.equals("i")) {
				String temp = "<hr style=\"border: 1px solid black;\"/><br><center class=\"result_values_text\">" 
                        + matrixSolve.getDeterminan() + "</center>";
				request.setAttribute("result_value", temp);
			}
		}else {
			request.setAttribute("message_error", matrixSolve.getMessage_error());
		}
		RequestDispatcher rd = request.getRequestDispatcher("/viewPages/user-view-pages/calculator-view-pages/matrix-main-calculation.jsp");
		rd.forward(request, response);
		return;				
	}
}