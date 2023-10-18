package entity;

public class Students {
    public static Object setID;
    private static int ID;
    private String fullName;
    private String address;
    private String tel;

    public Students() {
    }
    public Students(int ID, String fullName, String address, String tel) {
        Students.ID = ID;
        this.fullName = fullName;
        this.address = address;
        this.tel = tel;
    }

    @Override
    public String toString(){
        return "| Student ID: " + ID + " | fullName: " + fullName + " | address: " + address + " | phoneNumber: " + tel + " |";
    }
}
