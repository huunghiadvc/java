import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Jva_buoi_3 {
    public static void main(String[] args) {
        int x = 2147483647;
        System.err.println(x + 1);
        System.err.println(x + 5);

        int y = -2147483648;
        System.err.println(y - 1);
        System.err.println(y - 5);

        int a = 3; // primitive , default = 0 -> phải luôn luôn có giá trị
        Integer b = null; // object wrapper class , default = null -> dạng object có thể nhận giá trị null

        // wrapper class
            int num1 = 1;
            Integer num2 = Integer.valueOf(num1); // chủ động ép kiểu
            Integer num3 = num1; // autoBoxing
            int num4 = num3; //unBoxing
            // NullPointerException: khi 1 giá trị bắt buộc unable null mà phải nhận giá trị null

        //Char
            char char1 = 'a'; //primitive
            Character char2 = null; //wrapper
            System.err.println("tab\tchar");
            System.err.println("tab\bchar");
            System.err.println("tab\nchar");

        //String
            String s1 = "a"; // biến s1 set = a sẽ tạo ra giá trị text a trong String pool, biến a sẽ được tham chiếu đến giá trị a trong String pool
            String s2 = "a"; // check giá trị "a" có tồn tại trong String pool hay không, nếu có biến s2 sẽ tham chiếu đến giá trị "a" cùng s1.
            System.err.println(s1==s2); // tham chiếu. not alway true
            System.err.println(s1.equals(s2)); // recommend
            System.err.println(s1.equalsIgnoreCase(s2)); // không phân biệt chữ hoa - chữ thường
            String text = "12312,32121,12345,54432";
            String[] mssisdns = text.split(",");
            for (String miss : mssisdns) {
                System.err.println(miss);
            }

        DongVat myDog = new Cho("Tun", 40.2, 30.9);
        System.err.println(myDog.getInfor());
        myDog.move();
        myDog.makeNoise();

        // "==" là phép so sánh tham chiếu
    }
}
