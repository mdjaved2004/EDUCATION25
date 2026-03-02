package com.education25.service.userService.calculatorService;

import com.education25.model.userModel.calculatorModel.MatrixAdvanceCalculateModel;
import com.education25.model.userModel.calculatorModel.MatrixAdvanceCalculateResultReturnModel;

public class MatrixAdvanceCalculateServiceImpl implements MatrixAdvanceCalculateService{

	@Override
	public MatrixAdvanceCalculateResultReturnModel matrixSolve(MatrixAdvanceCalculateModel matrixModel) {
		String message_error=null;
		double determinant=0;
		double[][] result_matrix =null;
		
		
		switch (matrixModel.getOperator()) {
		    case "d":
		        determinant = determinant(matrixModel.getFirst_m_r(), matrixModel.getM1());
		        break;
		
		    case "t":
		        result_matrix = matrix_transpose(matrixModel.getFirst_m_r(), matrixModel.getM1());
		        break;
		
		    case "c":
		        result_matrix = coFactor(matrixModel.getFirst_m_r(), matrixModel.getM1());
		        break;
		
		    case "a":
		        result_matrix = adj_of_matrix(matrixModel.getFirst_m_r(), matrixModel.getM1());
		        break;
		
		    case "i":
		        result_matrix = adj_of_matrix(matrixModel.getFirst_m_r(), matrixModel.getM1());
		        determinant = determinant(matrixModel.getFirst_m_r(), matrixModel.getM1());
		        break;
		
		    default:
		    		message_error="Your enter values or Operator is incorrect, Enter right value and try again ";
		        break;
		}

		return new MatrixAdvanceCalculateResultReturnModel(result_matrix, determinant, message_error);
	}

	
	public	double determinant(int row, double m1[][]) {
		double determinant = 0;
		if (row == 1) {
				determinant = m1[0][0];
		}else if (row == 2) {
			determinant=find_determinant_square2(m1);
		}else if(row == 3) {
			determinant=find_determinant_square3(m1);
		}else if(row == 4) {
			determinant=find_determinant_square4(m1);
		}
		return determinant;
	
	}
	
	private double find_determinant_square2(double[][] m1) {
		double determinant = 0;
		determinant = m1[0][0] * m1[1][1] - m1[0][1] * m1[1][0];
		return determinant;
	}
	
	private double find_determinant_square3(double[][] m1) {
		double determinant = 0;
		determinant =m1[0][0] * (m1[1][1] * m1[2][2] - m1[2][1] * m1[1][2])
				- m1[0][1] * (m1[1][0] * m1[2][2] - m1[2][0] * m1[1][2])
				+ m1[0][2] * (m1[1][0] * m1[2][1] - m1[2][0] * m1[1][1]);
		return determinant;
	}
	
	private double find_determinant_square4(double[][] m1) {
		double determinant = 0;
		double[][] m=new double[3][3];
		//m1[0][0]
		m[0][0] = m1[1][1]; m[0][1] = m1[1][2]; m[0][2] = m1[1][3];
		m[1][0] = m1[2][1]; m[1][1] = m1[2][2]; m[1][2] = m1[2][3];
		m[2][0] = m1[3][1]; m[2][1] = m1[3][2]; m[2][2] = m1[3][3];
		determinant=determinant+(m1[0][0]*find_determinant_square3(m));
		//m1[0][1]
		m[0][0] = m1[1][0]; m[0][1] = m1[1][2]; m[0][2] = m1[1][3];
		m[1][0] = m1[2][0]; m[1][1] = m1[2][2]; m[1][2] = m1[2][3];
		m[2][0] = m1[3][0]; m[2][1] = m1[3][2]; m[2][2] = m1[3][3];
		determinant=determinant-(m1[0][1]*find_determinant_square3(m));
		//m1[0][2]
		m[0][0] = m1[1][0]; m[0][1] = m1[1][1]; m[0][2] = m1[1][3];
		m[1][0] = m1[2][0]; m[1][1] = m1[2][1]; m[1][2] = m1[2][3];
		m[2][0] = m1[3][0]; m[2][1] = m1[3][1]; m[2][2] = m1[3][3];
		determinant=determinant+(m1[0][2]*find_determinant_square3(m));
		//m1[0][3]
		m[0][0] = m1[1][0]; m[0][1] = m1[1][1]; m[0][2] = m1[1][2];
		m[1][0] = m1[2][0]; m[1][1] = m1[2][1]; m[1][2] = m1[2][2];
		m[2][0] = m1[3][0]; m[2][1] = m1[3][1]; m[2][2] = m1[3][2];
		determinant=determinant-(m1[0][3]*find_determinant_square3(m));
		return determinant;
	}
	//end to solve determinant
	
