package interface_abstract.abstracts;

import lombok.NoArgsConstructor;

public class Child extends Parent_Abstracts {
    public Child(String color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.println(color);
    }
}
