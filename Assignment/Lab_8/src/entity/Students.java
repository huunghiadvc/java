package entity;

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

    public static void editStudentInfor(Students stu, Scanner input){

        String editName = "";
        String editAddress = "";
        String editTel = "";

        /** Display current student information and enter the information that needs to be edited **/

        System.out.println("Student fullName: " + stu.fullName);
        System.out.println("Edit Name: " + editName);
        editName = input.nextLine();
        input.nextLine();

        System.out.println("Student address: " + stu.address);
        System.out.println("Edit Address: " + editAddress);
        editAddress = input.nextLine();

        System.out.println("Student phone number: " + stu.tel);
        System.out.println("Edit Phone number: " + editTel);
        editTel = input.nextLine();

        /** Confirm student data change **/
        System.out.printf(
                "The student data whose %d will be changed from:\n" +
                        "\nfullName: %s" +
                        "\nAddress: %s" +
                        "\nPhone number: %s\n" +
                        "\nTO\n" +
                        "\nfullName: %s" +
                        "\nAddress: %s" +
                        "\nPhone number: %s\n" +
                        "\nOLD DA TA WILL BE OVERWRITTEN AND CANNOT BE RESTORE. ARE YOU SURE?" +
                        "\nInput Y to confirm, or anything to cancel!",
                        stu.getID(), stu.getFullName(), stu.getAddress(), stu.getTel(),
                        editName, editAddress, editTel
        );

        String confirm = "";
        try {
            confirm = input.nextLine();
        } catch (Exception e){
            input.next();
        }

        /** Check confirm and change information for student **/
        if (confirm.equals("Y")){
            stu.setFullName(editName);
            stu.setAddress(editAddress);
            stu.setTel(editTel);
            System.out.println("\nDATA CHANGE SUCCESSFULLY!\n");
        }

    }

    public static void deleteStudent(Students stu, Scanner input){

    }

    @Override
    public String toString(){
        return "| Student ID: " + ID + " | fullName: " + fullName + " | address: " + address + " | phoneNumber: " + tel + " |";
    }

}
