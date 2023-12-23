package service.student;

import dao.impl.JpaRepoImpl;
import entity.Student;

import java.sql.ResultSet;
import java.util.List;

public class StudentService extends JpaRepoImpl<Student> {
    public StudentService() {
        super(Student.class);
    }

    @Override
    protected List<Student> rowMapper(ResultSet rs) {
        return null;
    }
}
