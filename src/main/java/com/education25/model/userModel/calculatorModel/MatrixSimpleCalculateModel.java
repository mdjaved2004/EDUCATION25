package com.education25.model.userModel.calculatorModel;

public class MatrixSimpleCalculateModel {
	
	 // instance variables
    private double[][] m1;
    private double[][] m2;

    private String operator;

    private int first_m_n;
    private int second_m_n;

    private int first_m_r;
    private int first_m_c;
    private int second_m_r;
    private int second_m_c;
	
    public MatrixSimpleCalculateModel(double[][] m1, double[][] m2, String operator, int first_m_n, int second_m_n,
			int first_m_r, int first_m_c, int second_m_r, int second_m_c) {
		super();
		this.m1 = m1;
		this.m2 = m2;
		this.operator = operator;
		this.first_m_n = first_m_n;
		this.second_m_n = second_m_n;
		this.first_m_r = first_m_r;
		this.first_m_c = first_m_c;
		this.second_m_r = second_m_r;
		this.second_m_c = second_m_c;
	}

	public double[][] getM1() {
		return m1;
	}

	public void setM1(double[][] m1) {
		this.m1 = m1;
	}

	public double[][] getM2() {
		return m2;
	}

	public void setM2(double[][] m2) {
		this.m2 = m2;
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

	public int getSecond_m_n() {
		return second_m_n;
	}

	public void setSecond_m_n(int second_m_n) {
		this.second_m_n = second_m_n;
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

	public int getSecond_m_r() {
		return second_m_r;
	}

	public void setSecond_m_r(int second_m_r) {
		this.second_m_r = second_m_r;
	}

	public int getSecond_m_c() {
		return second_m_c;
	}

	public void setSecond_m_c(int second_m_c) {
		this.second_m_c = second_m_c;
	} 
}