package com.education25.dao.adminDao.coursesControlDao;

import com.education25.model.adminModel.coursesControlModel.SubCourseImageUpdateModel;
import com.education25.model.adminModel.coursesControlModel.SubCourseIdWithMessageErrorModel;

public interface SubCourseContentAddImageDao {
	SubCourseIdWithMessageErrorModel updateImageService(SubCourseImageUpdateModel model);
}