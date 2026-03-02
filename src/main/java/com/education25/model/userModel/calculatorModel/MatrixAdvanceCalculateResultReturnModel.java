package com.education25.model.userModel.calculatorModel;

public class MatrixAdvanceCalculateResultReturnModel {

	private double[][] result_matrix;
	
	private double determinan;
	
	private String message_error;

	public MatrixAdvanceCalculateResultReturnModel(double[][] result_matrix, double determinan, String message_error) {
		super();
		this.result_matrix = result_matrix;
		this.determinan = determinan;
		this.message_error = message_error;
	}

	public double[][] getResult_matrix() {
		return result_matrix;
	}

	public void setResult_matrix(double[][] result_matrix) {
		this.result_matrix = result_matrix;
	}

	public double getDeterminan() {
		return determinan;
	}

	public void setDeterminan(double determinan) {
		this.determinan = determinan;
	}

	public String getMessage_error() {
		return message_error;
	}

	public void setMessage_error(String message_error) {
		this.message_error = message_error;
	}
}