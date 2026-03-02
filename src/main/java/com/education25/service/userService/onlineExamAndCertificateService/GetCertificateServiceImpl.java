package com.education25.service.userService.onlineExamAndCertificateService;

import java.util.List;

import com.education25.dao.userDao.onlineExamAndCertificateDao.GetCertificateDao;
import com.education25.dao.userDao.onlineExamAndCertificateDao.GetCertificateDaoImpl;
import com.education25.model.userModel.onlineExamAndCertificateModel.GetCertificateModel;

public class GetCertificateServiceImpl implements GetCertificateService{

	@Override
	public List<GetCertificateModel> getCertificateRecords(int user_id) {
		GetCertificateDao dao=new GetCertificateDaoImpl();
		List<GetCertificateModel> getcertificateRecordsDao = dao.getcerticicateRecordsDao(user_id);
		return getcertificateRecordsDao;
	}

}