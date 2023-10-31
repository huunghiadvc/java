package utils;

public class MenuUtils {
    public static void mainMenu(){
        System.out.println("---------------*****---------------");
        System.out.println("Select option below:");
        System.out.println("    1. Add new customer.");
        System.out.println("    2. Show customer list.");
        System.out.println("    3. Edit customer information by ID.");
        System.out.println("    4. Delete customer information by ID.");
        System.out.println("    5. Export.");
        System.out.println("    6. Import.");
        System.out.println("    7. Exit.");
        System.out.println(" ");
        System.out.println("Input your choose: ");
    }

    public static void showAccountMenu(){
        System.out.println("    1. Show all account list.");
        System.out.println("    2. Show VISA type list.");
        System.out.println("    3. Show JCB type list.");
        System.out.println("    4. Show HYBRID type list.");
        System.out.println("Input your choose: ");
    }

}
