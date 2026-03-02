package com.education25.controller.userController.coursesController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONObject;
import com.education25.service.userService.coursesService.BuyCourseStartService;
import com.education25.service.userService.coursesService.BuyCourseStartServicempl;
import com.education25.service.userService.coursesService.UserLoginCheckServiceImpl;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@WebServlet("/viewPages/user-view-pages/courses-view-pages/buyCourseStart") 
public class BuyCourseStartServlet extends HttpServlet {  
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     String subCourseSortId=null, message_error=null;
     int amount = 0, user_id=0;
 	
     HttpSession session = request.getSession();
     
     user_id = new UserLoginCheckServiceImpl().userLoginAndIdReturnId(session);
     String jsonData = request.getReader().lines().reduce("", (accumulator, actual) -> accumulator + actual);
     
     response.setContentType("application/json");
     JSONObject jsonResponse = new JSONObject();
     JSONObject data = new JSONObject(jsonData);
     
     if(user_id<=0) {
	    	 jsonResponse.put("status", "error");
	    	 jsonResponse.put("message_error", "You are not Login Login First");
	    	 response.getWriter().write(jsonResponse.toString());
	    	 return;
     }
     
     amount = Integer.parseInt(data.getString("amount"));  
     subCourseSortId = data.getString("subCourseSortId");
     
     BuyCourseStartService checkCourseAlreadyBuyService= new BuyCourseStartServicempl();
     message_error = checkCourseAlreadyBuyService.checkCoursesAlreadyBuyAndAmoutService(user_id, amount, subCourseSortId);
     
     if(message_error!=null) {
    	 	jsonResponse.put("status", "error");
 		jsonResponse.put("message_error", "Invalid amount or subCourseSortId, try again");
 		response.getWriter().write(jsonResponse.toString());
 		return;
     }
    	try {       
        if(amount>0 && subCourseSortId!=null) {
        	
	        	RazorpayClient client = new RazorpayClient(System.getenv("RAZORPAY_KEY"), System.getenv("RAZORPAY_SECRET_key"));
	        	jsonResponse.put("amount", amount*100); 
	        	jsonResponse.put("currency", "INR");
	        	jsonResponse.put("receipt", "txn_2345");
	        	Order order = client.orders.create(jsonResponse);
	        	jsonResponse.put("status", "success");
            jsonResponse.put("order", new JSONObject(order.toString()));
        }else {
        		response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        		jsonResponse.put("status", "error");
        		jsonResponse.put("message_error", "Invalid amount or subCourseSortId");
        }
              
        }catch (RazorpayException e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            jsonResponse.put("status", "error");
            jsonResponse.put("message_error", "Payment gateway error");

        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            jsonResponse.put("status", "error");
            jsonResponse.put("message_error", "Something went wrong");
        }
    		response.getWriter().write(jsonResponse.toString());
   }
}