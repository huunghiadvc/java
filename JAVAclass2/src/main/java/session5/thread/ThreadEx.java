package session5.thread;

import java.util.Random;

public class ThreadEx extends Thread {
    public void run(){
        System.err.println("Thread is running...");
    }

    public static void main(String[] args) {
//        ThreadEx t = new ThreadEx();
//        t.start();
//
//        RunnableEx runnable = new RunnableEx();
//        Thread t2 = new Thread(runnable);
//        Thread t3 = new Thread(runnable);
//        t2.start();
//        t3.start();

        long startTime = System.currentTimeMillis();

        // single thread
        for (int i = 0; i <= 10; i++){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.err.println("Time process in single thread " + (System.currentTimeMillis() - startTime) + "ms");

    }
}
