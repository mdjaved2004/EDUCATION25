package com.education25.model.userModel.calculatorModel;

public class MatrixAdvanceCalculateModel {

	private double[][] m1;

    private String operator;

    private int first_m_n;

    private int first_m_r;
    private int first_m_c;
	
    public MatrixAdvanceCalculateModel(double[][] m1, String operator, int first_m_n, int first_m_r, int first_m_c) {
		super();
		this.m1 = m1;
		this.operator = operator;
		this.first_m_n = first_m_n;
		this.first_m_r = first_m_r;
		this.first_m_c = first_m_c;
	}

	public double[][] getM1() {
		return m1;
	}

	public void setM1(double[][] m1) {
		this.m1 = m1;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public int getFirst_m_n() {
		return first_m_n;
	}

	public void setFirst_m_n(int first_m_n) {
		this.first_m_n = first_m_n;
	}

	public int getFirst_m_r() {
		return first_m_r;
	}

	public void setFirst_m_r(int first_m_r) {
		this.first_m_r = first_m_r;
	}

	public int getFirst_m_c() {
		return first_m_c;
	}

	public void setFirst_m_c(int first_m_c) {
		this.first_m_c = first_m_c;
	}      
}