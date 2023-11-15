package StudentsLab;

import StudentsLab.dao.CustomerDao;
import StudentsLab.dao.impl.StudentDaoImpl;
import StudentsLab.entity.Student;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        CustomerDao obj = new StudentDaoImpl();
        Student stu = obj.getById(1);

        System.out.println(stu.toString());

    }
}
