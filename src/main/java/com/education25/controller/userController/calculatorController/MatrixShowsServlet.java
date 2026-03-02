package com.education25.controller.userController.calculatorController;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viewPages/user-view-pages/calculator-view-pages/matrix-solve")
public class MatrixShowsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MatrixShowsServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
    		try {
			String number_of_matrix_string=(String)request.getParameter("number_of_matrix");
			int number_of_matrix=0;
			
			if(number_of_matrix_string!=null) {					
				//Set number of matrix.
				request.setAttribute("number_of_matrix",number_of_matrix_string);
				request.setAttribute("id",request.getParameter("id"));
				
				//convert string to integer
				number_of_matrix=Integer.parseInt(number_of_matrix_string);
				
				int[] matrix_row = new int[number_of_matrix];
				int[] matrix_colomn = new int[number_of_matrix];		
				
				// Get and set every matrix row and column
				for(int i = 0; i < number_of_matrix; i++) {
					
					String rows = "matrix_row" + (i + 1);
					String colomns = "matrix_colomn" + (i + 1);
					
					String input_row=(String) request.getParameter(rows);
					String input_colomn=(String)request.getParameter(colomns);
					
					if(input_row!=null) {
						matrix_row[i] = Integer.parseInt(input_row);
						request.setAttribute(rows, input_row);
					}
					
					if(input_colomn!=null) {
						matrix_colomn[i] = Integer.parseInt(input_colomn);
						request.setAttribute(colomns, input_colomn);
					}
				}
				
				for (int i = 0; i < number_of_matrix; i++) { 
					for (int j = 0; j < matrix_row[i]; j++) {  
						for (int k = 0; k < matrix_colomn[i]; k++) { 
							String matrix_input_elements = "m" + (i + 1) + "_r" + j + "_c" + k;
							double doubleNum = Double.parseDouble(request.getParameter(matrix_input_elements));
							doubleNum = Math.round(doubleNum * 100.00) / 100.00;
							if (doubleNum % 1 == 0) {
								doubleNum = (int)doubleNum;
							}
							request.setAttribute(matrix_input_elements,Double.toString(doubleNum));
						}
					}
				}
			}
		}catch (Exception e) {
			RequestDispatcher rd = request.getRequestDispatcher("/viewPages/user-view-pages/calculator-view-pages/matrix-main.jsp");
			rd.forward(request, response);
			return;
		}
    		
		RequestDispatcher rd = request.getRequestDispatcher("/viewPages/user-view-pages/calculator-view-pages/matrix-main-calculation.jsp");
		rd.forward(request, response);
		return;
	}
}