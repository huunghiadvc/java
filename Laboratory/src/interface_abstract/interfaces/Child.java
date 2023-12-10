package interface_abstract.interfaces;

public class Child implements Parent_interfaces {
    public String color;

    public Child(String color) {
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.println("draw " + color + " " + colorParent);
    }
}
