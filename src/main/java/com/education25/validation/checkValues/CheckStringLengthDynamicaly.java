package com.education25.validation.checkValues;

public class CheckStringLengthDynamicaly {
	
	public String lengthString(String inputString, int lenght) {
        if (inputString == null || inputString.trim().isEmpty()) {
            return null;  
        }
        if (inputString.length() <= lenght) {
            return inputString; 
        } else {
        		return inputString.substring(0, lenght);  
        }
    }
    
    public boolean lengthStringtrue(String inputString, int lenght) {
        if (inputString == null || inputString.trim().isEmpty()) {
            return false;  
        } else if (inputString.length() <= lenght) {
            return true; 
        } else {
            return false;  
        }
    }
}