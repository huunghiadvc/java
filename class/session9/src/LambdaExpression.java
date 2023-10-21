import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class LambdaExpression {
    public static void main(String[] args) {
        lab2();
        labStream1();
    }

    static void lab1(){

        //print list String
        List<String> language = Arrays.asList("Java", "C#", "Python", "C++", "Javascript");
        System.out.println("List language : ");
        for (String lang: language) {
            System.out.println(lang);
        }

        //print with lambda
        language.forEach( lang -> {
            System.out.println(lang);
        });

        //another lambda
        language.forEach(System.err::println);

    }

    static void lab2(){
        List<String> languages = Arrays.asList("Java", "C#", "Python", "C++", "Javascript", "1", "2");
        //sort
//        Collections.sort(languages, new Comparator<String>() { // code sort list String by comparator
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.compareTo(o2);
//            }
//        });
//        languages.forEach(System.err::println);


//        Collections.sort(languages, String::compareTo);
//        Collections.sort(languages, String::compareTo);
        languages.sort(String::compareTo);
        languages.forEach(System.err::println);



    }

    // Stream api java8
    static void labStream1(){
        List<Integer> numList = Arrays.asList(1000, 4568, 879, 7, 934, 818, 10, 151, 15);
        List<Integer> results = new ArrayList<>();
//        numList.sort(Integer::compareTo);

        for (Integer num: numList) {
            if (num % 2 == 0) {
                System.err.println(num);
                results.add(num);
            }
        }

        List<Integer> results2 = numList.stream().filter(num -> num % 2 == 0 ).collect(Collectors.toList());
        List<Integer> results3 = numList.stream().filter(num -> num % 2 == 0 ).toList();

        long result4 = numList.stream().filter(num -> num % 2 == 0 ).count();

        IntStream.range(1, 4).forEach(System.err::println);
        IntStream.of(1, 3, 4).forEach(System.err::println);
        DoubleStream.of(1, 3, 4).forEach(System.err::println);
        LongStream.range(1, 4).forEach(System.err::println);
        LongStream.of(1, 3, 4).forEach(System.err::println);

        //filter
        int num1 = numList.stream().filter(num -> num % 2 == 0).findAny().orElse(0); //tifm bat ky
        int num2 = numList.stream().filter(num -> num % 2 == 0).findFirst().orElse(0); // phần tử đầu tiên
        System.err.println(num1);
        System.err.println(num2);

        Optional<Integer> num3 = numList.stream().filter(num -> num % 2 == 0).findAny().orElse(0).describeConstable();    // check null
        // Optional tránh trường hợp NullPointerExceptional
        if (num3.isPresent()){ // result of filter have value, not null
            System.err.println(num3.get());
        }

        List<Integer> num4 = numList.stream().skip(2).limit(2).toList();
        num4.forEach(System.err::println);






    }


}
