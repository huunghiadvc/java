package Static_Final;

import static Static_Final.ImportStatic.*;

public class StaticDemo {
    public static int intStatic = 0;
    public int intNonStatic = 1;
    // biến static thuộc về class chứ không phải thể hiện của class đó

    public static void methodStatic(){
        System.out.println("Hello, this is static method");
    }
    // khai báo method với static -> static method

    static {
        int x = 0;
    }
    // static block khởi tạo thành viên dữ liệu static


    public static class classStatic {
        public static String hi = "Hello world!";
        public static void hello(){
            System.out.println("Hello, this is static method");
            System.out.println(importStatic);
        }
    }
    // 1 class có thể đặt static chỉ khi class đó là nested class - class nằm trong 1 class khác


}
