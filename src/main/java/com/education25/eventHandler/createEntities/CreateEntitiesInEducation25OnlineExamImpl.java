package com.education25.eventHandler.createEntities;

import java.sql.Connection;
import java.sql.Statement;

import com.education25.dao.connections.ConnectionFactoryImpl;

public class CreateEntitiesInEducation25OnlineExamImpl 
        implements CreateEntitiesInEducation25OnlineExam {

    @Override
    public boolean createEntitiesInEducation25OnlineExam() {

        String createPaperTable =
            "CREATE TABLE IF NOT EXISTS paper_name_all ("
            + "paper_id INT AUTO_INCREMENT PRIMARY KEY, "
            + "paper_name VARCHAR(30) NOT NULL, "
            + "total_ques INT DEFAULT 0, "
            + "option_ques INT DEFAULT 0, "
            + "notOption_ques INT DEFAULT 0, "
            + "admin_id INT, "
            + "image_link VARCHAR(255), "
            + "image_add_admin_id INT DEFAULT 0, "
            + "is_active BOOLEAN NOT NULL DEFAULT TRUE"
            + ")";

        String createTestRecordTable =
            "CREATE TABLE IF NOT EXISTS test_record ("
            + "record_id INT AUTO_INCREMENT PRIMARY KEY, "
            + "user_resi_id INT, "
            + "subject VARCHAR(30) NOT NULL, "
            + "marks_percentage DECIMAL(5,2) DEFAULT 0.00, "
            + "ans VARCHAR(500)"
            + ")";

        try (Connection con = new ConnectionFactoryImpl().getConnForEducation25QuestionInfo();
             Statement stmt = con.createStatement()) {

            stmt.execute(createPaperTable);
            stmt.execute(createTestRecordTable);
           
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}