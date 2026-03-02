package com.education25.validation.checkValues;

public class CheckStringLengthUnder5500 {
    
	public String length5500(String inputString) {
        if (inputString == null || inputString.trim().isEmpty()) {
            return null;  
        }
        if (inputString.length() <= 5500) {
            return inputString; 
        } else{
            return inputString.substring(0, 5500);
        }
    }
    
    public  boolean length5500RTrue(String inputString) {
        if (inputString == null || inputString.trim().isEmpty()) {
            return false;
        } else if (inputString.length() <= 5500) {
            return true; 
        } else {
            return false;  
        }
    }
    public String length150(String inputString) {
        if (inputString == null || inputString.trim().isEmpty()) {
            return null;  
        }
        if (inputString.length() <= 150) {
            return inputString; 
        } else {
        		return inputString.substring(0, 150);  
        }
    }
    
    public boolean length150true(String inputString) {
        if (inputString == null || inputString.trim().isEmpty()) {
            return false;  
        } else if (inputString.length() <= 150) {
            return true; 
        } else {
            return false;  
        }
    }
}