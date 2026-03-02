package com.education25.service.userService.onlineExamAndCertificateService;

import java.util.List;
import com.education25.model.userModel.onlineExamAndCertificateModel.GetCertificateModel;

public interface GetCertificateService {
		List<GetCertificateModel> getCertificateRecords(int user_id);
}