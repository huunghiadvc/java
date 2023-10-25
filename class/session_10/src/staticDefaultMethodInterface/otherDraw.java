package staticDefaultMethodInterface;

public interface otherDraw {
    void draw();
    default void setColor(String color){
        System.err.println(color);
    };
}
