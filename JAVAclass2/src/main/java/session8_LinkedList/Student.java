package session8_LinkedList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

@Data
@Builder
@AllArgsConstructor
public class Student implements Comparable<Student> {
    private int id;
    private String name;
    private String address;
    private int age;

    public int getPriorityLevel(int a){
        if (a <= 6){
            return 1;
        }
        if (a >= 60 ){
            return 2;
        }
        return 3;
    }

    @Override
    public int compareTo(Student o) {
        int thisPrio = getPriorityLevel(this.age);
        int oPrio = getPriorityLevel(o.age);
        return Integer.compare(thisPrio, oPrio);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) throws InterruptedException {
        Queue<Student> students = new PriorityQueue<>();
        students.offer(new Student(5, "A", "Address 1", 40));
        students.offer(new Student(4, "B", "Address 2", 30));
        students.offer(new Student(2, "C", "Address 3", 80));
        students.offer(new Student(3, "D", "Address 4", 4));
        students.offer(new Student(1, "E", "Address 5", 5));
        students.offer(new Student(6, "E", "Address 6", 90));

        for (Student s : students) {
            System.out.println(s);
        }
        System.out.println("Value after remove element : ");
        System.out.println(students.poll());
        System.out.println(students.poll());
        System.out.println(students.poll());
        System.out.println(students.poll());
        System.out.println(students.poll());
        System.out.println(students.poll());


    }

}
