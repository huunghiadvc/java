import utils.InputData;
import utils.Display;
import utils.NumberProcessing;

public class Main {

    public static void main(String[] args) {
        while (true) {
            int radix = Display.menu();
            int number = InputData.getNumber();
            String result = NumberProcessing.convertToBinary(number, radix);
            Display.result(number, result, radix);
            System.out.println("\n---***---");
        }
    }

}
