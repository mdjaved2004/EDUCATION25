package com.education25.validation.checkValues;

public class ChechAZ_az_09_spaceAndFirstcharIsAlphabet{
	
	public boolean chechAZ_az_09_spaceAndFirstcharIsAlphabetBollean(String str) {
		try {
			boolean result=str.matches("^[A-Za-z][A-Za-z0-9 ]*$");
			
			if(result) return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}      
	
		return false;
	}
	
	public String chechAZ_az_09AndFirstcharIsAlphabet(String str) {
		try {
			boolean result=str.matches("^[A-Za-z][A-Za-z0-9]*$");
			
			if(result) return null;
			
		} catch (Exception e) {
			e.printStackTrace();
		}      
       return "Only Allow Charecter A to Z, a to z And digit allow 0 to 9";
	}
}