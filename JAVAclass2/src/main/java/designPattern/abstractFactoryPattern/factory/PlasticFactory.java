package designPattern.abstractFactoryPattern.factory;

import designPattern.abstractFactoryPattern.Chair;
import designPattern.abstractFactoryPattern.FunitureAbsTractFactory;
import designPattern.abstractFactoryPattern.Table;
import designPattern.abstractFactoryPattern.impl.PlasticChair;
import designPattern.abstractFactoryPattern.impl.PlasticTable;

public class PlasticFactory extends FunitureAbsTractFactory {
    @Override
    public Chair createChair() {
        return new PlasticChair();
    }

    @Override
    public Table createTable() {
        return new PlasticTable();
    }
}
