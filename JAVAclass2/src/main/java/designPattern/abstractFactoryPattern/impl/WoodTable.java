package designPattern.abstractFactoryPattern.impl;

import designPattern.abstractFactoryPattern.Table;

public class WoodTable implements Table {

    @Override
    public void create() {
        System.out.println("Create wood table");
    }
}
