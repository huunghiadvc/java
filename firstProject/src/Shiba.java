public class Shiba extends Cho { //extends form class chỉ kết thừa được 1.
    private String color;
    private String description;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Shiba(String name, double height, double weight) {
        super(name, height, weight);
        this.color = "white";
        this.description = "Rat thong minh va trung thanh!!!";
    }
}
