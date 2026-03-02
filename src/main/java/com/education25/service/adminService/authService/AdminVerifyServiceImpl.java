package com.education25.service.adminService.authService;

import javax.servlet.http.HttpSession;

public class AdminVerifyServiceImpl implements AdminVerifyService {

	@Override
	public boolean adminVerifyBoolean(HttpSession session) {
		try {
			String adminEmail=null;		
			adminEmail=(String)session.getAttribute("admin_email");			
			if(adminEmail!=null) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return false;
	}

	@Override
	public int adminVerifyAdminPosition(HttpSession session) {
		
		String adminEmail=null;
		int adminId=0;
		try {
			
			adminEmail=(String)session.getAttribute("admin_email");
			
			if(adminEmail!=null) {
				adminId = Integer.parseInt((String)session.getAttribute("admin_id"));
			}
		} catch (Exception e) {
			adminId=0;
		}
		return adminId;
	}
}