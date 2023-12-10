package Exception;

import Exception.override.Child;

import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        try {
            child.send();
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