	//start to solve Co-factor
	public double[][] coFactor(int row, double[][] m1) {
		//this is result matrix
		double[][] m2 = new double[row][row];
		if (row == 1) {
			m2[0][0]=m1[0][0];
		}else if (row == 2) {
			m2=coFactor_square2(m1);
		}else if(row == 3) {
				m2=coFactor_square3(m1);
		}else if(row == 4) {
			m2=coFactor_square4(m1);
		}
		return m2;

	}
	
	private double[][] coFactor_square2(double[][] m1) {
		double[][] m2 = new double[2][2];
			m2[0][0] = +1 * m1[1][1];
			m2[0][1] = -1 * m1[1][0];
			m2[1][0] = -1 * m1[0][1];
			m2[1][1] = +1 * m1[0][0];
		return m2;
	}
	
	private double[][] coFactor_square3(double[][] m1) {
		    double[][] m2 = new double[3][3];
			m2[0][0] = (m1[1][1] * m1[2][2] - m1[2][1] * m1[1][2]);
			m2[0][1] = -1 * (m1[1][0] * m1[2][2] - m1[2][0] * m1[1][2]);
			m2[0][2] = (m1[1][0] * m1[2][1] - m1[2][0] * m1[1][1]);
			m2[1][0] = -1 * (m1[0][1] * m1[2][2] - m1[2][1] * m1[0][2]);
			m2[1][1] = (m1[0][0] * m1[2][2] - m1[2][0] * m1[0][2]);
			m2[1][2] = -1 * (m1[0][0] * m1[2][1] - m1[2][0] * m1[0][1]);
			m2[2][0] = (m1[0][1] * m1[1][2] - m1[1][1] * m1[0][2]);
			m2[2][1] = -1 * (m1[0][0] * m1[1][2] - m1[1][0] * m1[0][2]);
			m2[2][2] = (m1[0][0] * m1[1][1] - m1[1][0] * m1[0][1]);
		return m2;
	}
	
	private double[][] coFactor_square4(double[][] m1) {
	    double[][] m2 = new double[3][3];
	    //result matrix m3
	    double[][] c = new double[4][4];
	    int row_of_set = 0,col_of_set=0,i=0,j=0,k=0,l=0;
	    for (i = 0; i < 4; i++) {
            for (j = 0; j < 4; j++) { 
            	row_of_set = 0;
                for (k = 0; k < 4; k++) {
                    if (k == i) continue;
                    col_of_set = 0;
                    for (l = 0; l< 4; l++) {
                        if (l == j) continue; 
                        m2[row_of_set][col_of_set] = m1[k][l];
                        col_of_set++;
                    }
                    row_of_set++;
                }
                if((i+j)%2==0) {
                	c[i][j]=find_determinant_square3(m2);
                }else {
                	c[i][j]= -1*find_determinant_square3(m2);
                }
            }
        }

	    return c;
	}
	//end to solve Co-factor
	
	//start to solve adjOfMatrix	
	public double[][] adj_of_matrix(int row, double[][] m1) {  
		double[][] m2 = new double[row][row];
		if(row==1){                                           
            m2[0][0]=m1[0][0];
        }else if(row==2){                                           
             m2=adj_of_matrix_square2(m1);
        }else if(row==3){                                           
        	 m2=adj_of_matrix_square3(m1);   
        }else if(row==4){                                           
        	m2=adj_of_matrix_square4(m1);      
        }
		return m2;
	}
	
	public double[][] matrix_transpose(int row, double[][] m1){
		double[][] m2 = new double[row][row];
		for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                m2[j][i] = m1[i][j]; 
            }
        }
		return m2;
		
	}
	
	private  double[][] adj_of_matrix_square2(double[][] m1){
		double[][] m2 = new double[2][2];
		m2=coFactor_square2(m1);
		m2=matrix_transpose(2,m2);     
		return m2;	
	}
	
	private double[][] adj_of_matrix_square3(double[][] m1){
		double[][] m2 = new double[3][3];
		m2=coFactor_square3(m1);
		m2=matrix_transpose(3,m2);     
		return m2;	
	}
	
	private double[][] adj_of_matrix_square4(double[][] m1){
		double[][] m2 = new double[4][4];
		m2=coFactor_square4(m1);
		m2=matrix_transpose(4,m2);     
		return m2;	
	}
}