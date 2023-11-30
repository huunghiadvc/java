package StudentsLab.dao;

import StudentsLab.entity.Student;

import java.sql.SQLException;

public interface CustomerDao {
    Boolean insert(Student stu) throws SQLException;

    Student getById(int id);
}
