package com.education25.service.userService.coursesService;

import com.education25.dao.userDao.coursesDao.AfterSuccesPamentBuyCourseDao;
import com.education25.dao.userDao.coursesDao.AfterSuccesPamentBuyCourseDaoImpl;
import com.education25.model.userModel.coursesModel.PaymentRequestModel;

public class AfterSuccesPamentBuyCourseServiceImpl implements AfterSuccesPamentBuyCourseService {

	@Override
	public String saveInformationService(PaymentRequestModel model) {
		
		AfterSuccesPamentBuyCourseDao dao= new AfterSuccesPamentBuyCourseDaoImpl();
		
		return dao.saveInformationDao(model);
	}
}