package designPattern.abstractFactoryPattern.impl;

import designPattern.abstractFactoryPattern.Chair;

public class PlasticChair implements Chair {
    @Override
    public void create() {
        System.out.println("Create plastic chair!");
    }
}
