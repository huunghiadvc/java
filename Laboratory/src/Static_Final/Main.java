package Static_Final;

import java.lang.reflect.Array;

import static Static_Final.ImportStatic.importStatic;

public class Main {
    public static void main(String[] args) {
//        System.out.println(StaticDemo.classStatic.hi);
//        StaticDemo.classStatic.hello();
//        StaticDemo.methodStatic();
//        System.out.println(StaticDemo.intStatic);
//
//        StaticDemo staticDemo = new StaticDemo();
//        System.err.println(staticDemo.intStatic);

        int x = 10;
        int y = new Integer(10);
        int z = new Integer(10);

        int a = x + y;

        System.out.println(y == z);

    }
}
