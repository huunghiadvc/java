package utils;

import java.time.LocalDate;
import java.util.Scanner;

public class GetInput {

    static Scanner input = new Scanner(System.in);

    public static int getInt(){
        int value = 0;

        value = Integer.parseInt(input.nextLine());

        return value;
    }

    public static long getLong(){
        long value = 0;

        value = Integer.parseInt(input.nextLine());

        return value;
    }

    public static String getString(){
        String value = "";

        value = input.nextLine();

        return value;
    }

    public static LocalDate getDate(){
        LocalDate value;
        while (true){
            try {
                value = LocalDate.parse(input.nextLine());
                break;
            } catch (Exception e) {
                System.err.println("Invalid date format, please try again!");
            }
        }

        return value;
    }

}
