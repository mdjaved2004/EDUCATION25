package com.education25.model.userModel.calculatorModel;

public class MatrixSimpleCalculateResultReturnModel {
	 
	private double[][] result_matrix;
	
	private String message_error;
	
	private String r_rows;
	private String r_columns;
	
	public MatrixSimpleCalculateResultReturnModel(double[][] result_matrix, String message_error, String r_rows, String r_columns) {
		super();
		this.result_matrix = result_matrix;
		this.message_error = message_error;
		this.r_rows = r_rows;
		this.r_columns = r_columns;
	}

	public double[][] getResult_matrix() {
		return result_matrix;
	}

	public void setResult_matrix(double[][] result_matrix) {
		this.result_matrix = result_matrix;
	}

	public String getMessage_error() {
		return message_error;
	}

	public void setMessage_error(String message_error) {
		this.message_error = message_error;
	}

	public String getR_rows() {
		return r_rows;
	}

	public void setR_rows(String r_rows) {
		this.r_rows = r_rows;
	}

	public String getR_columns() {
		return r_columns;
	}

	public void setR_columns(String r_columns) {
		this.r_columns = r_columns;
	}	
}