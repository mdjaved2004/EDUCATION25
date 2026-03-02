package com.education25.controller.userController.calculatorController;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.education25.model.userModel.calculatorModel.MatrixSimpleCalculateResultReturnModel;
import com.education25.model.userModel.calculatorModel.MatrixSimpleCalculateModel;
import com.education25.service.userService.calculatorService.MatrixSimpleCalculateService;
import com.education25.service.userService.calculatorService.MatrixSimpleCalculateServiceImpl;

@WebServlet("/viewPages/user-view-pages/calculator-view-pages/matrix-simple-calculate")
public class MatrixCalculateSimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//define variable.
		int number_of_matrix,first_m_n,second_m_n,first_m_r = 0,first_m_c = 0,second_m_r = 0,second_m_c = 0,i=0,j=0,k=0;
		String first_matrix_number = null,operator,second_matrix_number = null;
		String rows=null,colomns=null, matrix_input_element=null;
		double doubleNum;
		
		//get operator which user choose.
		operator=(String)request.getParameter("operator0");
		   
		//get total number of matrix.
		String number_of_matrix_string=(String)request.getParameter("number_of_matrix");
		number_of_matrix=Integer.parseInt(number_of_matrix_string);
		
		//Get first matrix number for identify which matrix choose.
		first_matrix_number=(String)request.getParameter("matrix0");
		
		//Get second matrix number for identify which matrix choose.
		second_matrix_number=(String)request.getParameter("matrix1");
		
		//convert  string to integer(matrix number).
		first_m_n=Integer.parseInt(first_matrix_number);
		second_m_n=Integer.parseInt(second_matrix_number);
		
		//set value .
		request.setAttribute("first_matrix_number",first_matrix_number);			
		request.setAttribute("second_matrix_number",second_matrix_number);		   	   
				
		//Get row and column for first and second matrix.
		for(i = 0; i < number_of_matrix; i++) {
			rows = "matrix_row" + (i + 1);
			colomns = "matrix_colomn" + (i + 1);
			
			String input_row=(String) request.getParameter(rows);
			String input_colomn=(String)request.getParameter(colomns);
			
		    if(i==(first_m_n-1) && input_row!=null && input_colomn!=null) {			
			    	first_m_r=Integer.parseInt(input_row);
			    	first_m_c=Integer.parseInt(input_colomn);	    	
		    }
		    if(i==(second_m_n-1) && input_row!=null && input_colomn!=null) {
			    	second_m_r=Integer.parseInt(input_row);
			    	second_m_c=Integer.parseInt(input_colomn);
		    }		    
		}
		
		//define two dynamic matrix to store matrix value.
		double[][] m1 = new double[first_m_r][first_m_c];
		double[][] m2 = new double[second_m_r][second_m_c];
		
		
		//Get first and second matrix value.
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
			if(second_m_n==i+1) {
				for (j = 0; j < second_m_r; j++) {
					for (k = 0; k < second_m_c; k++) {
						matrix_input_element = "m" + (i + 1) + "_r" + j + "_c" + k;
						doubleNum = Double.parseDouble(request.getParameter(matrix_input_element));
						m2[j][k]= doubleNum;
			         }
				}
			}
		}
				
		// value hold in model.	
		MatrixSimpleCalculateModel matrixModel = new MatrixSimpleCalculateModel(m1, m2, operator, first_m_n, second_m_n, first_m_r, first_m_c, second_m_r, second_m_c); 
		
	 //Calculate matrix use service layer.
		
		MatrixSimpleCalculateService matrixSimpleCalculateService=new MatrixSimpleCalculateServiceImpl();
		
		MatrixSimpleCalculateResultReturnModel matrixSolve = matrixSimpleCalculateService.matrixSolve(matrixModel);
		
		//if no any error then execute if condition.
		if(matrixSolve.getMessage_error()==null) {
			request.setAttribute("result", matrixSolve.getResult_matrix());
			request.setAttribute("r_rows", matrixSolve.getR_rows());
			request.setAttribute("r_columns", matrixSolve.getR_columns());		
		}else {			
			request.setAttribute("message_error",matrixSolve.getMessage_error());
		}
			
		RequestDispatcher rd = request.getRequestDispatcher("/viewPages/user-view-pages/calculator-view-pages/matrix-main-calculation.jsp");
		rd.forward(request, response);
		return;
	}
}