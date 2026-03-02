package com.education25.service.ServletContextService;

import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import com.education25.model.ServletContextModel.OnlineExamContextModel;

public class DeleteOnePaperServletContextServiceImpl implements DeleteOnePaperServletContextService {

	@Override
	public boolean deleteOnePaper(HttpServletRequest request, String paper_name) {

	    if (paper_name == null || paper_name.trim().isEmpty()) {
	        return false;
	    }

	    ServletContext ctx = request.getServletContext();

	    List<OnlineExamContextModel> onlineExamContext =
	            (List<OnlineExamContextModel>) ctx.getAttribute("onlineExamContext");

	    if (onlineExamContext == null) {
	        return false;
	    }

	    boolean result = false;

	    Iterator<OnlineExamContextModel> iterator = onlineExamContext.iterator();

	    while (iterator.hasNext()) {
	        OnlineExamContextModel c = iterator.next();

	        if (c.getPaper_Name().equals(paper_name)) {
	            iterator.remove();   //remove
	            result = true;
	            break;
	        }
	    }

	    return result;
	}
}
