package utils.validate;

public class ValidateUtils {
    public static boolean stringValid(String str){
        return str.matches(".*[a-zA-Z].*");
    }
    public static boolean productLineValid(String productLine){
        return productLine.matches(".*[a-z0-9A-Z].*");
    }
    public static boolean priceValid(String price){
        return price.matches(".*[0-9].*");
    }
}
