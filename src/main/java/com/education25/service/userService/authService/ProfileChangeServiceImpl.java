package com.education25.service.userService.authService;

import com.education25.dao.userDao.authDao.ProfileChangeDao;
import com.education25.dao.userDao.authDao.ProfileChangeDaoImpl;
import com.education25.validation.checkValues.CheckStringLetterOrDigitWithSpace;
import com.education25.validation.checkValues.CheckStringLetterOrDigitWithoutSpace;

public class ProfileChangeServiceImpl implements ProfileChangeService {

	@Override
	public String updateProfileService(int user_id, String name, String userName) {
		String message_error = null;
		message_error = validation(name, userName);
		
		if(message_error !=null) {
			return message_error;
		}else {
			ProfileChangeDao dao =new ProfileChangeDaoImpl();
			return dao.updateProfileDao(user_id, name, userName);		
		}
	}
	
	private String validation(String name, String userName) {
		String message_error = null;
		
		//this object creating to check input valid or not valid with space.
	    CheckStringLetterOrDigitWithSpace checkWithSpace = new CheckStringLetterOrDigitWithSpace();
	  
	    //this object creating to check input valid or not valid without space.
	    CheckStringLetterOrDigitWithoutSpace checkWithoutSpace = new CheckStringLetterOrDigitWithoutSpace();

	    //Full Name Validation
	    if (name.length() > 35 || !checkWithSpace.checkStringLetterOrDigit(name)) {
	        message_error = "Full name must be alphabet/digit only and under 36 characters.";
	        return message_error;
	    }
	 	
	 	 if (userName.length() > 30 || !checkWithoutSpace.checkStringLetterOrDigit(userName)) {
		        message_error = "Username must be A-Z, a-z, 0-9 only and under 31 characters (no spaces).";
		        return message_error;
		    }
		return message_error;	
	}
}