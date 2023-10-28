package entity;

import utils.GetInput;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

import static jdk.internal.org.jline.utils.Colors.s;

public class StudentsList {
    private static List<Students> studentsList = getBatchStudent();

    public StudentsList(List<Students> studentsList) {
        StudentsList.studentsList = studentsList;
    }


    private static List<Students> getBatchStudent(){
        if (studentsList == null){
            studentsList = new ArrayList<>();
        }
        return studentsList;
    }

    public static void add(Students stu) {
        studentsList.add(stu);
    }

    public static void showStudentsList(int userChoose){
        LocalDate dayNow = LocalDate.now();
        switch (userChoose) {
            case 1:
                studentsList.sort(Comparator.comparingLong(Students::getID));
                for (Students stu : studentsList) {
                    System.out.println(stu.toString());
                }
                break;

            case 2:
                int birthYear = 0;
                while (true){
                    System.out.println("Input student birth year: ");
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
                    System.out.println("Input enter year: ");
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

    public static boolean checkListEmpty(){
        return !studentsList.isEmpty();
    }

    public static Students searchStudent(long searchID){
        for (Students stu: studentsList) {
            if (searchID == stu.getID()){
                return stu;
            }
        }
        return null;
    }

    public static boolean checkStudentID(long checkID){
        for (Students stu: studentsList) {
            if (checkID == stu.getID()){
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
                        Student date of birth: %s
                        Student age: %d
                        Student age level: %s
                        Student enter date: %s

                    ARE YOU SURE?
                    Input Y to confirm, or anything to cancel!
                    """,
                stu.getID(), stu.getFullName(), stu.getAddress(), stu.getTel(), stu.getDateOfBirth(),
                stu.getAge(), stu.getAgeLevel(), stu.getEnterDate()
        );
        String confirm = "";
        while (true){
            try {
                confirm = GetInput.getString();
                break;
            } catch (Exception e){
                System.err.println("Please input a letter!");
                GetInput.getString();
            }
        }
        if (confirm.equalsIgnoreCase("Y")){
            studentsList.remove(stu);
            System.err.println("|---Delete Student Successfully---|");
        } else {
            System.err.println("Cancel student deletion!");
        }
    }

    public static void getOutputTxt() throws IOException {
        String fileName = "Student List";
        File idea = new File(fileName+".txt");
        FileWriter writer;
        String userChoose;
        if (!idea.exists()){
            writer = new FileWriter(idea, true);
        } else {
            System.out.println("""
                    THE STUDENT LIST FILE ALREADY EXIST!!!
                    DO YOU WANT TO CREAT A NEW FILE?
                    Input Y to creat a new file, or input N to override current file!
                    """);
            System.err.println("WARNING: Overwriting existing files can cause data loss!");
            while (true){
                try {
                    userChoose = GetInput.getString();
                    break;
                } catch (Exception e) {
                    System.err.println("Please input a letter!");
                }
            }
            int i = 1;
            while (true){
                if (userChoose.equalsIgnoreCase("Y")){
                    idea = new File(fileName+"("+i+")"+".txt");
                    if (!idea.exists()){
                        writer = new FileWriter(fileName+"("+i+")", true);
                        break;
                    } else {
                        i++;
                    }
                } else {
                    writer = new FileWriter(idea, true);
                    break;
                }
            }
        }
        writer.write("STUDENT LIST:\n\n");
        for(Students stu : studentsList) {
            writer.write(
                    "ID: " + stu.getID() +
                    "\nName: " + stu.getFullName() +
                    "\nAddress: " + stu.getAddress() +
                    "\nPhone Number: " + stu.getTel() +
                    "\nDate of Birth: " + stu.getDateOfBirth() +
                    "\nAge: " + stu.getAge() +
                    "\nAge Level: " + stu.getAgeLevel() +
                    "\nEnter Date: " + stu.getEnterDate() +
                    "\n------------------********------------------\n"
            );
        }

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(idea));
            for (Students stu : studentsList) {
                oos.writeObject(stu);
            }
            System.out.println("Success...");
        } catch (IOException e) {
            System.err.println("Failure...");
        }

        writer.close();
    }

}
