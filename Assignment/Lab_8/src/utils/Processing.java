package utils;

import entity.Students;
import entity.StudentsList;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Processing {
    public static void getUserChoose(){
        Scanner input = new Scanner(System.in);
        int number = 0;
        int searchID = -1;
        Students stuSearch = new Students();
        try {
            number = input.nextInt();
            switch (number) {
                case 1:
                    Processing.AddStudent();
                    break;

                case 2:
                    StudentsList.showAllStudents();
                    break;

                case 3:
                    System.out.println("Input student ID need to edit: ");
                    try {
                        searchID = input.nextInt();
                    } catch (Exception e){
                        System.err.println("Plese input integer!");
                        input.nextInt();
                    }
                    stuSearch = StudentsList.searchStudent(searchID);
                    if (stuSearch != null){
                        Students.editStudentInfor(stuSearch, input);
                    }
                    break;

                case 4:
                    System.out.println("Input student ID need to delete: ");
                    try {
                        searchID = input.nextInt();
                    } catch (Exception e){
                        System.err.println("Plese input integer!");
                        input.nextInt();
                    }
                    stuSearch = StudentsList.searchStudent(searchID);
                    if (stuSearch != null) {
                        StudentsList.deleteStudent(stuSearch, input);
                    }
                    break;

                case 5:
                    System.out.println("Input Y to exit the program, input anything to cancel.");
                    String userConfirm = input.next();
                    if (Objects.equals(userConfirm, "Y")) {
                        System.exit(0);
                    } else {
                        System.out.println("---------------*********---------------");
                    }
                    break;
                default:
                    System.err.println("Please select options 1-5!!!");
                    break;
            }
        } catch (Exception ex){
            input.nextLine();
        }
    }
    public static void AddStudent(){
        Scanner input = new Scanner(System.in);
        int ID = 0;
        String fullName = null;
        String address = null;
        String tel = null;
        try {
            System.out.println("Input student ID: ");
            ID = input.nextInt();
            input.nextLine();
            System.out.println("Input student name: ");
            fullName = input.nextLine();
            System.out.println("Input student address: ");
            address = input.nextLine();
            System.out.println("Input student phone number: ");
            tel = input.nextLine();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            input.nextLine();
        }

        Students stu = new Students(ID, fullName, address, tel);
        StudentsList.add(stu);
    }

}
