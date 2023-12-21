package utils;

public class MenuUtils {
    public static void show(){
        System.out.println("SELECT OPTION BELOW:");
        System.out.println("    1. Show products.");
        System.out.println("    2. Search.");
        System.out.println("    3. Add new product.");
        System.out.println("    4. Update product by id.");
        System.out.println("    5. Delete product by id.");
        System.out.println("    6. Exit.");
        System.out.println("Please input option: ");
    }
    public static class SubMenu {
        public static void conditionType(){
            System.out.println("    1. Equal");
            System.out.println("    2. Not equal");
            System.out.println("    3. Greater than");
            System.out.println("    4. Less than");
            System.out.println("    5. Greater than or equal");
            System.out.println("    6. Less than or equal");
            System.out.println("    7. BETWEEN : Between a certain range");
            System.out.println("    8. LIKE : Search for a pattern");
            System.out.println("    9. IN : multiple possible values for a column");
        }
        public static void columnList(){
            System.out.println("    1. Id");
            System.out.println("    2. Name");
            System.out.println("    3. Producer");
            System.out.println("    4. Line");
            System.out.println("    5. Price");
        }
        public static void moreCondition(){
            System.out.println("Do you want to extend the conditional sentence?");
            System.out.println("    1. AND : extend condition with AND");
            System.out.println("    2. OR : extend condition with OR");
            System.out.println("    3. LIMIT & OFFSET : set limit and offset");
            System.out.println("    4. Execute : Don't extend condition and execute the query!");
        }
    }
}
