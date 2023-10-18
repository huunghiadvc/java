package entity;

import utils.Display;

import java.util.Objects;
import java.util.Scanner;

public class Students {
    private int ID;
    private String fullName;
    private String address;
    private String tel;

    public Students() {
    }
    public Students(int ID, String fullName, String address, String tel) {
        this.ID = ID;
        this.fullName = fullName;
        this.address = address;
        this.tel = tel;
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

    public static void AddStudent(){
        Scanner input = new Scanner(System.in);
        int ID = 0;
        String fullName = null;
        String address = null;
        String tel = null;
        while (true) {
            try {
                // Input ID
                System.out.println("Input student ID: ");
                ID = Integer.parseInt(input.nextLine());

                // Input name
                System.out.println("Input student name: ");
                fullName = input.nextLine();

                // Input address
                System.out.println("Input student address: ");
                address = input.nextLine();

                // Input phone number
                System.out.println("Input student phone number: ");
                tel = input.nextLine();
                break;
            } catch (Exception e) {
                System.err.println("Invalid data format!!!");
                input.nextLine();
            }
        }

        Students stu = new Students(ID, fullName, address, tel);
        StudentsList.add(stu);
        System.out.println("|---------------****---------------|");
        System.out.println("|---- Add Student Successfully ----|");
        System.out.println("|----------------****--------------|");
        Display.menuDisplay();
    }

    public static void editStudentInfor(Students stu, Scanner input){

        String editName;
        String editAddress;
        String editTel;
        /** Display current student information and enter the information that needs to be edited **/
        while (true){
            try {
                System.out.println("Student fullName: " + stu.fullName);
                System.out.println("Edit Name: ");
                editName = input.nextLine();

                System.out.println("Student address: " + stu.address);
                System.out.println("Edit Address: ");
                editAddress = input.nextLine();

                System.out.println("Student phone number: " + stu.tel);
                System.out.println("Edit Phone number: ");
                editTel = input.nextLine();
                break;
            } catch (Exception e){
                System.err.println("Invalid format.");
            }
        }

        /** Confirm student data change **/
        System.err.printf("The student data whose %d will be changed from:", stu.getID());
        System.out.printf(
                        "fullName: %s" +
                        "\nAddress: %s" +
                        "\nPhone number: %s\n" +
                        "\nTO\n" +
                        "\nfullName: %s" +
                        "\nAddress: %s" +
                        "\nPhone number: %s\n" +
                        "\nOLD DA TA WILL BE OVERWRITTEN AND CANNOT BE RESTORE. ARE YOU SURE?" +
                        "\nInput Y to confirm, or anything to cancel!\n",
                        stu.getFullName(), stu.getAddress(), stu.getTel(),
                        editName, editAddress, editTel
        );

        String confirm = "";
        try {
            confirm = input.next();
        } catch (Exception e){
            input.next();
        }

        /** Check confirm and change information for student **/
        if (Objects.equals(confirm, "Y")){
            stu.setFullName(editName);
            stu.setAddress(editAddress);
            stu.setTel(editTel);
            System.out.println("\nDATA CHANGE SUCCESSFULLY!\n");
        }

        Display.menuDisplay();
    }

    @Override
    public String toString(){
        return "| Student ID: " + ID + " | fullName: " + fullName + " | address: " + address + " | phoneNumber: " + tel + " |";
    }

}
