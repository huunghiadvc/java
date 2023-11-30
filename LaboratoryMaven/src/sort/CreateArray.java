package sort;

import java.util.Random;

public class CreateArray {
    private static final Random random = new Random();
    public static int randomNumber(int min , int max){
        return random.nextInt((max - min + 1)) + min;
    }
    public static int[] create(int number){
        int[] result = new int[number];
        for (int i = 0; i < number; i++) {
            result[i] = randomNumber(0, number);
        }
        return result;
    }
}
