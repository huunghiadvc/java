package DesignPattern;

import java.util.ArrayList;
import java.util.List;

public class Students {
    private static List<String> students;

    public static List<String> getBatchStudent(int offset, int limit){
        if (students == null){
            students = new ArrayList<>();
        }
        return students.stream().skip(offset).limit(limit).toList();
    }

    public static List<String> getBatchStartByChar(int offset, int limit, String startChar){
        return students.stream().skip(offset).filter(item -> item.startsWith(startChar)).limit(limit).toList();
    }

    public static void addStudent(List<String> moreStudent){
        if (students == null){
            students = new ArrayList<>();
        }
        students.addAll(moreStudent);
    }


}
