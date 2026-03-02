package com.education25.dao.adminDao.coursesControlDao;

import java.sql.Connection;
import com.education25.model.adminModel.coursesControlModel.SubCourseContentRemoveOneHeadingModel;

public interface SubCourseContentRemoveOneHeadingDao {
	String removeOneHeadingDao(SubCourseContentRemoveOneHeadingModel removeOneHeadingModel);
	String removeHeadingAndSubHeadingDao(Connection con, SubCourseContentRemoveOneHeadingModel removeOneHeadingModel);

}