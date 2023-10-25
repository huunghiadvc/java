package staticDefaultMethodInterface;

public class Rectangular extends ShapeAbstract implements Shape, otherDraw{
    @Override
    public void draw() {
        System.err.println("Drawing...");
    }

    @Override
    public void setColor(String color) {
        System.err.println("Coloring...");
        Shape.super.setColor(color);
    }



}
