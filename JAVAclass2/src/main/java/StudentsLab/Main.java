package StudentsLab;

import StudentsLab.dao.CustomerDao;
import StudentsLab.dao.impl.StudentDaoImpl;
import StudentsLab.entity.Student;
import StudentsLab.service.FileService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {

//        CustomerDao obj = new StudentDaoImpl();
//        Student stu = obj.getById(1);
//
//        System.out.println(stu.toString());

        List<Student> studentList = Arrays.asList(
                new Student(1, "Nghia", new Date(), "CB"),
                new Student(1, "Nghia", new Date(), "CB"),
                new Student(1, "Nghia", new Date(), "CB"),
                new Student(1, "Nghia", new Date(), "CB"),
                new Student(1, "Nghia", new Date(), "CB")
                ,new Student(1, "Nghia", new Date(), "CB")
        );

        ObjectMapper objectMapper = new ObjectMapper();

        String stuList = objectMapper.writeValueAsString(studentList);

        FileService.fileWritter(stuList);

        String strFromFile = FileService.fileAccountReader();

        List<Student> hahaha = objectMapper.readValue(strFromFile, new TypeReference<List<Student>>() {});

        hahaha.forEach(System.out::println);

    }

}
