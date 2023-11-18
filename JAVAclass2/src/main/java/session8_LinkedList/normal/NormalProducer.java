package session8_LinkedList.normal;

import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;

public class NormalProducer implements Runnable {
    private final Queue<Integer> queue;

    public NormalProducer(Queue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(2000);
                int num = ThreadLocalRandom.current().nextInt();
                queue.add(num);
                System.err.println("Queue size = " + queue.size());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
