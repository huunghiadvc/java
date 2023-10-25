package staticDefaultMethodInterface;

public interface Shape {
    void draw();
    default void setColor(String color){
        System.err.println(color);
    };

}
