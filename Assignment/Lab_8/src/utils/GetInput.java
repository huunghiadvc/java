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

    public static String getString(){
        String value = "";

        value = input.nextLine();

        return value;
    }

    public static LocalDate getDate(){
        LocalDate value;

        value = LocalDate.parse(input.nextLine());

        return value;
    }

}
