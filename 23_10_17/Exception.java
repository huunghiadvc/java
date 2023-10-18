import session_7.InvalidAgeException;

public class Exception {
    public Exception(String message) {
    }

    public static void main(String[] args) {
//        try {
//            String a = "sdee";
//            int num = Integer.parseInt(a);
//            System.err.println(num);
//        } catch (java.lang.Exception e){
//            System.err.println("Error " + e.getMessage());
//        } finally {
//            System.out.println("Hello!");
//        }

    }

    public static void checkAge(int age){
        try {
            if (age < 18) {
                throw new InvalidAgeException("Not Enough 18 age");
            }
        } catch (InvalidAgeException e) {
            e.printStackTrace();
        }
    }

}
