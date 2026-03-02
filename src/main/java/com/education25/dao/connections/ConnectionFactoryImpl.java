package com.education25.dao.connections;

import java.sql.Connection;
import java.sql.SQLException;
import com.mysql.cj.jdbc.MysqlDataSource;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionFactoryImpl implements ConnectionFactory{
	//change database name after completed
	// education25courseinfo --> education25_courses_information
	//education25questionbanck --> education25_questions_information
	
	private static HikariDataSource education25DataSource;
    private static HikariDataSource education25CourseInfoDataSource;
    private static HikariDataSource education25QuestionInfoDataSource;
	
    static {
        try {      	
        	
            // DataSource for education25
        		MysqlDataSource ds1 = new MysqlDataSource();
            ds1.setUrl(System.getenv("DB1_URL"));
            ds1.setUser(System.getenv("DB1_USER"));
            ds1.setPassword(System.getenv("DB1_PASS"));
            
            HikariConfig hc1 = new HikariConfig();
            hc1.setDataSource(ds1);
            hc1.setMaximumPoolSize(10);

            education25DataSource = new HikariDataSource(hc1);

            // DataSource for education25courseinfo
            MysqlDataSource ds2 = new MysqlDataSource();
            ds2.setUrl(System.getenv("DB2_URL"));
            ds2.setUser(System.getenv("DB2_USER"));
            ds2.setPassword(System.getenv("DB2_PASS"));

            HikariConfig hc2 = new HikariConfig();
            hc2.setDataSource(ds2);
            hc2.setMaximumPoolSize(10);
            
            education25CourseInfoDataSource = new HikariDataSource(hc2);
     
            // DataSource for education25QuestionInfo
            MysqlDataSource ds3 = new MysqlDataSource();
            ds3.setUrl(System.getenv("DB3_URL"));
            ds3.setUser(System.getenv("DB3_USER"));
            ds3.setPassword(System.getenv("DB3_PASS"));

            HikariConfig hc3 = new HikariConfig();
            hc3.setDataSource(ds3);
            hc3.setMaximumPoolSize(10);

            education25QuestionInfoDataSource = new HikariDataSource(hc3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	@Override
    public Connection getConnForEducation25() throws SQLException {
        return education25DataSource.getConnection();
    }
	
    @Override
    public Connection getConnForEducation25CourseInfo() throws SQLException {
        return education25CourseInfoDataSource.getConnection();
    }
    
    @Override
    public Connection getConnForEducation25QuestionInfo() throws SQLException {
        return education25QuestionInfoDataSource.getConnection();
    }
}