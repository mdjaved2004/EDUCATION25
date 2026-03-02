package com.education25.dao.adminDao.coursesControlDao;

import java.sql.Connection;
import com.education25.model.adminModel.coursesControlModel.SubCourseContentAddOneHeadingFormModel;

public interface SubCourseContentAddOneHeadingDao {
	String addOneHeadingDao(SubCourseContentAddOneHeadingFormModel modelFormData);
	String addHeadingDao(Connection con, SubCourseContentAddOneHeadingFormModel modelFormData);
}
