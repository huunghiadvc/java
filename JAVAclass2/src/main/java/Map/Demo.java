package Map;

import lombok.Student;
import utils.NumberUtils;
import utils.StringUtils;

import java.io.*;
import java.util.*;

public class Demo {
    public static void main(String[] args) {
        listConvert();
    }
    public static void lab1(){

        // init map: Map < key data type, value data type >
        Map<Integer, String> mapDemo = new HashMap<>();

        // add to Map
        mapDemo.put(1 , "Vinfast");
        mapDemo.put(1 , "BMW");
        mapDemo.put(2 , "Toyota");
        mapDemo.put(3 , "Santa-fe");
        mapDemo.put(4 , "VIOS");
        mapDemo.put(5 , "Huyndai");

        // foreach by key
        System.out.println("ForEach by key:");
        for ( Integer key : mapDemo.keySet()){
            System.err.println("Key " + key + " have value: " + mapDemo.get(key));
        }

        // foreach by entry ( KEY - VALUE )
        System.out.println("ForEach by entry:\n");
        for ( Map.Entry<Integer, String> entry : mapDemo.entrySet()){
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.err.println("Key " + key + " have value: " + mapDemo.get(key));
        }

        // lambda
        System.out.println("Lambda:");
        mapDemo.entrySet().stream().forEach(entry -> {
            System.err.println("Key " + entry.getKey() + " have value: " + mapDemo.get(entry.getKey()));
        });

        mapDemo.forEach((key, value) -> System.err.println("Key " + key + " have value: " + mapDemo.get(key)));

        mapDemo.clear(); // clear all element
        mapDemo.size(); // sizing map

    }

    public static void listConvert(){
        // tạo 1 HashMap lưu danh sách học sinh random với khóa là id học sinh
        int number = 100;
        Map<Integer, Student> studentList = new HashMap<>();

        for (int i = 0; i < number; i++){
            Student s = Student.builder()
                            .id(i)
                            .name(StringUtils.randomAlphaNumeric(20))
                            .address(StringUtils.randomAlphaNumeric(200))
                            .tel(NumberUtils.randomNumber(10, 10))
                            .build();
            studentList.put((int) s.getId(), s);
        }

        studentList.forEach((key , value) ->
                System.err.println("Key : " + key + " have info: " + studentList.get(key)));

        // get List key
//        Set<Integer> ketSet = studentList.keySet();
//        List<Integer> keys = new ArrayList<>(ketSet); //get list key of hashmap
//        for (Integer key : keys){
//            System.out.println(key);
//        }
//        Collection<Student> valueSet = studentList.values(); // get list value of hash map
//        List<Student> stu_1 = new ArrayList<>(valueSet);
//        stu_1.forEach(System.err::println);





        File f = new File("./src/etc/customer.txt");
        PrintWriter out = null;

        for ( Integer key : studentList.keySet()){
            try {
                out = new PrintWriter(new BufferedWriter(
                        new FileWriter("./src/etc/demo/customer.txt", true)
                ));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            out.println(studentList.get(key)+"\n");
            out.close();
        }

    }

}
