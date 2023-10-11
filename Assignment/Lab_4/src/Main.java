import utils.InputNumber;
import utils.NumberProcesing;


public class Main {
        public static void main(String[] args) {
            System.out.println("Enter a number: ");
            int num = InputNumber.getValue();
            int result = NumberProcesing.sumOfDigits(num);

            System.err.printf("Sum of digits: %d", result);
        }
    }
