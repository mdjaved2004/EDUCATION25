package com.education25.dao.connections;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionFactory {
	Connection getConnForEducation25() throws SQLException;
	Connection getConnForEducation25CourseInfo() throws SQLException;
	Connection getConnForEducation25QuestionInfo() throws SQLException;
}