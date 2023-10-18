import utils.NumberUtils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ArrayList {
    public static void main(String[] args) {
        List<String> strs = new ArrayList<>();
        List<Human> humans = new ArrayList<>();
//        init from collection
        String[] str1 = {"1", "2", "3", "4", "5"};
        List<String> str2 = new java.util.ArrayList<>(Arrays.asList(str1));
        // init with capacity
        List<Human> humans = new java.util.ArrayList<>(100);
        // capacity = 10, size = 10 -> add new element, capacity increase 50%

        /************* Method **************/
        // add
        humans.add(new Human());
        humans.add(3, new Human());
        humans.addAll(Arrays.asList(new Human(), new Human()));

        // get
        humans.get(3);
        Human h = new Human();
        System.err.println(humans.indexOf(h));
        // return -1 if not exits

        // remove
        humans.remove(2);

        // clear all element
        humans.clear();

        Human h1 = new Human("Huu Nghia", 2);
        Human h2 = new Human("Thi A", 3);

        List<Human> humans = Arrays.asList(h1, h2); // humans tham chieu den cac phan tu h1, h2

        for (Human h : humans) {
            System.out.println("name: " + h.getName());
        }
        h1.setName("Van B");
        for (Human h : humans) {
            System.out.println("name: " + h.getName());
        }
        for (int i = 0; i < humans.size(); i++){
            System.err.println(humans.get(i));
        }

        //from java 8 - lambda
        humans.forEach(System.err::println);

        List<Student> students = new java.util.ArrayList<>();
        for (Human h : humans
             ) {
            Student s = h.grow();
            if (h != null){
                students.add(s);
            }
        }
        List<Student> studens1 = humans.stream().map(Human::grow).toList();
        ArrayList.testAddArrayList(10000000);
    }

    public static void testAddArrayList(int size){
        Random random = new Random();
        long startTime = System.currentTimeMillis();
        List<Integer> numInts = new java.util.ArrayList<>();
        for (int i = 0; i < size; i++) {
            numInts.add(random.nextInt());
        }
        System.err.println("Time add " + size + " element to list integer: " + (System.currentTimeMillis() - startTime + " ms!"));

        startTime = System.currentTimeMillis();
        List<Long> numLongs = new java.util.ArrayList<>();
        for (int i = 0; i < size; i++) {
            numLongs.add(random.nextLong());
        }
        System.err.println("Time add " + size + " element to list long: " + (System.currentTimeMillis() - startTime + " ms!"));

        startTime = System.currentTimeMillis();
        List<String> numStrings = new java.util.ArrayList<>();
        for (int i = 0; i < size; i++) {
            numStrings.add(random.toString());
        }
        System.err.println("Time add " + size + " element to list string: " + (System.currentTimeMillis() - startTime + " ms!"));

//        startTime = System.currentTimeMillis();
//        List<Student> students = new java.util.ArrayList<>();
//        for (int i = 0; i < size; i++) {
//            students.add(Student.randomStudent());
//        }
//        System.err.println("Time add " + size + " element to list string: " + (System.currentTimeMillis() - startTime + " ms!"));

    }

}
