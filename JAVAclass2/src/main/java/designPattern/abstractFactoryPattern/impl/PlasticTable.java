package designPattern.abstractFactoryPattern.impl;

import designPattern.abstractFactoryPattern.Table;

public class PlasticTable implements Table {
    @Override
    public void create() {
        System.out.println("Create plastic table");
    }
}
