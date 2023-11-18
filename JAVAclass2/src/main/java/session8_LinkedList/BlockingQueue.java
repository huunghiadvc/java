package session8_LinkedList;

import java.util.LinkedList;

public class BlockingQueue<T> {
    private static final int capacity = 10;
    private final LinkedList<T> ls = new LinkedList<>();
    // đảm bảo thread-safe -> synchronized
    public synchronized void put(T value) throws InterruptedException {
        while (ls.size() == capacity){
            System.err.println("Blocking Queue is full!");
            // wait
            wait();
        }
        // ls.size < 10
        ls.addLast(value);
        notifyAll();
    }
    // khi nào cần đồng bộ hóa thread thì sử dụng synchronized
    // TODO: 18/11/2023 không được lạm dụng synchronized vì slow
    public synchronized T take() throws InterruptedException {
        while (ls.isEmpty()){
            System.err.println("Blocking Queue is empty!");
            wait();
        }
        notifyAll();
        return ls.removeFirst();
    }
    public synchronized int size(){
        return ls.size();
    }
}
