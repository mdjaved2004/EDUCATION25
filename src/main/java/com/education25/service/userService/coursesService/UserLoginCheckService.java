package com.education25.service.userService.coursesService;

import javax.servlet.http.HttpSession;

public interface UserLoginCheckService {
	 boolean userLoginCheckBoolean(HttpSession session);    
	 int userLoginAndIdReturnId(HttpSession session);
	 String userLoginAndIdReturnEmail(HttpSession session);
	 String getName(HttpSession session);
	 String getUserName(HttpSession session);
}