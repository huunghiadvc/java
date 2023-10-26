package entity;

import utils.GetInput;

import java.time.LocalDate;
import java.util.Objects;

public class Students {
    private String ID;
    private String fullName;
    private String address;
    private String tel;
    private LocalDate dateOfBirth;
    private LocalDate enterDate;
    private int age;
    private int ageLevel;

    public Students() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
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

    public static int calculatorAge(LocalDate dateOfBirth){
        int age = 0;
        LocalDate dayNow = LocalDate.now();

        /** TH: đã qua tháng sinh nhật **/
        if (dayNow.getMonthValue() > dateOfBirth.getMonthValue()){
            age = dayNow.getYear() - dateOfBirth.getYear();
        }
        /** TH: chưa đến tháng sinh nhật **/
        else if (dayNow.getMonthValue() < dateOfBirth.getMonthValue()){
            age = dayNow.getYear() - dateOfBirth.getYear() - 1;
        }
        /** TH: đang trong tháng sinh nhật **/
        else {
            boolean checkDay = dayNow.getDayOfMonth() >= dateOfBirth.getDayOfMonth();
            if (checkDay){
                age = dayNow.getYear() - dateOfBirth.getYear();
            } else {
                age = dayNow.getYear() - dateOfBirth.getYear() - 1;
            }
        }
        return age;
    }

    public static int checkAgeLevel(LocalDate enterDate){
        LocalDate dayNow = LocalDate.now();
        return dayNow.getYear() - enterDate.getYear();
    }

    public static void AddStudent(){
        Students stu = new Students();
            // Input ID
            while (true){
                System.out.println("Input student ID: ");
                stu.ID = GetInput.getString();
                boolean checkList = StudentsList.checkListEmty();
                if (!stu.getID().matches(".*[0-9].*")){
                    System.err.println("Invalid ID format!!!");
                    continue;
                }
                if(checkList){
                    if (StudentsList.checkStudentID(Integer.parseInt(stu.ID))) {
                        System.err.println("Students ID already exists! \nPlease try again!");
                        continue;
                    }
                }
                break;
            }

            // Input name
            while (true){
                System.out.println("Input student name: ");
                stu.fullName = GetInput.getString();
                if (!stu.fullName.matches(".*[a-zA-Z].*")) {
                    System.err.println("Invalid format fullName!");
                    continue;
                }
                break;
            }

            // Input address
            System.out.println("Input student address: ");
            stu.address = GetInput.getString();

            // Input phone number
            while (true){
                System.out.println("Input student phone number: ");
                stu.tel = GetInput.getString();
                if (stu.tel.length() != 7){
                    System.err.println("Phone numbers need 7 digits!");
                    continue;
                }
                if (!stu.tel.matches(".*[0-9].*")) {
                    System.err.println("Phone numbers cannot contain letters or characters!");
                    continue;
                }
                break;
            }

            while (true){
                System.out.println("Input student date of birth (yyyy-mm-dd): ");
                stu.dateOfBirth = GetInput.getDate();
                LocalDate dayNow = LocalDate.now();
                if (stu.dateOfBirth.getYear() < 1950 || dayNow.getYear() < stu.dateOfBirth.getYear()){
                    System.err.println("Invalid birth year!!!");
                    continue;
                }
                stu.age = calculatorAge(stu.dateOfBirth);
                break;
            }

            while (true){
                System.out.println("Input student enter date (yyyy-mm-dd): ");
                stu.enterDate = GetInput.getDate();
                LocalDate dayNow = LocalDate.now();
                if (stu.enterDate.getYear() < 2000 || dayNow.getYear() < stu.enterDate.getYear()){
                    System.err.println("Invalid enter date!!!");
                    continue;
                }
                stu.ageLevel = checkAgeLevel(stu.enterDate);
                break;
            }

        StudentsList.add(stu);
        System.err.println("|---- Add Student Successfully ----|");
    }

