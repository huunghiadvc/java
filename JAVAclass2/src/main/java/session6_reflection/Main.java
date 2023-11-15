package session6_reflection;

import session6_reflection.entity.Students;
import session6_reflection.test.VIDU.StudentRepository;

import java.util.List;


public class Main {
    public static void main(String[] args) {

        StudentRepository studentRepository = new StudentRepository();
//
//        System.out.println(studentRepository.insert(stu));
        List<Students> abc = studentRepository.getAll(1000, 0);
        for (Students s: abc) {
            System.out.println(s.toString());
        }

//        studentRepository.insert(stu);

        long startTime = System.currentTimeMillis();

    }
}
