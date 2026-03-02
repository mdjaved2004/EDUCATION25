package com.education25.service.ServletContextService;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import com.education25.dao.ServletContextDao.OnlineExamInformationGetDaoImpl;
import com.education25.model.ServletContextModel.OnlineExamContextModel;

public class OnlineExamInformationUpdateServletContextServiceImpl implements OnlineExamInformationUpdateServletContextService {

	@Override
	public boolean onlineExamContentSetInServleteContext(HttpServletRequest request) {
		try {
			List<OnlineExamContextModel> onlineExamContext=null;
			
			//Get global ServletContext
			ServletContext context = request.getServletContext();
			
			//Get OnlineExamContext
			onlineExamContext = new OnlineExamInformationGetDaoImpl().getOnlineExamContext();
			
			//Store data in ServletContext (available for all JSPs & Servlets)
			context.setAttribute("onlineExamContext", onlineExamContext);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}