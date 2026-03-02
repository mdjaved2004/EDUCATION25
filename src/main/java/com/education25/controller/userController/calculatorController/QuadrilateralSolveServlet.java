package com.education25.controller.userController.calculatorController;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.education25.service.userService.calculatorService.QuadrilateralSolveService;
import com.education25.service.userService.calculatorService.QuadrilateralSolveServiceImpl;

@WebServlet("/viewPages/user-view-pages/calculator-view-pages/quadrilateral-solve")
public class QuadrilateralSolveServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String operator = request.getParameter("operator");
        float width = 0, length = 0;
        
        String resultArray[] =new String[2];
        
        // Safely purpose width
        if (request.getParameter("quadriated_width_input") != null && !request.getParameter("quadriated_width_input").trim().isEmpty()) {
            width = Float.parseFloat(request.getParameter("quadriated_width_input"));
        }

        // Safely purpose height
        if (request.getParameter("quadriated_height_input") != null && !request.getParameter("quadriated_height_input").trim().isEmpty()) {
            length = Float.parseFloat(request.getParameter("quadriated_height_input"));
        }
        
        if(width!=0 && length!=0) {
        	
        		QuadrilateralSolveService quadrilateralService=new QuadrilateralSolveServiceImpl();
        		try {		
        			resultArray=quadrilateralService.quadrilateralSolveService(width, length, operator);
			} catch (Exception e) {
				resultArray=null;
				resultArray[1]="Something wrong, try again and enter right value";
			}     	
        }
         
        request.setAttribute("result_value", resultArray[0]);
        request.setAttribute("result_text", resultArray[1]);
        request.setAttribute("width", Float.toString(width));
        request.setAttribute("length", Float.toString(length));
        request.setAttribute("operator", operator);

        RequestDispatcher rd = request.getRequestDispatcher("/viewPages/user-view-pages/calculator-view-pages/quadriateral.jsp");
		rd.forward(request, response);
		return;
    }
}