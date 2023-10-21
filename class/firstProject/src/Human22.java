
public class Human22 {

    private String name;
    int age;
    double weight;
    String address;
    String email;
    String tel;
    //Attribute

    public String getName(){ // getter
        return this.name;
    }

    public void setName(String name){ // setter
        this.name = name;
    }

    public void sayHi() {
        System.out.println("Xin Chao " + this.name);
    }

    public void sayHi_2() {
        String trinhDo;

        if (age < 3){
            trinhDo = "Trẻ sơ sinh";
        } else if (age <= 5) {
            trinhDo = "Mẫu giáo";
        } else if (age <= 10) {
            trinhDo = "Cấp 1";
        } else if (age <= 14) {
            trinhDo = "Cấp 2";
        } else if (age <= 17) {
            trinhDo = "Cấp 3";
        } else {
            trinhDo = "đã tốt nghiệp";
        }

        System.out.printf(
            "Xin chao %s, %d year old, %f kg, live in %s%n, and I'm %s",
            this.name,
            this.age,
            this.weight,
            this.address,
            trinhDo
        );
    }

    public static void main(String[] args) {
        Human22 john = new Human22(); // contractor - hàm tạo no args ( không tham số )
        john.name = "John Nguyen";
        john.age = 18;
        john.address = "Ha Noi";
        john.weight = 64;
        john.sayHi_2();

    }

}
