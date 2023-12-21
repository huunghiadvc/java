package service;

import dao.FileService;
import dao.impl.FileServiceImpl;
import entity.Student;
import java.util.ArrayList;
import java.util.List;

public class StudentFileService extends FileServiceImpl<Student> {
    public StudentFileService() {
        super(Student.class);
    }

    @Override
    protected Student rowMapper(String line) {
        if (line.isEmpty()) return null;

        String[] chars = line.split("\\|");

        return Student.builder()
                .id(Long.parseLong(chars[0]))
                .name(String.valueOf(chars[1]))
                .address(String.valueOf(chars[2]))
                .tel(String.valueOf(chars[3]))
                .build();
    }

    public static void main(String[] args) {
        Student student = new Student("Nghia", "CVao bang", "1223");
        Student student2 = new Student("r32324324rr33r223r32", "CVao23r3r bang", "r3242341223");
        Student student3 = new Student("DWDEE3243r32r3224QQW", "CVao RWQRQWbang", "1222143213");
        Student student4 = new Student("DWDEQr32r32WEQWEEQQW", "CVaoRQWRWQR bang", "1212421423");
        Student student5 = new Student("DWDEEFGWE3r232rr323WEFQQW", "CVao FWEWEFbang", "124132421423");
        Student student6 = new Student("DWDEFEWFWr23r2EFEQQW", "CVao WEFWEFbang", "15325223");
        Student student7 = new Student("DWDWEFEWFEEQQW", "CVao EWFWEFbang", "12523523");
        Student student8 = new Student("DWDWEFWEFEEQQW", "CVao EWFWEFbang", "1235235223");
        Student student9 = new Student("DWDEFEWFEWFEQQW", "CVaoFWEF bang", "1235253223");

        List<Student> students = new ArrayList<>();
        students.add(student2);
        students.add(student);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        students.add(student6);
        students.add(student7);
        students.add(student8);
        students.add(student9);
//        Map<String, String> updateLog = new HashMap<>();
//        updateLog.put("name", "Nghia hahaha");
        FileService<Student> service = new StudentFileService();
//        service.updateById(1, updateLog);
        service.deleteById(2);
//        service.writeToFile(students);
//        List<Student> list = service.fileReader();
//        System.out.println(list);
    }
}
