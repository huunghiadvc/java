package interface_abstract.abstracts;

import lombok.Data;

@Data
public abstract class Parent_Abstracts {
    public String color;
    public abstract void draw();

    public Parent_Abstracts(String color) {
        this.color = color;
    }
}
