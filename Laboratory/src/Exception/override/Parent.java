package Exception.override;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class Parent {
    public void send() throws ExecutionException {
        System.out.println("Parent class!");
    }
}
