package file;

import lombok.Student;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class FileLab {
    public static void main(String[] args) {
        lab2();
    }
    public static void lab1(){
        File file = new File("./src/etc/demo.txt"); // relative path
        System.err.println(file.canRead());
        System.err.println(file.getAbsolutePath());
        System.err.println("File exist : " + file.exists());
        if (file.isFile()){
            System.err.println("is Directory : " + file.isDirectory());
            System.err.println("Hidden item : " + file.isHidden());
            System.err.println("Size : " + file.length()); // bytes
            System.err.println("Last modified : " + new Date(file.lastModified()));
        }
    }
    public static void lab2(){
        File directory = new File("./src/etc");
        System.err.println("Folder exists : " + directory.exists() +
                "\nabsolute path : " + directory.getAbsolutePath() +
                "\nparent folder : " + directory.getParentFile().getAbsolutePath()
        );
        File f = new File("./src/etc/demo/demo_2.txt");
        boolean createFile = f.mkdir();
        System.err.println("Create file : " + createFile);
    }
    public static void readFile() {
        List<Student> students = new ArrayList<>();
        String header = "ID|Name|Address|Birthday|";
        String url = "./src/etc/demo.txt";
        Scanner scanner = null;
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(url);
            scanner = new Scanner(inputStream);
            while (scanner.hasNextLine()){
                String str = scanner.nextLine();
                Student s = Student.convert(str, header);
                if (!Objects.isNull(s)) {
                    students.add(s);
                }
            }
        }catch (FileNotFoundException e) {
            System.err.println("File not found!" + e.getMessage());
        } finally {
            try {
                assert inputStream != null;
                inputStream.close();
            } catch (IOException e) {
                System.err.println("IOException " + e.getMessage());
            }
        }
        for (Student stu: students) {
            System.out.println(stu);
        }
    }
}
