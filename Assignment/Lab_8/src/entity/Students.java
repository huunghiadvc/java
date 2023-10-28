package entity;

import utils.GetInput;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Students implements Serializable {
    private static final long serialVersionUID = -6500665823330706018L;
    private long ID;
    private String fullName;
    private String address;
    private String tel;
    private LocalDate dateOfBirth;
    private LocalDate enterDate;
    private int age;
    private String ageLevel;

    public Students() {
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
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

    public String getAgeLevel() {
        return ageLevel;
    }

    public void setAgeLevel(String ageLevel) {
        this.ageLevel = ageLevel;
    }

    public static int calculatorAge(LocalDate dateOfBirth){
        int age = 0;
        LocalDate dayNow = LocalDate.now();

        // TH: đã qua tháng sinh nhật //

        if (dayNow.getMonthValue() > dateOfBirth.getMonthValue()){
            age = dayNow.getYear() - dateOfBirth.getYear();
        }
        // TH: chưa đến tháng sinh nhật //
        else if (dayNow.getMonthValue() < dateOfBirth.getMonthValue()){
            age = dayNow.getYear() - dateOfBirth.getYear() - 1;
        }
        // TH: đang trong tháng sinh nhật //
        else {
            // TH: đang hoặc đã qua ngày sinh nhật //
            if (dayNow.getDayOfMonth() >= dateOfBirth.getDayOfMonth()){
                age = dayNow.getYear() - dateOfBirth.getYear();
            } else {
                age = dayNow.getYear() - dateOfBirth.getYear() - 1;
            }
        }
        return age;
    }

    public static String checkAgeLevel(int age){
        if (age == 0 || age == 1){
            return "Infant";
        } else if (age >= 2 && age <= 4) {
            return "Toddler";
        } else if (age > 4 && age < 13) {
            return "Child";
        } else if (age > 12 && age < 20) {
            return "Teen";
        } else if (age > 19 && age <= 39 ) {
            return "Adult";
        } else if (age > 39 && age <= 59) {
            return "Middle Age Adult";
        }
        return "Senior Adult";
    }

    public static void AddStudent(){
        Students stu = new Students();
            // Input ID
            while (true){
                System.out.println("Input student ID: ");
                try {
                    stu.ID = GetInput.getLong();
                } catch (Exception e) {
                    System.err.println("Invalid ID format!!!");
                    continue;
                }
                if(StudentsList.checkListEmpty()){
                    if (StudentsList.checkStudentID(stu.ID)) {
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
            while (true){
                System.out.println("Input student address: ");
                stu.address = GetInput.getString();
                if (stu.fullName.isEmpty()) {
                    System.err.println("Invalid address!");
                    continue;
                }
                break;
            }

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
                stu.ageLevel = checkAgeLevel(stu.age);
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
                break;
            }

        StudentsList.add(stu);
        System.err.println("|---- Add Student Successfully ----|");
    }

    public static boolean editStudentInfo(Students stu){

        String updateName;
        String updateAddress;
        String updateTel;
        String updateDateOfBirth;
        String updateEnterDate;
        LocalDate dateCheck;
        int updateAge = 0;
        String updateAgeLevel;
        LocalDate dayNow = LocalDate.now();

        // Display current student information and enter the information that needs to be edited //

        while (true){
            System.out.println("---");
            System.out.println("Student fullName: " + stu.fullName);
            System.out.println("(Input S to unchanged this information or N to return menu!)");
            System.out.println("Edit Name: ");
            updateName = GetInput.getString();
            if (updateName.matches(".*[a-zA-Z].*")) {
                if (updateName.equalsIgnoreCase("N")){
                    return false;
                }
                if (updateName.equalsIgnoreCase("S")){
                    updateName = stu.getFullName();
                }
                break;
            } else {
                System.err.println("Invalid format fullName!");
            }
        }

        System.out.println("---");
        System.out.println("Student address: " + stu.address);
        System.out.println("Edit Address: ");
        System.out.println("(Input S to unchanged this information or N to return menu!)");
        updateAddress = GetInput.getString();
        if (updateAddress.equalsIgnoreCase("N")){
            return false;
        }
        if (updateAddress.equalsIgnoreCase("S")){
            updateAddress = stu.getAddress();
        }

        while (true){
            System.out.println("---");
            System.out.println("Student phone number: " + stu.tel);
            System.out.println("(Input S to unchanged this information or N to return menu!)");
            System.out.println("Edit Phone number: ");
            updateTel = GetInput.getString();
            if (updateTel.equalsIgnoreCase("S")){
                updateTel = stu.getTel();
            }
            if (updateTel.matches(".*[0-9].*")) {
                if (updateTel.equalsIgnoreCase("N")){
                    return false;
                }
                break;
            } else {
                System.err.println("Invalid format phone number!");
            }
        }

        while (true){
            System.out.println("---");
            System.out.println("Student dateOfBirth: " + stu.dateOfBirth);
            System.out.println("Edit dateOfBirth (yyyy-dd-mm): ");
            System.out.println("(Input S to unchanged this information or N to return menu!)");
            updateDateOfBirth = GetInput.getString();
            if (updateDateOfBirth.equalsIgnoreCase("N")){
                return false;
            }
            if (updateDateOfBirth.equalsIgnoreCase("S")){
                updateDateOfBirth = String.valueOf(stu.getDateOfBirth());
            }
            dateCheck = LocalDate.parse(updateDateOfBirth);
            if (dateCheck.getYear() < 1950 || dayNow.getYear() < dateCheck.getYear()){
                System.err.println("Invalid date of birth!!!");
                continue;
            }
            updateAge = calculatorAge(dateCheck);
            updateAgeLevel = checkAgeLevel(updateAge);
            break;
        }

        while (true){
            System.out.println("---");
            System.out.println("Student enterDate: " + stu.enterDate);
            System.out.println("Edit enterDate (yyyy/dd/mm): ");
            System.out.println("(Input S to unchanged this information or N to return menu!)");
            updateEnterDate = GetInput.getString();
            if (updateEnterDate.equalsIgnoreCase("N")){
                return false;
            }
            if (updateEnterDate.equalsIgnoreCase("S")){
                updateEnterDate = String.valueOf(stu.getEnterDate());
            }
            dateCheck = LocalDate.parse(updateEnterDate);
            if (dateCheck.getYear() < 2000
                    || dateCheck.getMonthValue() > dayNow.getMonthValue()
                    || (dateCheck.getMonthValue() == dayNow.getMonthValue()
                        && dateCheck.getDayOfMonth() > dayNow.getDayOfMonth())){
                System.err.println("Invalid enter date!!!");
                continue;
            }
            break;
        }


        // Confirm student data change //
        System.err.printf("THE INFORMATION OF STUDENT HAVE ID %S WILL BE CHANGE FROM: \n", stu.getID());
        System.out.printf(
                """                            
                        
                                fullName: %s
                                Address: %s
                                Phone number: %s
                                dateOfBirth: %s
                                enterDate: %s
                                Age: %s
                                Age Level: %s
                                
                            TO

                                fullName: %s
                                Address: %s
                                Phone number: %s
                                dateOfBirth: %s
                                enterDate: %s
                                Age: %s
                                Age Level: %s
                        """,
                stu.getFullName(), stu.getAddress(), stu.getTel(),
                stu.getDateOfBirth(), stu.getEnterDate(), stu.getAge(), stu.getAgeLevel(),
                updateName, updateAddress, updateTel, updateDateOfBirth,
                updateEnterDate, updateAge, updateAgeLevel
        );

        System.out.println("\nInput Y to confirm change, or N to cancel!");

        String confirm;
        while (true){
            try {
                confirm = GetInput.getString();
                break;
            } catch (Exception e){
                GetInput.getString();
            }
        }

        // Check confirm and change information for student //
        if (Objects.equals(confirm.toUpperCase(), "Y")){
            stu.setFullName(updateName);
            stu.setAddress(updateAddress);
            stu.setTel(updateTel);
            stu.setDateOfBirth(LocalDate.parse(updateDateOfBirth));
            stu.setEnterDate(LocalDate.parse(updateEnterDate));
            stu.setAge(updateAge);
            stu.setAgeLevel(updateAgeLevel);
        } else {
            return false;
        }

        return true;

    }

    @Override
    public String toString(){
        return  " | Student ID: " + ID + " | fullName: " + fullName + " | address: " + address +
                " | phoneNumber: " + tel + " |" + " DateOfBirth: " + dateOfBirth +
                " | Enter Date: " + enterDate + " | Age: " + age + " | Age level: " + ageLevel + " |";
    }

}
