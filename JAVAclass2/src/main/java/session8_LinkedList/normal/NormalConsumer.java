package session8_LinkedList.normal;

import session8_LinkedList.BlockingQueue;

import java.util.Queue;

public class NormalConsumer implements Runnable {
    private final Queue<Integer> queue;

    public NormalConsumer(Queue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true){
            try {
                queue.remove();
                Thread.sleep(1000);
                System.err.println("Queue size : " + queue.size());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            // 1000 ms : producer put 20 element , consumer take 100 element

        }
    }
}
