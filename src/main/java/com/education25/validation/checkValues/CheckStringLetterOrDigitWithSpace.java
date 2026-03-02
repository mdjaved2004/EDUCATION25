package com.education25.validation.checkValues;
//check paper name Capital letter,small letter and Digit, yes or no.
public class CheckStringLetterOrDigitWithSpace {
	public boolean checkStringLetterOrDigit(String inputString) {
   
    	if(inputString==null || inputString.trim().isEmpty()) {
    		return false;	
    	}
    	else {
    		for (char c : inputString.toCharArray()) {
    			// check if the character is not a letter digit and space.
    			if (!Character.isLetterOrDigit(c) && c != ' ') {
    				return false; 
    			}
    		}
    		return true;
    	}
    }
}