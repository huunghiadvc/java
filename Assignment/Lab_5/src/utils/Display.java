package utils;

public class Display {

    public static int menu(){
        System.out.println("SELECT ONE OF THE OPTIONS BELOW:");
        System.out.println("1. Convert decimal number to binary number.");
        System.out.println("2. Convert decimal number to trinary number.");
        System.out.println("3. Convert decimal number to quaternary number.");
        System.out.println("4. Convert decimal number to quinary number.");
        System.out.println("5. Convert decimal number to senary number.");
        System.out.println("6. Convert decimal number to septenary number.");
        System.out.println("7. Convert decimal number to octonary number.");
        System.out.println("8. Convert decimal number to novenary number.");
        System.out.println("9. Exit.");
        System.out.println("Input your choose:");
        int a = InputData.getChoose();
        return a;
    }

    public static void result(int number, String result, int radix){
        switch (radix){
            case 2:
                System.out.printf("Binary number of %d is: %s", number, result);
                break;
            case 3:
                System.out.printf("Trinary number of %d is: %s", number, result);
                break;
            case 4:
                System.out.printf("Quaternary number of %d is: %s", number, result);
                break;
            case 5:
                System.out.printf("Quinary number of %d is: %s", number, result);
                break;
            case 6:
                System.out.printf("Senary number of %d is: %s", number, result);
                break;
            case 7:
                System.out.printf("Septenary number of %d is: %s", number, result);
                break;
            case 8:
                System.out.printf("Octonary number of %d is: %s", number, result);
                break;
            case 9:
                System.out.printf("novenary number of %d is: %s", number, result);
                break;
        }
    }

}
