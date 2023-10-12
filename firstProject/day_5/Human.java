public class Human {
    String name = "";
    private int age;


    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student grow(){
        Student s = null;
        if (this.getAge() >= 3){
            s = new Student();
            s.setName(this.getName());
            s.setAge(this.getAge());
        }
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
