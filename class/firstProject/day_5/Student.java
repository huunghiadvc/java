import utils.NumberUtils;
import utils.StringUtils;

public class Student {
    String name;
    private int age;

    public Student() {
        this.name = name;
        this.age = age;
    }

    public static Student randomStudent() {
        Student s = new Student();
        s.name = StringUtils.randomAlphaNumeric(30);
        s.age = NumberUtils.randomNumber(1 , 150);
        return s;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
