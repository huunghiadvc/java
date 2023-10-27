package entity;

import utils.Display;
import utils.GetInput;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class StudentsList {
    private static List<Students> studentsList = getBatchStudent();

    public StudentsList(List<Students> studentsList) {
        StudentsList.studentsList = studentsList;
    }

    public static void showStudentsList(int userChoose){
        LocalDate dayNow = LocalDate.now();
        switch (userChoose) {
            case 1:
                studentsList.sort(Comparator.comparingInt(left -> Integer.parseInt(left.getID())));
                for (Students stu : studentsList) {
                    System.out.println(stu.toString());
                }
                break;

            case 2:
                int birthYear = 0;
                while (true){
                    System.out.println("Nhập năm sinh: ");
                    birthYear = GetInput.getInt();
                    if (birthYear < 1950 || birthYear > 2010) {
                        System.err.println("Invalid year!!!");
                        continue;
                    }
                    break;
                }
                for (Students stu: studentsList) {
                    if (stu.getDateOfBirth().getYear() == birthYear){
                        System.out.println(stu);
                    }
                }
                break;

            case 3:
                int enterYear = 0;
                while (true){
                    System.out.println("Nhập năm nhập học: ");
                    enterYear = GetInput.getInt();
                    if (enterYear < 2010 || enterYear > dayNow.getYear()) {
                        System.err.println("Invalid year!!!");
                        continue;
                    }
                    break;
                }
                for (Students stu: studentsList) {
                    if (stu.getDateOfBirth().getYear() == enterYear){
                        System.out.println(stu);
                    }
                }
                break;

        }
    }

    public static boolean checkListEmty(){
        return !studentsList.isEmpty();
    }

    public static Students searchStudent(int searchID){
        for (Students stu: studentsList) {
            if (searchID == Integer.parseInt(stu.getID())){
                return stu;
            }
        }
        return null;
    }

    public static boolean checkStudentID(int checkID){
        for (Students stu: studentsList) {
            if (checkID == Integer.parseInt(stu.getID())){
                return true;
            }
        }
        return false;
    }

    public static void deleteStudent(Students stu){
        System.err.println("THE STUDENT HAVE INFORMATION BELOW WILL BE REMOVE: \n");
        System.out.printf(
                """
                        Student ID: %s
                        Student fullName: %s
                        Student address: %s
                        Student phone number: %s

                    ARE YOU SURE?
                    Input Y to confirm, or anything to cancel!""",
                stu.getID(), stu.getFullName(), stu.getAddress(), stu.getTel()
        );
        String confirm = "";
        while (true){
            try {
                confirm = GetInput.getString();
                break;
            } catch (Exception e){
                GetInput.getString();
            }
        }
        if (Objects.equals(confirm, "Y")){
            studentsList.remove(stu);
            System.err.println("|---Delete Student Successfully---|");
        }
        Display.menuDisplay();
    }

    private static List<Students> getBatchStudent(){
        if (studentsList == null){
            studentsList = new ArrayList<>();
        }
        return studentsList;
    }

    public static void getOutputTxt() throws IOException {
        FileWriter writer = new FileWriter("output.txt");
        for(Students stu : studentsList) {
            writer.write(stu + System.lineSeparator());
        }
        writer.close();
    }


    public static void add(Students stu) {
        studentsList.add(stu);
    }
}
