package designPattern.abstractFactoryPattern.factory;

import designPattern.abstractFactoryPattern.Chair;
import designPattern.abstractFactoryPattern.FunitureAbsTractFactory;
import designPattern.abstractFactoryPattern.Table;
import designPattern.abstractFactoryPattern.impl.WoodChair;
import designPattern.abstractFactoryPattern.impl.WoodTable;

public class WoodFactory extends FunitureAbsTractFactory {

    @Override
    public Chair createChair() {
        return new WoodChair();
    }

    @Override
    public Table createTable() {
        return new WoodTable();
    }
}
