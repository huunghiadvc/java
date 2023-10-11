package utils;

import java.util.Scanner;

public class InputNumber {
    public static int getValue(){
        Scanner input = new Scanner(System.in);
        int a;
        while (true){
            System.out.println("");
            try {
                a = input.nextInt();
                if (a == 0){
                    System.err.println("The number entered is invalid!!!");
                } else {
                    break;
                }
            } catch (Exception ex){
                input.nextLine();
            }
        }
        return a;
    }
}
