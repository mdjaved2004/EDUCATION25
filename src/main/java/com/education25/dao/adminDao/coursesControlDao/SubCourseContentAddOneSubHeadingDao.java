package com.education25.dao.adminDao.coursesControlDao;

import java.sql.Connection;
import com.education25.model.adminModel.coursesControlModel.SubCourseContentAddOneSubHeadingFormModel;

public interface SubCourseContentAddOneSubHeadingDao {
	String addOneSubHeadingDao(SubCourseContentAddOneSubHeadingFormModel subHeadingFormModel);
	String addSubHeadingDao(Connection con, SubCourseContentAddOneSubHeadingFormModel subHeadingFormModel);
}