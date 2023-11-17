package designPattern.abstractFactoryPattern;

import designPattern.abstractFactoryPattern.factory.FunitureFactory;
import designPattern.abstractFactoryPattern.impl.WoodTable;
import designPattern.abstractFactoryPattern.material.MaterialType;

public class Client {
    public static void main(String[] args) {
        FunitureAbsTractFactory woodFactory = FunitureFactory.getFactory(MaterialType.WOOD);
        FunitureAbsTractFactory plasticFactory = FunitureFactory.getFactory(MaterialType.PLASTIC);

        Chair chair1 = woodFactory.createChair();
        chair1.create();

        Table table1 = woodFactory.createTable();
        table1.create();

        Chair chair2 = plasticFactory.createChair();
        chair2.create();

        Table table2 = plasticFactory.createTable();
        table2.create();
    }
}
