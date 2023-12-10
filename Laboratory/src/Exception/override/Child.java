package Exception.override;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class Child extends Parent {
    @Override
    public void send() throws ExecutionException {
        try {
            int[] a = new int[10];
            for (int i = 0; i < 11; i++) {
                a[i] = i;
            }
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
    }
}
