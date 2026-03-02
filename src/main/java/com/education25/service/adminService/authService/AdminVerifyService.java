package com.education25.service.adminService.authService;

import javax.servlet.http.HttpSession;

public interface AdminVerifyService {
    boolean adminVerifyBoolean(HttpSession session);
    
    int adminVerifyAdminPosition(HttpSession session);   
}