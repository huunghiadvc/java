package entity;

import java.util.ArrayList;
import java.util.List;

import static javax.swing.text.html.parser.DTDConstants.ID;

public class StudentsList {
    private static List<Students> studentsList = new ArrayList<>();

    public StudentsList(List<Students> studentsList) {
        StudentsList.studentsList = studentsList;
    }

    public static void add(Students stu) {
        studentsList.add(stu);
    }

    public static void showAllStudents(){
        for (Students stu: studentsList) {
            System.out.println(stu.toString());
        }
    }

}
