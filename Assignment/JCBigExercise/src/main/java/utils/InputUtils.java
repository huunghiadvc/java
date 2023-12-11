package utils;

import java.util.Scanner;

public class InputUtils {

    private static final Scanner input = new Scanner(System.in);

    public static int getInt(){
        int value = 0;

        value = Integer.parseInt(input.nextLine());

        return value;
    }

    public static double getDouble(){
        double value = 0;

        value = Double.parseDouble(input.nextLine());

        return value;
    }

    public static String getString(){
        String value = "";

        value = input.nextLine();

        return value;
    }
}
