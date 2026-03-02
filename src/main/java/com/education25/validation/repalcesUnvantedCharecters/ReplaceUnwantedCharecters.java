package com.education25.validation.repalcesUnvantedCharecters;

public class ReplaceUnwantedCharecters {

	public String replace(String inputString ) {
		if(inputString==null || inputString.trim().isEmpty()) {
    			return null;
		}else {
			inputString = inputString.replace("&", "&amp;")
					.replace("<", "&lt;")   
					.replace(">", "&gt;")						           
					.replace("\"", "&quot;") 
					.replace("'", "&apos;")
					.replace("`", "&#96;");
			return inputString;	
		}
	}
}