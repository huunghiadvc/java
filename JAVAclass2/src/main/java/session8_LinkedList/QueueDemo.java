package session8_LinkedList;

import org.apache.commons.lang3.StringUtils;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueDemo {
    public static void main(String[] args) {
//        Queue<Integer> ids = new LinkedList<>();
//
//        // Queue
//        for (int i = 0; i < 10; i++) {
//            ids.offer(i); // offer : add element into last position , return boolean
//            if (i==9){
//                ids.add(i+91); // add : add element into last position ,false -> exception
//            }
//        }

        // TODO: 18/11/2023 add -> exception
        // TODO: 18/11/2023  offer -> boolean

        // Poll lay ra 1 phan tu dau tien trong hang doi
//        Integer id1 = ids.poll();
//        System.err.println(id1);
//        Integer id2 = ids.poll();
//        System.err.println(id2);

        // TODO: 18/11/2023 poll -> boolean
        // TODO: 18/11/2023 remove -> exception

//        while (true){
//            Integer id = ids.poll();
//            if (id == null) continue;
//            System.out.println(id);
//        }

        // Priority queue :
        PriorityQueue<String> names = new PriorityQueue<>();
        names.offer("A");
        names.offer("B");
        names.offer("C");

        while (true){
            String name = names.poll();
            if (name == null) continue;
            System.out.println(name);
        }

    }
}
