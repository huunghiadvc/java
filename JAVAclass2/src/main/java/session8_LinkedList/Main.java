package session8_LinkedList;

public class Main {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new BlockingQueue<>();
        Producer producer = new Producer(queue);
        Producer consumer1 = new Producer(queue);
        Producer consumer2 = new Producer(queue);
        Producer consumer3 = new Producer(queue);
        Consumer consumer4 = new Consumer(queue);
        new Thread(producer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();
        new Thread(consumer3).start();
        new Thread(consumer4).start();
    }
}
