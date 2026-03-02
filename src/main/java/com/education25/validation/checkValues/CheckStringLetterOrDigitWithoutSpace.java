package com.education25.validation.checkValues;

public class CheckStringLetterOrDigitWithoutSpace {

    // Check if input contains only letters or digits
    public boolean checkStringLetterOrDigit(String inputString) {
        if (inputString == null || inputString.trim().isEmpty()) {
            return false;
        }

        for (char c : inputString.toCharArray()) {
        		//If any character is not a letter or digit, return false
            if (!Character.isLetterOrDigit(c)) {
                return false;
            }
        }
        return true;
    }
}