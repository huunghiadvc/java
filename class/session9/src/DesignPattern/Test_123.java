package DesignPattern;

import utils.StringUtils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Test_123 {
    static long NUM_ELEMENT = 50000000;
    public static void main(String[] args) {
        processInSinPattern();
        processInNotSinPattern();
    }

    static void processInSinPattern(){
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < NUM_ELEMENT; i++) {
            String newStudentName = StringUtils.randomAlphaNumeric(20);
            Students.addStudent(Arrays.asList(newStudentName));
        }

        for (int i = 0; i < 10; i++) {
            int limit = 100;
            List<String> studentNameBatch = Students.getBatchStudent(i * limit , limit);
            studentNameBatch.forEach(System.err::println);
        }

        System.err.println("Time process: " + ((System.currentTimeMillis() - startTime) / 1000));
    }
    static void processInNotSinPattern(){
        long startTime = System.currentTimeMillis();
        List<String> studentNames = new ArrayList<>();
        for (int i = 0; i < NUM_ELEMENT; i++) {
            String newStudentName = StringUtils.randomAlphaNumeric(20);
            studentNames.add(newStudentName);
        }

        for (int i = 0; i < 10; i++) {
            int limit = 100;
            List<String> studentNameBatch = getBatchStudent(studentNames, i * limit , limit);
            studentNameBatch.forEach(System.err::println);
        }

        System.out.println("Time process: " + ((System.currentTimeMillis() - startTime) / 1000));
    }
    public static List<String> getBatchStudent(List<String> stuName,int offset, int limit){
        if (stuName == null){
            stuName = new ArrayList<>();
        }
        return stuName.stream().skip(offset).limit(limit).toList();
    }
}
