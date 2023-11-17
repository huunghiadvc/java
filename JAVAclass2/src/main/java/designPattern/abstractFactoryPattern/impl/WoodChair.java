package designPattern.abstractFactoryPattern.impl;

import designPattern.abstractFactoryPattern.Chair;

public class WoodChair implements Chair {

    @Override
    public void create() {
        System.out.println("Create wood chair");
    }
}
