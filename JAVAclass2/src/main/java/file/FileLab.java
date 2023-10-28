package file;

import java.io.File;
import java.util.Date;

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
        File f = new File("./src/etc/demo");
        boolean createFile = f.mkdir();
        System.err.println("Create file : " + createFile);

    }
}
