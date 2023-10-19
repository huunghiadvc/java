package entity;

import utils.Display;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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

    public static int checkStudentID(int checkID){
        for (Students stu: studentsList) {
            if (checkID == stu.getID()){
                return 1;
            }
        }
        return 0;
    }

    public static void deleteStudent(Students stu, Scanner input){
        System.err.println("THE STUDENT HAVE INFORMATION BELOW WILL BE REMOVE: \n");
        System.out.printf(
                        "Student ID: %d" +
                        "\nStudent fullName: %s" +
                        "\nStudent address: %s" +
                        "\nStudent phone number: %s\n" +
                        "\nARE YOU SURE?" +
                        "\nInput Y to confirm, or anything to cancel!",
                stu.getID(), stu.getFullName(), stu.getAddress(), stu.getTel()
        );
        String confirm = "";
        while (true){
            try {
                confirm = input.nextLine();
                break;
            } catch (Exception e){
                input.nextLine();
            }
        }
        if (Objects.equals(confirm, "Y")){
            studentsList.remove(stu);
            System.out.println("|---------------***---------------|");
            System.out.println("|---Delete Student Successfully---|");
            System.out.println("|---------------***---------------|");
        }
        Display.menuDisplay();
    }

}
