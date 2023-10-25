package staticDefaultMethodInterface;

public class Main {
    // là 1 method non abstract
    // có thể dùng non abstract method trong interface bằng default
    // không cần ghi đè với default method trong interface
    /*
        - Dễ dàng mở rộng interface mà không ảnh hưởng đến class implements
        - tránh dùng class utils
        - ứng dụng trong lambda
    */
    // static khác default: không thể ghi đè

    public static void main(String[] args) {
        Rectangular obj = new Rectangular();
        obj.setColor("red");
    }
}
