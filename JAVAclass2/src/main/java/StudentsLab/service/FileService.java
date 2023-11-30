package session3.StudentsLab.service;

import java.io.*;
import java.util.Scanner;

public class FileService {
    private static final String urlFile = "./src/main/java/StudentsLab/student.txt";
    public static void fileWritter(String stuList) throws IOException {
        FileWriter writer = null;
        try {
            writer = new FileWriter(urlFile, true);
            writer.write(stuList);
            System.out.println("Successfully!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            assert writer != null;
            writer.close();
        }
    }
    public static String fileAccountReader() throws IOException {
        InputStream inputStream = null;
        Scanner scanner;
        try {
            inputStream = new FileInputStream(urlFile);
            scanner = new Scanner(inputStream);
            StringBuilder str = new StringBuilder();
            while (scanner.hasNextLine()){
                str.append(scanner.nextLine());
            }
            return str.toString();
        }catch (FileNotFoundException e) {
            System.err.println("File not found!" + e.getMessage());
        } finally {
            assert inputStream != null;
            inputStream.close();
        }
        return null;
    }
}
