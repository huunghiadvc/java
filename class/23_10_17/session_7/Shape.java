package session_7;

public abstract class Shape {
    private String color = "red";

    public Shape() {
    }

    public abstract void draw();

    public String getColor() {
        return color;
    }
}
