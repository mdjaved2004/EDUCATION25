package com.education25.service.userService.coursesService;

import javax.servlet.http.HttpSession;

public class UserLoginCheckServiceImpl implements UserLoginCheckService {
	
	@Override
	public boolean userLoginCheckBoolean(HttpSession session) {
		try {
			String useEmail=null;		
			useEmail=(String)session.getAttribute("user_email");			
			if(useEmail!=null) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return false;
	}

	@Override
	public int userLoginAndIdReturnId(HttpSession session) {
		
		String useEmail=null;
		int userId=0;
		try {
			
			useEmail=(String)session.getAttribute("user_email");
			
			if(useEmail!=null) {
				userId = Integer.parseInt((String)session.getAttribute("user_id"));
			}
		} catch (Exception e) {
			userId=0;
		}
		return userId;
	}
	
	@Override
	public String userLoginAndIdReturnEmail(HttpSession session) {
		
		String useEmail=null;
		try {
			useEmail=(String)session.getAttribute("user_email");
			
			if(useEmail!=null) {
				return useEmail;
			}else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getName(HttpSession session) {
		String user_name=null;
		try {
			user_name = (String)session.getAttribute("user_name");	
		} catch (Exception e) {		
			user_name=null;
		}
		return user_name;
	}

	@Override
	public String getUserName(HttpSession session) {
		String user_userName=null;
		try {
			user_userName = (String)session.getAttribute("user_userName");	
		} catch (Exception e) {		
			user_userName=null;
		}
		return user_userName;
	}
}