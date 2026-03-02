package com.education25.dao.adminDao.coursesControlDao;

import java.sql.Connection;
import com.education25.model.adminModel.coursesControlModel.SubCourseFullInformationModel;

public interface SubCourseContentUpdateDataDao {
	SubCourseFullInformationModel subCourseContentUpdateDataDao(String subCourseName, String sortId);
	SubCourseFullInformationModel getCourseContent(String subCourseName, String sortId, Connection con);
}
