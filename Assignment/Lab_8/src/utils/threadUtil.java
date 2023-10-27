package utils;

import entity.Students;
import entity.StudentsList;

import java.io.IOException;
import java.util.Objects;

public class threadUtil {
    public static void getUserChoose(){
        int userChoose;
        int searchID = -1;
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
                System.out.println("Input student ID need to edit: ");
                while (true){
                    try {
                        searchID = GetInput.getInt();
                    } catch (Exception e){
                        System.err.println("Plese input integer!");
                        GetInput.getInt();
                    }
                    stuSearch = StudentsList.searchStudent(searchID);
                    if (stuSearch != null){
                        Students.editStudentInfor(stuSearch);
                    } else {
                        System.err.println("Student ID does not exist!");
                        continue;
                    }
                    break;
                }
                break;

            case 4:
                System.out.println("Input student ID need to delete: ");
                while (true){
                    try {
                        searchID = GetInput.getInt();
                    } catch (Exception e){
                        System.err.println("Plese input integer!");
                        GetInput.getInt();
                    }
                    stuSearch = StudentsList.searchStudent(searchID);
                    if (stuSearch != null) {
                        StudentsList.deleteStudent(stuSearch);
                    } else {
                        System.err.println("Student ID does not exist!");
                        continue;
                    }
                    break;
                }
                break;

            case 5:
                System.out.println("Input Y to exit the program, input anything to cancel.");
                String userConfirm = GetInput.getString();
                if (Objects.equals(userConfirm.toUpperCase(), "Y")) {
                    if (StudentsList.checkListEmty()){
                        try {
                            StudentsList.getOutputTxt();
                            System.err.println("Student List output to txt file successfully!!!");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        System.err.println("Student list is emty!!!");
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
