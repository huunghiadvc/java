package utils;

import java.io.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class FileUtils {
    public static final String header = "ID|CARDTYPE|NAME|CARDNO|IDCARD|MSISDN|ADDRESS|DATEOFBIRTH";
    public static final List<String> CARDTYPE = Arrays.asList("VISA" , "JCB" , "HYBRID");
    public static final String separator = "|";
    static String randomCardNo(){
        return String.valueOf(System.currentTimeMillis());
    }
    static String randomCardType(){
        return CARDTYPE.get(NumberUtils.randomNumber(0, 2));
    }
    static String randomCardID(){
        return String.valueOf(System.currentTimeMillis());
    }


    public static void main(String[] args) {
        createBankAccount("./src/etc/demo/customer.txt", 5000000);
    }

    public static void createBankAccount(String filename, int num){
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(
                    new FileWriter(filename, true)
            ));
            out.println(header);
            for (int i = 0; i < num; i++) {
                StringBuilder builder = new StringBuilder();
                builder.append(i + 1)
                        .append(separator)
                        .append(randomCardType())
                        .append(separator)
                        .append(StringUtils.randomAlphaNumeric(20))
                        .append(separator)
                        .append(randomCardNo())
                        .append(separator)
                        .append(randomCardID())
                        .append(separator)
                        .append(StringUtils.randomMSISDN())
                        .append(separator)
                        .append(StringUtils.randomAlphaNumeric(50))
                        .append(separator)
                        .append(DateTimeUtils.randomDateOfBirth());
                out.println(builder);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (out != null){
                out.close();
            }
        }
    }
}
