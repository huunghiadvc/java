package designPattern.abstractFactoryPattern.factory;

import designPattern.abstractFactoryPattern.FunitureAbsTractFactory;
import designPattern.abstractFactoryPattern.material.MaterialType;

public class FunitureFactory {
    public static FunitureAbsTractFactory getFactory(MaterialType materialType){
        return switch (materialType){
            case WOOD -> new WoodFactory();
            case PLASTIC -> new PlasticFactory();
            default -> {
                try {
                    throw new IllegalAccessException();
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }
}
