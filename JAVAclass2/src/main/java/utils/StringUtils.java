package utils;

public class StringUtils {
    public static final String alpha = "abcdefghijklmnopqrstuvwxyz";
    public static final String alphaUpperCase = alpha.toUpperCase();
    public static final String digits = "0123456789";
    public static String randomAlphaNumeric(int numberCharacter){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberCharacter; i++) {
            int num = NumberUtils.randomNumber(0, alpha.length() - 1);
            char ch = alpha.charAt(num);
            sb.append(ch);
        }
        return sb.toString();
    }

    public static String randomMSISDN(){
        String prefix = "84";
        StringBuilder builder = new StringBuilder();
        builder.append(prefix);
        int max = NumberUtils.randomNumber(9,10);
        for (int i = 0; i < max; i++){
            int num = NumberUtils.randomNumber(0,9);
            char ch = digits.charAt(num);
            builder.append(ch);
        }
        return builder.toString();
    }

}

