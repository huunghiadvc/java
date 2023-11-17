package session5.thread;

import java.util.Random;
import java.util.concurrent.Callable;

public class RandomIntegerCallable implements Callable<Integer> {
    private int num;
    private Random random;

    public RandomIntegerCallable(int num, Random random) {
        this.num = num;
        this.random = random;
    }

    @Override
    public Integer call() throws Exception {
        long startTime = System.currentTimeMillis();
        // emulator process time of thread
        Thread.sleep(random.nextInt(10) * 1000);
        System.err.println((System.currentTimeMillis() - startTime) + " ms");
        return num * num * num;
    }
}
