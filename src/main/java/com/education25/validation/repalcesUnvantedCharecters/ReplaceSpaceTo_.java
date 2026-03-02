package com.education25.validation.repalcesUnvantedCharecters;

public class ReplaceSpaceTo_ {

	public String replaceSpaceTo_(String course_name) {
		if (course_name != null) {
			course_name = course_name.replace(" ", "_");
        }else {
        		return null;
        }
		return course_name;
	}
}