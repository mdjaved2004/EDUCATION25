package com.education25.controller.userController.coursesController;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONObject;
import com.education25.model.userModel.coursesModel.PaymentRequestModel;
import com.education25.service.userService.coursesService.AfterSuccesPamentBuyCourseService;
import com.education25.service.userService.coursesService.AfterSuccesPamentBuyCourseServiceImpl;
import com.education25.service.userService.coursesService.UserLoginCheckServiceImpl;

@WebServlet("/viewPages/user-view-pages/courses-view-pages/buyCourse/afterSuccesPamentBuyCourse")
public class AfterSuccesPamentBuyCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int user_id=0;
		String message_error =null;
		
		HttpSession session = request.getSession();
	    user_id = new UserLoginCheckServiceImpl().userLoginAndIdReturnId(session);
	    
	    response.setContentType("application/json");
	    JSONObject jsonResponse = new JSONObject();
		
		StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader reader = request.getReader();
        
        while ((line = reader.readLine()) != null) sb.append(line);
        
        JSONObject json = new JSONObject(sb.toString());
        
        int amount = Integer.parseInt(json.getString("amount"));
        int subCourseSortId = Integer.parseInt(json.getString("subCourseSortId"));
        String paymentId = json.getString("payment_id");
        String orderId = json.getString("order_id");
        String signature = json.getString("signature");
        
        PaymentRequestModel model=new PaymentRequestModel(user_id, amount, subCourseSortId, paymentId, orderId, signature);
        
        AfterSuccesPamentBuyCourseService service= new AfterSuccesPamentBuyCourseServiceImpl();
        
        message_error = service.saveInformationService(model);
        
        response.setContentType("application/json");
        if(message_error!=null) {
        		response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            jsonResponse.put("status", "error");
            jsonResponse.put("message_error", message_error);
        }else {
        	 	jsonResponse.put("status", "success");
            jsonResponse.put("message", "Course successful buy");
        }
        	
        response.getWriter().write(jsonResponse.toString());     
	    }
	}