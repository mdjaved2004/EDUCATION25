package com.education25.dao.userDao.onlineExamAndCertificateDao;

import java.util.List;
import com.education25.model.userModel.onlineExamAndCertificateModel.GetCertificateModel;

public interface GetCertificateDao {
	List<GetCertificateModel> getcerticicateRecordsDao(int user_id);
}