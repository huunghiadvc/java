package utils;

import java.util.Objects;
import java.util.Scanner;

public class InputData {

    public static int getChoose(){
        Scanner input = new Scanner(System.in);
        int number = 0;
        while (true){
            System.out.println("");
            try {
                number = input.nextInt();
                if (number >= 1 && number <= 8) {
                    break;
                } else if (number == 9) {
                    System.out.println("Press Y to exit the program, press N to cancel.");
                    String userCollect = input.next();
                    if (Objects.equals(userCollect, "Y")) {
                        System.exit(0);
                    } else {
                        System.out.println("---***---");
                        Display.menu();
                    }
                } else {
                    System.err.println("Please select options 1-8!!!");
                }
            } catch (Exception ex){
                input.nextLine();
            }
        }
        return number + 1;
    }
    public static int getNumber(){
        Scanner input = new Scanner(System.in);
        boolean valid = true;
        int number = 0;
        System.out.println("Enter a number: ");
        while (valid){
            System.out.println("");
            try {
                number = input.nextInt();
                valid = false;
            } catch (Exception ex){
                input.nextLine();
            }
        }
        return number;
    }
}