    public static void editStudentInfor(Students stu){

        String updateName;
        String updateAddress;
        String updateTel;
        LocalDate updateDateOfBirth;
        LocalDate updateEnterDate;
        int updateAge = 0;
        int updateAgelevel = 0;

        /** Display current student information and enter the information that needs to be edited **/

        while (true){
            System.out.println("---");
            System.out.println("Student fullName: " + stu.fullName);
            System.out.println("Edit Name: ");
            updateName = GetInput.getString();
            if (updateName.matches(".*[a-zA-Z].*")) {
                break;
            } else {
                System.err.println("Invalid format fullName!");
            }
        }

        System.out.println("---");
        System.out.println("Student address: " + stu.address);
        System.out.println("Edit Address: ");
        updateAddress = GetInput.getString();

        while (true){
            System.out.println("---");
            System.out.println("Student phone number: " + stu.tel);
            System.out.println("Edit Phone number: ");
            updateTel = GetInput.getString();
            if (updateTel.matches(".*[0-9].*")) {
                break;
            } else {
                System.err.println("Invalid format fullName!");
            }
        }

        while (true){
            System.out.println("---");
            System.out.println("Student dateOfBirth: " + stu.dateOfBirth);
            System.out.println("Edit dateOfBirth (yyyy/dd/mm): ");
            updateDateOfBirth = GetInput.getDate();
            LocalDate dayNow = LocalDate.now();
            if (updateDateOfBirth.getYear() < 1950 || dayNow.getYear() < updateDateOfBirth.getYear()){
                System.err.println("Invalid birth year!!!");
                continue;
            }
            updateAge = calculatorAge(updateDateOfBirth);
            break;
        }

        while (true){
            System.out.println("---");
            System.out.println("Student enterDate: " + stu.enterDate);
            System.out.println("Edit enterDate (yyyy/dd/mm): ");
            updateEnterDate = GetInput.getDate();
            updateAgelevel = checkAgeLevel(updateEnterDate);
            break;
        }



        /** Confirm student data change **/
        System.out.printf(
                """
                        
                    THE INFORMATION OF STUDENT HAVE ID 1 WILL BE CHANGE FROM:
                    
                        fullName: %sAddress: %s
                        Phone number: %s
                        dateOfBirth: %s
                        enterDate: %s
                        Age: %s
                        Age Level: %s

                    TO

                        fullName: %sAddress: %s
                        Phone number: %s
                        dateOfBirth: %s
                        enterDate: %s
                        Age: %s
                        Age Level: %s

                    OLD DA TA WILL BE OVERWRITTEN AND CANNOT BE RESTORE. ARE YOU SURE?
                    Input Y to confirm, or anything to cancel!
                """,
                stu.getID(), stu.getFullName(), stu.getAddress(), stu.getTel(),
                stu.getDateOfBirth(), stu.getEnterDate(), stu.getAge(), stu.getAgeLevel(),
                updateName, updateAddress, updateTel, updateDateOfBirth,
                updateEnterDate, updateAge, updateAgelevel
        );

        String confirm;
        while (true){
            try {
                confirm = GetInput.getString();
                break;
            } catch (Exception e){
                GetInput.getString();
            }
        }

        /** Check confirm and change information for student **/
        if (Objects.equals(confirm.toUpperCase(), "Y")){
            stu.setFullName(updateName);
            stu.setAddress(updateAddress);
            stu.setTel(updateTel);
            stu.setDateOfBirth(updateDateOfBirth);
            stu.setEnterDate(updateEnterDate);
            stu.setAge(updateAge);
            stu.setAgeLevel(updateAgelevel);
            System.err.println("\nDATA CHANGE SUCCESSFULLY!\n");
        } else {
            System.err.println("\nDATA CHANGE CANCEL!!!\n");
        }

    }

    @Override
    public String toString(){
        return  " | Student ID: " + ID + " | fullName: " + fullName + " | address: " + address +
                " | phoneNumber: " + tel + " |" + " DateOfBirth: " + dateOfBirth +
                " | Enter Date: " + enterDate + " | Age: " + age + " | Age level: " + ageLevel + " |";
    }

}
