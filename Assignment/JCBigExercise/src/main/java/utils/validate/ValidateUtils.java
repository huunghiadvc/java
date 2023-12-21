package utils.validate;

import const_.StringSql;
import static const_.StringSql.Operator.*;

public class ValidateUtils {
    public static boolean stringValid(String str){
        return str.matches(".*[a-zA-Z].*");
    }
    public static boolean productLineValid(String productLine){
        return productLine.matches(".*[a-zA-Z0-9]+.*");
    }
    public static boolean numberValid(String num){
        return num.matches(".*[0-9].*");
    }
    public static class controllerValid {
        public static StringSql.Operator conditionType(int index){
            return switch (index) {
                case 1 -> EQUAL;
                case 2 -> NOT_EQUAL;
                case 3 -> GREATER_THAN;
                case 4 -> LESS_THAN;
                case 5 -> GREATER_THAN_OR_EQUAL;
                case 6 -> LESS_THAN_OR_EQUAL;
                case 7 -> BETWEEN;
                case 8 -> LIKE;
                case 9 -> IN;
                default -> {
                    System.out.println("Please input Integer 1-9!");
                    yield null;
                }
            };
        }
    }
}
