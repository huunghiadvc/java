import java.util.List;
import java.util.Random;

public class LinkedList {
    public static void main(String[] args) {
        testAddLinkedList(10000000);
    }
    public static void testAddLinkedList(int size){
        Random random = new Random();
        long startTime = System.currentTimeMillis();
        java.util.LinkedList<Integer> numInts = new java.util.LinkedList<>();
        for (int i = 0; i < size; i++) {
            numInts.add(random.nextInt());
        }
        System.err.println("Time add " + size + " element to list integer: " + (System.currentTimeMillis() - startTime + " ms!"));

        startTime = System.currentTimeMillis();
        java.util.LinkedList<Long> numLongs = new java.util.LinkedList<>();
        for (int i = 0; i < size; i++) {
            numLongs.add(random.nextLong());
        }
        System.err.println("Time add " + size + " element to list long: " + (System.currentTimeMillis() - startTime + " ms!"));

        startTime = System.currentTimeMillis();
        java.util.LinkedList<String> numStrings = new java.util.LinkedList<>();
        for (int i = 0; i < size; i++) {
            numStrings.add(random.toString());
        }
        System.err.println("Time add " + size + " element to list string: " + (System.currentTimeMillis() - startTime + " ms!"));

//        startTime = System.currentTimeMillis();
//        java.util.LinkedList<Student> students = new java.util.LinkedList<>();
//        for (int i = 0; i < size; i++) {
//            students.add(Student.randomStudent());
//        }
//        System.err.println("Time add " + size + " element to list string: " + (System.currentTimeMillis() - startTime + " ms!"));

    }
}
