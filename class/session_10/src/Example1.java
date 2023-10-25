import java.util.Arrays;
import java.util.List;

public class Example1 {
    @FunctionalInterface
    interface ExecutorInterface{
        public int execute(int a, int b);
    }

    // :: , () -> {} : method reference

    public static void main(String[] args) {
        int a = 30;
        int b = 40;
        System.err.println("a + b = " + MathUtils.sum(a,b));
        System.err.println("a + b = " + execute(a,b,MathUtils::sum));

        List<String> strs = Arrays.asList("Demo ", "Demo1");
        strs.stream().forEach(System.err::println);

        // non static
        MathUtilsNonStatic obj = new MathUtilsNonStatic();
        System.err.println("a + b = " + execute(a,b,obj::sum));

    }
    public static int execute(int a, int b, ExecutorInterface executorInterface){
        return executorInterface.execute(a,b);
    }


}
