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
        while (true){
            try {
                number = Integer.parseInt(input.nextLine());
                switch (number) {
                    case 1:
                        Students.AddStudent();
                        break;

                    case 2:
                        StudentsList.showAllStudents();
                        Display.menuDisplay();
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
                        while (true){
                            try {
                                searchID = Integer.parseInt(input.nextLine());
                                stuSearch = StudentsList.searchStudent(searchID);
                                break;
                            } catch (Exception e){
                                System.err.println("Plese input integer!");
                                input.nextLine();
                            }
                        }
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

    }

}
