package utils;

import entity.Students;
import entity.StudentsList;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

public class Processing {
    public static void getUserChoose(){
        Scanner input = new Scanner(System.in);
        int number;
        int searchID = -1;
        Students stuSearch;
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
                        while (true){
                            try {
                                searchID = Integer.parseInt(input.nextLine());
                                break;
                            } catch (Exception e){
                                System.err.println("Plese input integer!");
                                input.nextInt();
                            }
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

    public static int ageCaculator(LocalDate dateOfBirth){
        LocalDate dayNow = LocalDate.now();
        if (dayNow.getMonthValue() > dateOfBirth.getMonthValue()){
            return dayNow.getYear() - dateOfBirth.getYear();
        }
        if (dayNow.getMonthValue() < dateOfBirth.getMonthValue()){
            return dayNow.getYear() - dateOfBirth.getYear() - 1;
        } else {
            boolean checkDay = dayNow.getDayOfMonth() >= dateOfBirth.getDayOfMonth();
            if (checkDay){
                return dayNow.getYear() - dateOfBirth.getYear();
            } else {
                return dayNow.getYear() - dateOfBirth.getYear() - 1;
            }
        }
    }

    public static int checkAgeLevel(int age){
        if (age >= 6 && age <= 10){
            return 1;
        } else if (age <= 14) {
            return 2;
        } else if (age <= 17) {
            return 3;
        } else {
            return 4;
        }
    }




}
