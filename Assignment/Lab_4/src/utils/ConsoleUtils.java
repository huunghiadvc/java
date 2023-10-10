package utils;

import java.util.Scanner;

public class ConsoleUtils {
    public static int getMinValue(Integer minValue , Integer maxValue){  // same name  , same output type  , different input
        // overloading
        Scanner input = new Scanner(System.in);
        boolean valid = true;
        int n = 0;
        while (valid){
            System.out.println("");
            try {
                n = input.nextInt();
                if (minValue != null) {  // only run here pass minValue  != null
                    if (n < minValue) {
                        System.out.println("Not in valid arrange ,please try again!");
                    } else {
                        valid = false;
                    }
                }
                if (maxValue != null) {  // only run here pass minValue  != null
                    if (n > maxValue) {
                        System.out.println("Not in valid arrange ,please try again!");
                    } else {
                        valid = false;
                    }
                }
            } catch (Exception ex){
                input.nextLine();
            }
        }
        return n;
    }
    public static int getMinValue(int minValue , int maxValue){  // same name  , same output type  , different input
        // overloading
        Scanner scanner = new Scanner(System.in);
        boolean valid = true;
        int n = 0;
        while (valid){
            System.out.println("");
            try {
                n = scanner.nextInt();
                if( n < minValue || n > maxValue){
                    System.out.println("Not in valid arrange ,please try again!");
                }else{
                    valid = false;
                }
            } catch (Exception ex){
                // throw exception here
                scanner.nextLine();
            }
        }
        return n;
    }
    public static int getMinValue(){
        Scanner scanner = new Scanner(System.in);
        boolean valid = true;
        int n = 0;
        while (valid){
            System.out.println("");
            try {
                n = scanner.nextInt();
                valid = false;
            } catch (Exception ex){
                // throw exception here
                scanner.nextLine();
            }
        }
        return n;
    }
}