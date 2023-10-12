package utils;

import java.util.Scanner;

public class InputData {
    public static int inputInt(){
        Scanner input = new Scanner(System.in);
        int m;
        System.out.println("Nhap so phan tu mang:");
        m = input.nextInt();
        return m;
    }
    public static void arrayInputValue(int[] arrNumbers, int a){
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < a; i++) {
            System.out.printf("Nhap phan tu arrNumbers[%d]", i);
            arrNumbers[i] = input.nextInt();
        }
    }
}
