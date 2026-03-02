package com.education25.validation.checkValues;

import java.util.regex.Pattern;

public class CheckEmaiValidation {
	
	public boolean emailValidation (String email) {
		if (email == null || email.isEmpty()) {
	        return false;
	    }

	    String emailRegex = 
	        "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
	        "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

	    Pattern pattern = Pattern.compile(emailRegex);

	    if (pattern.matcher(email).matches()) {
	        return true;
	    } else {
	        return false;
	    }
	}
}