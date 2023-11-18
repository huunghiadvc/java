package session8_LinkedList;

public class Consumer implements Runnable {
    private final BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true){
            try {
                queue.take();
                Thread.sleep(1000);
                System.err.println("Queue size : " + queue.size());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            // 1000 ms : producer put 20 element , consumer take 100 element

        }
    }
}
