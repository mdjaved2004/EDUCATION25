package com.education25.eventHandler.createEntities;
import java.sql.Connection;
import java.sql.Statement;

import com.education25.dao.connections.ConnectionFactoryImpl;

public class CreateEntitiesInEducation25CourseInfoImpl implements CreateEntitiesInEducation25CourseInfo {

    @Override
    public boolean createEntitiesInEducation25CourseInfo() {
        try (Connection con = new ConnectionFactoryImpl().getConnForEducation25CourseInfo();
             Statement stmt = con.createStatement()) {
            //Create courses table
            String createCoursesTable = 
                "CREATE TABLE IF NOT EXISTS courses (" +
                "course_id INT AUTO_INCREMENT PRIMARY KEY, " +
                "course_name VARCHAR(25) DEFAULT NULL, " +
                "noOfSubCourses INT DEFAULT 0, " +
                "admin_id INT DEFAULT NULL, " +
                "admin_position INT DEFAULT NULL)";
            stmt.executeUpdate(createCoursesTable);

            //Create sub_courses table
            String createSubCoursesTable =
                "CREATE TABLE IF NOT EXISTS sub_courses (" +
                "sub_course_Id INT AUTO_INCREMENT PRIMARY KEY, " +
                "sub_course_Name VARCHAR(35) DEFAULT NULL, " +
                "learningDays INT DEFAULT NULL, " +
                "price INT DEFAULT 0, " +
                "course_id INT DEFAULT NULL, " +
                "sort_id INT DEFAULT NULL, " +
                "admin_id INT DEFAULT NULL, " +
                "image_link VARCHAR(250) DEFAULT NULL, " +
                "image_add_admin_id INT DEFAULT 0, " +
                "is_active BOOLEAN NOT NULL DEFAULT TRUE, "+
                "UNIQUE KEY sort_id (sort_id), " +
                "UNIQUE KEY unique_sub_course_name_course_id (sub_course_Name, course_id), " +
                "KEY course_id (course_id), " +
                "FOREIGN KEY (course_id) REFERENCES courses (course_id))";
            stmt.executeUpdate(createSubCoursesTable);

            //Create id_allocated table
            String createIdAllocatedTable =
                "CREATE TABLE IF NOT EXISTS id_allocated (" +
                "id INT NOT NULL AUTO_INCREMENT, " +
                "subcorses_last_id INT DEFAULT NULL, " +
                "PRIMARY KEY (id))";
            stmt.executeUpdate(createIdAllocatedTable);

            // Insert default row if not exists
            String insertDefaultIdAllocated ="INSERT INTO id_allocated (subcorses_last_id) " +
                "SELECT 0 WHERE NOT EXISTS (SELECT 1 FROM id_allocated)";
            stmt.executeUpdate(insertDefaultIdAllocated);

            //Create buy_courses table
            String createBuyCoursesTable =
                "CREATE TABLE IF NOT EXISTS buy_courses (" +
                "buy_course_id INT NOT NULL AUTO_INCREMENT, " +
                "user_id INT NOT NULL, " +
                "course_short_id INT DEFAULT 0, " +
                "order_id VARCHAR(65) DEFAULT NULL, " +
                "razorpay_payment_id VARCHAR(100) NOT NULL, " +
                "razorpay_signature VARCHAR(255) DEFAULT NULL, " +
                "amount INT DEFAULT 0, " +
                "payment_success BIT(1) DEFAULT b'0', " +
                "buy_course_date DATE DEFAULT NULL, " +
                "PRIMARY KEY (buy_course_id))";
            stmt.executeUpdate(createBuyCoursesTable);

            //Create add_free_courses table
            String createAddFreeCoursesTable =
                "CREATE TABLE IF NOT EXISTS add_free_courses (" +
                "user_id INT NOT NULL, " +
                "course_1 INT DEFAULT 0, " +
                "course_2 INT DEFAULT 0, " +
                "course_3 INT DEFAULT 0, " +
                "course_4 INT DEFAULT 0, " +
                "course_5 INT DEFAULT 0, " +
                "PRIMARY KEY (user_id))";
            stmt.executeUpdate(createAddFreeCoursesTable);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}