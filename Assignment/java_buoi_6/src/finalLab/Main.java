package finalLab;

public class Main {
    // final use for variable , function , class .
    // final variable : cannot assign vale after first-time;
    // final function : cannot override by sub-class
    public static final String Const = "CONST-VALUE"; // Duy nhat trong 1 chuong trinh va khong thay doi
    public void func1(){
        final String strs = "Hello!";
    }
    public static void main(String[] args) {
        System.out.println(DayInWeek.Monsday);
    }
}
