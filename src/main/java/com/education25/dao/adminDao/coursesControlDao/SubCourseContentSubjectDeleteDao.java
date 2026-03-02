package com.education25.dao.adminDao.coursesControlDao;

import java.sql.Connection;
import com.education25.model.adminModel.coursesControlModel.SubCourseContentSubjectDeleteModel;

public interface SubCourseContentSubjectDeleteDao {
	String subCourseDeleteDao(SubCourseContentSubjectDeleteModel model);
	String deleteSubCourse (Connection con, SubCourseContentSubjectDeleteModel model);
}