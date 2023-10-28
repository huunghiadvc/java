package utils;

import entity.Students;
import entity.StudentsList;

import java.io.IOException;
import java.util.Objects;

public class threadUtils {
    public static void getUserChoose(){
        int userChoose;
        String searchID = "";
        Students stuSearch;
        while (true){
            try {
                userChoose = GetInput.getInt();
            } catch (Exception e) {
                System.err.println("Please input 1-5");
                continue;
            }
            if (userChoose > 0 && userChoose < 6){
                break;
            } else {
                System.err.println("Please select 1-5");
            }
        }
        switch (userChoose) {
            case 1:
                Students.AddStudent();
                break;

            case 2:
                showStudent();
                break;

            case 3:
                if (StudentsList.checkListEmpty()){
                    while (true){
                        System.out.println("Input student ID need to edit: ");
                        System.err.println("(Input N to return menu)");
                        try {
                            searchID = GetInput.getString();
                            break;
                        } catch (Exception e){
                            GetInput.getString();
                        }
                    }
                    if (searchID.equalsIgnoreCase("N")) break;

                    if (searchID.matches(".*[0-9].*")) {
                        stuSearch = StudentsList.searchStudent(Long.parseLong(searchID));
                        if (stuSearch != null){
                            if (Students.editStudentInfo(stuSearch)) {
                                System.err.println("\nDATA CHANGE SUCCESSFULLY!\n");
                            } else {
                                System.err.println("\nDATA CHANGE CANCEL!!!\n");
                            }
                        } else {
                            System.err.println("Student ID does not exist!");
                        }
                    }
                } else {
                    System.err.println("STUDENT LIST IS EMPTY!");
                }
                break;

            case 4:
                if (StudentsList.checkListEmpty()){
                    while (true){
                        System.out.println("Input student ID need to delete: ");
                        System.err.println("(Input N to return menu)");
                        try {
                            searchID = GetInput.getString();
                            break;
                        } catch (Exception e){
                            System.err.println("Please input integer!");
                            GetInput.getString();
                        }
                    }

                    if (searchID.equalsIgnoreCase("N")) break;

                    if (searchID.matches(".*[0-9].*")) {
                        stuSearch = StudentsList.searchStudent(Long.parseLong(searchID));
                        if (stuSearch != null) {
                            StudentsList.deleteStudent(stuSearch);
                            break;
                        } else {
                            System.err.println("Student ID does not exist!");
                        }
                    }

                } else {
                    System.err.println("STUDENT LIST IS EMPTY!");
                }
                break;

            case 5:
                System.out.println("Input Y to exit the program, input anything to cancel.");
                String userConfirm = GetInput.getString();
                if (Objects.equals(userConfirm.toUpperCase(), "Y")) {
                    if (StudentsList.checkListEmpty()){
                        try {
                            StudentsList.getOutputTxt();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        System.err.println("Student list is empty!!!");
                    }
                    System.exit(0);
                } else {
                    System.out.println("---------------*********---------------");
                }
                break;

            default:
                System.err.println("Please select options 1-5!!!");
                break;
        }
    }
    public static void showStudent(){
        int userChoose = 0;
        while (true){
            System.out.println("1. Sort by ID!");
            System.out.println("2. Enter Year!");
            System.out.println("3. Birth year!");
            userChoose = GetInput.getInt();
            if (userChoose < 0 || userChoose > 3){
                System.err.println("Please select 1-3!");
                continue;
            }
            break;
        }
        StudentsList.showStudentsList(userChoose);
    }
}
