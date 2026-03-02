package com.education25.eventHandler;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.education25.eventHandler.createEntities.CreateEntitiesInEducation25CourseInfoImpl;
import com.education25.eventHandler.createEntities.CreateEntitiesInEducation25Impl;
import com.education25.eventHandler.createEntities.CreateEntitiesInEducation25OnlineExamImpl;

@WebListener
public class Start implements ServletContextListener{
	
    @Override
    public void contextInitialized(ServletContextEvent sce) {
    		
    		// Create All Required Entities
        try {
        		new CreateEntitiesInEducation25Impl().createEntitiesInEducation25();
        		new CreateEntitiesInEducation25CourseInfoImpl().createEntitiesInEducation25CourseInfo();
        		new CreateEntitiesInEducation25OnlineExamImpl().createEntitiesInEducation25OnlineExam();
        		
        } catch (Exception e) {
        		System.out.println("Exception for tables creations");
        }  
        
        
        //Set value in setServleteContext
        new StartServletContextSet().setServleteContext(sce);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    	
	    	 ServletContext context = sce.getServletContext();
	    	 
	    	 //Clean attributes
	    	 context.removeAttribute("coursesList");
	     context.removeAttribute("coursesAndSubCoursesMap");
	     
	     System.out.println("EDUCATION25 Application Stopped");
    }
	
    
}
