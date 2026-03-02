package com.education25.service.userService.authService;

import com.education25.dao.userDao.authDao.RegisterDaoImpl;
import com.education25.model.userModel.authModel.RegisterFormInformationModel;
import com.education25.model.userModel.authModel.RegisterReturnModel;
import com.education25.validation.checkValues.CheckEmaiValidation;
import com.education25.validation.checkValues.CheckStringLetterOrDigitWithSpace;
import com.education25.validation.checkValues.CheckStringLetterOrDigitWithoutSpace;

public class RegisterServiceImpl implements RegisterService {

	@Override
	public RegisterReturnModel registerService(RegisterFormInformationModel registerFormModel) {
	 
		RegisterReturnModel saveUser = new RegisterDaoImpl().saveUser(registerFormModel);
		return saveUser;
	}

	@Override
	public String checkValidation(RegisterFormInformationModel registerFormModel) {

	    String message_error = null;
	    // Extract values from model
	    String fullName = registerFormModel.getFullName();
	    String email = registerFormModel.getEmail();
	    String username = registerFormModel.getUserName();
	    String password = registerFormModel.getPassword();
	    String confirmPassword = registerFormModel.getConfirmPassword();

	    //this object creating to check input valid or not valid with space.
	    CheckStringLetterOrDigitWithSpace checkWithSpace = new CheckStringLetterOrDigitWithSpace();
	  
	    //this object creating to check input valid or not valid without space.
	    CheckStringLetterOrDigitWithoutSpace checkWithoutSpace = new CheckStringLetterOrDigitWithoutSpace();


	    //Full Name Validation
	    if (fullName.length() > 35 || !checkWithSpace.checkStringLetterOrDigit(fullName)) {
	        message_error = "Full name must be alphabet/digit only and under 36 characters.";
	        return message_error;
	    }

	    //Email Validation
	    if (email.length() > 35 || !new CheckEmaiValidation().emailValidation(email)) {
	    		message_error = "Invalid Email. enter a valid email format and under 36 characters.";
	        return message_error;
	    }

	    //UserName Validation
	    if (username.length() > 30 || !checkWithoutSpace.checkStringLetterOrDigit(username)) {
	        message_error = "Username must be A-Z, a-z, 0-9 only and under 31 characters (no spaces).";
	        return message_error;
	    }

	    // Password Validation
	    if (password.length() > 30 || !checkWithoutSpace.checkStringLetterOrDigit(password)) {
	        message_error = "Password must be A-Z, a-z, 0-9 only and under 31 characters.";
	        return message_error;
	    }

	    //Conform Validation
	    if (confirmPassword.length() > 30 || !checkWithoutSpace.checkStringLetterOrDigit(confirmPassword)) {
	        message_error = "Confirm password must be A-Z, a-z, 0-9 only and under 31 characters.";
	        return message_error;
	    }

	    // Password and confirmPassword match
	    if (!password.equals(confirmPassword)) {
	        message_error = "Password and Confirm Password do not match.";
	        return message_error;
	    }

	    return null;
	}
}