package com.education25.service.ServletContextService;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import com.education25.model.ServletContextModel.OnlineExamContextModel;

public class QuestionPaperUpdateImageLinkServletContextServiceImpl implements QuestionPaperUpdateImageLinkServletContextService {

	@Override
	public boolean updateLink(HttpServletRequest request, int paper_id, String paper_name, String image_link) {
		List<OnlineExamContextModel> onlineExamContext=null;
		
		if(paper_id!=0 && paper_name!=null && image_link!=null) {
			
			ServletContext ctx = request.getServletContext();
			onlineExamContext = (List<OnlineExamContextModel>) ctx.getAttribute("onlineExamContext");
			for (OnlineExamContextModel c : onlineExamContext) {
			    if (c.getPaper_id() == paper_id) {
		    			c.setImage_link(image_link);
			        break;
			    	 }
			}		
			return true;
		}else {
			return false;			
		}		
	}
}