package StudentsLab;

import StudentsLab.dao.StudentDao;
import StudentsLab.dao.impl.StudentDaoImpl;
import StudentsLab.entity.Student;
import session6_reflection.consts.DataType;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        StudentDao obj = new StudentDaoImpl();
        Student stu = obj.getById(1);

        System.out.println(stu.toString());

    }
}
