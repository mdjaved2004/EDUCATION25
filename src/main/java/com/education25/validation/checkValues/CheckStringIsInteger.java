package com.education25.validation.checkValues;

public class CheckStringIsInteger {
	public boolean checkStringIsInteger(String str) {
	    return str.matches("\\d+");
	}
}