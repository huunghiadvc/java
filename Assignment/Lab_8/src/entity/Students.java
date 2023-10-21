package entity;

import utils.Display;
import utils.Processing;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

public class Students {
    private int ID;
    private String fullName;
    private String address;
    private String tel;
    private LocalDate dateOfBirth;
    private LocalDate enterDate;
    private int age;
    private int ageLevel;

    public Students() {
    }

    public Students(int ID, String fullName, String address, String tel, LocalDate dateOfBirth, LocalDate enterDate, int age, int ageLevel) {
        this.ID = ID;
        this.fullName = fullName;
        this.address = address;
        this.tel = tel;
        this.dateOfBirth = dateOfBirth;
        this.enterDate = enterDate;
        this.age = age;
        this.ageLevel = ageLevel;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(LocalDate enterDate) {
        this.enterDate = enterDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAgeLevel() {
        return ageLevel;
    }

    public void setAgeLevel(int ageLevel) {
        this.ageLevel = ageLevel;
    }

    public static void AddStudent(){
        Scanner input = new Scanner(System.in);
        int ID = 0;
        String fullName = null;
        String address = null;
        String tel = null;
        LocalDate dateOfBirth = null;
        LocalDate enterDate = null;
        int age = 0;
        int ageLevel = 0;
        while (true) {
            try {
                // Input ID
                int check = 1;
                while (check == 1){
                    System.out.println("Input student ID: ");
                    ID = Integer.parseInt(input.nextLine());
                    check = StudentsList.checkStudentID(ID);
                    if (check == 1){
                        System.err.println("Students ID already exists! \nPlease try again!");
                    }
                }

                // Input name
                check = 1;
                while (check == 1){
                    System.out.println("Input student name: ");
                    fullName = input.nextLine();
                    if (fullName.matches(".*[a-zA-Z].*")) {
                        check = 0;
                    } else {
                        System.err.println("Invalid format fullName!");
                    }
                }

                check = 1;
                while (check == 1){
                    System.out.println("Input student date of birth (yyyy-mm-dd): ");
                    dateOfBirth = LocalDate.parse(input.nextLine());
                    LocalDate dayNow = LocalDate.now();
                    if (dayNow.getMonthValue() > dateOfBirth.getMonthValue()){
                        age = dayNow.getYear() - dateOfBirth.getYear();
                    } else if (dayNow.getMonthValue() < dateOfBirth.getMonthValue()){
                        age = dayNow.getYear() - dateOfBirth.getYear() - 1;
                    } else {
                        boolean checkDay = dayNow.getDayOfMonth() >= dateOfBirth.getDayOfMonth();
                        if (checkDay){
                            age = dayNow.getYear() - dateOfBirth.getYear();
                        } else {
                            age = dayNow.getYear() - dateOfBirth.getYear() - 1;
                        }
                    }
                    ageLevel = Processing.checkAgeLevel(age);
                    check = 0;
                }

                check = 1;
                while (check == 1){
                    System.out.println("Input student enter date (yyyy-mm-dd): ");
                    enterDate = LocalDate.parse(input.nextLine());
                    check = 0;
                }

                // Input address
                System.out.println("Input student address: ");
                address = input.nextLine();

                // Input phone number
                check = 1;
                while (check == 1){
                    System.out.println("Input student phone number: ");
                    tel = input.nextLine();
                    if (tel.length() != 7){
                        System.err.println("Phone numbers need 7 digits!");
                    }
                    if (!tel.matches(".*[0-9].*")) {
                        System.err.println("Phone numbers cannot contain letters or characters!");
                        continue;
                    }
                    check = 0;
                }
                break;
            } catch (Exception e) {
                input.nextLine();
            }
        }

        Students stu = new Students(ID, fullName, address, tel, dateOfBirth, enterDate, age, ageLevel);
        StudentsList.add(stu);
        System.err.println("|---- Add Student Successfully ----|");
        Display.menuDisplay();
    }

    public static void editStudentInfor(Students stu, Scanner input){

        String editName;
        String editAddress;
        String editTel;
        LocalDate editDateOfBirth;
        LocalDate editEnterDate;
        int updateAge = 0;
        int updateAgelevel = 0;
        /** Display current student information and enter the information that needs to be edited **/
        while (true){
            try {
                System.out.println("---");
                System.out.println("Student fullName: " + stu.fullName);
                System.out.println("Edit Name: ");
                editName = input.nextLine();

                System.out.println("---");
                System.out.println("Student address: " + stu.address);
                System.out.println("Edit Address: ");
                editAddress = input.nextLine();

                System.out.println("---");
                System.out.println("Student phone number: " + stu.tel);
                System.out.println("Edit Phone number: ");
                editTel = input.nextLine();

                System.out.println("---");
                System.out.println("Student dateOfBirth: " + stu.dateOfBirth);
                System.out.println("Edit dateOfBirth (yyyy/dd/mm): ");
                editDateOfBirth = LocalDate.parse(input.nextLine());

                System.out.println("---");
                System.out.println("Student enterDate: " + stu.enterDate);
                System.out.println("Edit enterDate (yyyy/dd/mm): ");
                editEnterDate = LocalDate.parse(input.nextLine());

                updateAge = Processing.ageCaculator(editEnterDate);
                updateAgelevel = Processing.checkAgeLevel(updateAge);
                break;
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

        /** Confirm student data change **/
        System.err.printf("The data of student have ID %d will be changed from:\n", stu.getID());
        System.out.printf(
                        "fullName: %s" +
                        "\nAddress: %s" +
                        "\nPhone number: %s\n" +
                        "\ndateOfBirth: %s\n" +
                        "\nenterDate: %s\n" +
                        "\nAge: %s\n" +
                        "\nAge Level: %s\n" +
                        "\nTO\n" +
                        "\nfullName: %s" +
                        "\nAddress: %s" +
                        "\nPhone number: %s\n" +
                        "\ndateOfBirth: %s\n" +
                        "\nenterDate: %s\n" +
                        "\nAge: %s\n" +
                        "\nAge Level: %s\n" +
                        "\nOLD DA TA WILL BE OVERWRITTEN AND CANNOT BE RESTORE. ARE YOU SURE?" +
                        "\nInput Y to confirm, or anything to cancel!\n",
                        stu.getFullName(), stu.getAddress(), stu.getTel(),
                        stu.getDateOfBirth(), stu.getEnterDate(), stu.getAge(), stu.getAgeLevel(),
                        editName, editAddress, editTel, editDateOfBirth,
                        editEnterDate, updateAge, updateAgelevel
        );

        String confirm;
        while (true){
            try {
                confirm = input.nextLine();
                break;
            } catch (Exception e){
                input.nextLine();
            }
        }

        /** Check confirm and change information for student **/
        if (Objects.equals(confirm, "Y")){
            stu.setFullName(editName);
            stu.setAddress(editAddress);
            stu.setTel(editTel);
            stu.setDateOfBirth(editDateOfBirth);
            stu.setEnterDate(editEnterDate);
            stu.setAge(updateAge);
            stu.setAgeLevel(updateAgelevel);
            System.err.println("\nDATA CHANGE SUCCESSFULLY!\n");
        }

    }

    @Override
    public String toString(){
        return  " | Student ID: " + ID + " | fullName: " + fullName + " | address: " + address +
                " | phoneNumber: " + tel + " |" + " DateOfBirth: " + dateOfBirth +
                " | Enter Date: " + enterDate + " | Age: " + age + " | Age level: " + ageLevel + " |";
    }

}
