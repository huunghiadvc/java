package session3.StudentsLab.dao;

import session3.StudentsLab.entity.Student;

import java.sql.SQLException;

public interface CustomerDao {
    Boolean insert(Student stu) throws SQLException;

    Student getById(int id);
}
