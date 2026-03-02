package com.education25.service.userService.calculatorService;

import com.education25.model.userModel.calculatorModel.MatrixSimpleCalculateResultReturnModel;
import com.education25.model.userModel.calculatorModel.MatrixSimpleCalculateModel;

public class MatrixSimpleCalculateServiceImpl implements MatrixSimpleCalculateService {

	@Override
	public MatrixSimpleCalculateResultReturnModel matrixSolve(MatrixSimpleCalculateModel matrixModel) {
		
		int first_m_r = matrixModel.getFirst_m_r(), first_m_c =matrixModel.getFirst_m_c() ,
				second_m_r = matrixModel.getSecond_m_r() ,second_m_c = matrixModel.getSecond_m_c();		
		
		String operator=matrixModel.getOperator(), message_error=null, r_rows=null,r_columns=null;
		
		double[][] m1 =matrixModel.getM1();
		double[][] m2 =matrixModel.getM2();
		
		double[][] result_matrix = null;
		
		//if operator '+' or '-'
		if(operator.equals("+")||operator.equals("-")) {
			if(first_m_r==second_m_r && first_m_c==second_m_c) {	
				if(operator.equals("+")) {
					result_matrix=matrixaddition(first_m_r,first_m_c,second_m_r,second_m_c,m1,m2);
				}else if(operator.equals("-")) {
					result_matrix=matrixSubtraction(first_m_r,first_m_c,second_m_r,second_m_c,m1,m2);
				}
			  r_rows = String.valueOf(first_m_r);
			  r_columns = String.valueOf(first_m_c);
			}else {
				message_error="The number of rows and number of columns of both matrices do not match. <br>So, matrix addition and subtraction are not possible";
			}
		}else if(operator.equals("*")){
			if(first_m_c==second_m_r) {
				result_matrix=matrixMultiplication(first_m_r,first_m_c,second_m_r,second_m_c,m1,m2);
				r_rows = String.valueOf(first_m_r);
				r_columns = String.valueOf(second_m_c);
			}else {
		    		message_error="Number of column in first matrix and number of row in second matrix not match. <br>So, matrix multiply in not possible";
			}
		}
				
		return new MatrixSimpleCalculateResultReturnModel(result_matrix, message_error, r_rows, r_columns);		
	}
	
	public  double[][] matrixaddition(int r1, int c1, int r2, int c2, double[][] a1, double[][] b1) {
		int i, j;
		// Declare third matrix for store data.
		double[][] c = new double[r1][c1];
	
		if (r1 == r2 && c1 == c2) {
			for (i = 0; i < r1; i++) {
				for (j = 0; j < c1; j++) {
					c[i][j] = a1[i][j] + b1[i][j];
				}
			}
		}
		return c;
     }

	public double[][] matrixSubtraction(int r1, int c1, int r2, int c2, double[][] a1, double[][] b1) {
		int i, j;
		// Declare third matrix for store data.
		double[][] c = new double[r1][c1];
		if (r1 == r2 && c1 == c2) {
			for (i = 0; i < r1; i++) {
				for (j = 0; j < c1; j++) {
					c[i][j] = a1[i][j] - b1[i][j];
				}
			}
		}
		return c;         
	}

	public double[][] matrixMultiplication(int r1, int c1, int r2, int c2, double[][] a1, double[][] b1) {
		int i, j, k;
		// Declare third matrix for store data.
		double[][] c = new double[r1][c2];
		if (c1 == r2) {
			for (i = 0; i < r1; i++) { // r1*c1&r2*c2=r1*c2
				for (j = 0; j < c2; j++) // m*n&n*p=m*n
				{
					c[i][j] = 0;
					for (k = 0; k < r2; k++) // c1=r2, r1*(c1&r2)*c2=r1*c2:(under value) is common.
					{
						c[i][j] += a1[i][k] * b1[k][j];
					}
				}
			}
		}
		return c;
	}

}