package session8_LinkedList.normal;

import session8_LinkedList.Consumer;
import session8_LinkedList.Producer;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        NormalProducer producer = new NormalProducer(queue);
        NormalConsumer consumer1 = new NormalConsumer(queue);
        NormalConsumer consumer2 = new NormalConsumer(queue);
        NormalConsumer consumer3 = new NormalConsumer(queue);
        NormalConsumer consumer4 = new NormalConsumer(queue);
        new Thread(producer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();
        new Thread(consumer3).start();
        new Thread(consumer4).start();
    }
}
