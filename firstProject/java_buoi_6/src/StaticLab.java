public class StaticLab {
    // static belong class , not instance
    // user static for variable , method , block , class

    // variable
    public static int num = 1; // biến tĩnh

    // method
    public static int getNum(){
        return num;
    }

    // block static
    // use for: create, or change static variable value
    static {
        num = 2;
    }

    // class static


}
