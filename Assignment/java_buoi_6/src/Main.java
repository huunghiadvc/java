import KeThua.ExcelUtils;

public class Main {
    public static void main(String[] args) {
        System.err.println(StaticLab.num);
        ExcelUtils excelUtil = new ExcelUtils() {
            @Override
            String getLine(){
                return ("new line in run time!");
            }
        };
    }
}
