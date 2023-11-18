package utils;

public class MainMenu {
    public static void show(){
            System.out.println("\n------------------*****------------------");
            System.out.println("    SELECT OPTION BELOW:");
            System.out.println(" ");
            System.out.println("        --- BANK ACCOUNT ---");
            System.out.println("    1. Add new bank account.");
            System.out.println("    2. Change bank account information by ID.");
            System.out.println("    3. Delete bank account information by ID.");
            System.out.println("        --- SHOW DATA ---");
            System.out.println("    4. Show bank account list.");
            System.out.println("    5. Show transaction list.");
            System.out.println("        --- FILE SERVICE ---");
            System.out.println("    6. Import bank account from file.");
            System.out.println("    7. Import transaction from file.");
            System.out.println("    8. Export account data to file.");
            System.out.println("    9. Export transaction data to file.");
            System.out.println("        --- DATABASE SERVICE ---");
            System.out.println("    10. Insert account data to database.");
            System.out.println("    11. Insert transaction data to database.");
            System.out.println("    12. Update transaction to list and database.");
            System.out.println("    13. Exit.");
            System.out.println(" ");
            System.out.println("Input your choose: ");
    }

}
