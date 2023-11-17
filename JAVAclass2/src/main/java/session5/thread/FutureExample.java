package session5.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
public class FutureExample {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<String, String>();
        List<Future<Integer>> ls = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        Callable<Integer> callable;
        Random random = new Random();
        Future<Integer> future;
        for (int i = 0; i < 10; i++) {
            callable = new RandomIntegerCallable(i, random);
            future = executorService.submit(callable); // return result in future
            ls.add(future);
        }
        executorService.shutdown();
        while (!executorService.isTerminated()){
        }
        ls.forEach(f -> {
            try {
                Integer num = f.get();
                System.out.println(num);
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
