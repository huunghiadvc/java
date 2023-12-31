import utils.ConsoleUtils;
import utils.numbersUtils;

public class Main {
    public static void main(String[] args) {
        System.out.println("Please enter a: ");
        int a = ConsoleUtils.getMinValue(0, null);
        System.out.println("Please enter b: ");
        int b = ConsoleUtils.getMinValue();
        // Solution 1:
        int UCLN = 0;
        for (int i = 1; i <= numbersUtils.getMinValue(a,b) ; i++) {
            if (a % i ==0 && b % i ==0) {
                UCLN = i;
            }
        }
        System.out.printf("UCLN cua %d va %d la: %d",
                a, b, UCLN
        );
        System.out.printf("UCLN cua %d va %d la: %d",
                a, b,
                (a > b) ? numbersUtils.findUCLN(a, b) : numbersUtils.findUCLN(b, a)
        );
    }
}
