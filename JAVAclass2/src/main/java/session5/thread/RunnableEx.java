package session5.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RunnableEx implements Runnable {
    private final String threadName;
    public static Integer num;

    public RunnableEx(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        System.err.println("Thread " + threadName + " is running!");
    }

    public static void main(String[] args) {
        Random random = new Random();
        long startTime = System.currentTimeMillis();
        List<Integer> nums = new ArrayList<>();
        // multi thread
        for (int i = 0; i <= 10; i++){
            RunnableEx runnable = new RunnableEx("thread " + i + 1);
            Thread t6 = new Thread(runnable);
            num = random.nextInt();
            t6.start();
            if ((t6.isAlive())){
                nums.add(num);
            }
            try {
                t6.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        nums.forEach(System.out::println);
        System.out.print("\nTime process in multi thread " + (System.currentTimeMillis() - startTime) + " ms\n");
    }

}
