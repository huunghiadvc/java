package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    public static Students searchStudent(int searchID){
        for (Students stu: studentsList) {
            if (searchID == stu.getID()){
                return stu;
            }
        }
        return null;
    }

    public static void deleteStudent(Students stu, Scanner input){
        System.out.printf(
                "THE STUDENT HAVE INFORMATION BELOW WILL BE REMOVE: \n" +
                        "\nStudent ID: %d" +
                        "\nStudent fullName: %s" +
                        "\nStudent address: %s" +
                        "\nStudent phone number: %s\n" +
                        "\nARE YOU SURE?" +
                        "\nInput Y to confirm, or anything to cancel!",
                stu.getID(), stu.getFullName(), stu.getAddress(), stu.getTel()
        );
        String confirm = "";
        try {
            confirm = input.nextLine();
        } catch (Exception e){
            input.next();
        }
        studentsList.remove(stu);
    }

}
