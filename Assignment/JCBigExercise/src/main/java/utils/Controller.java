package utils;

import const_.StringSql;
import entity.Product;
import entity.SearchEngine;
import entity.repo.ProductRepo;
import service.ProductService;
import service.repo.ProductRepoService;
import utils.validate.ValidateUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static utils.MenuUtils.SubMenu.moreCondition;
import static utils.validate.ValidateUtils.*;
import static const_.StringSql.Operator;

public class Controller {
    public static void appControl(){
        String userInput;
        Product product;
        ProductService service = new ProductService();
        ProductRepoService repoService = new ProductRepoService();

        while (true){
            userInput = InputUtils.getString();
            if (!numberValid(userInput)){
                System.err.println("Please input integer");
                continue;
            }
            break;
        }

        switch (Integer.parseInt(userInput)){
            case 1:
                List<Product> productList = ProductRepo.getProductList();
                System.out.println(productList);
                break;

            case 2:
                SearchEngine searchEngine = Controller.searchFeatureControl.inputSearchCondition();
                List<Product> products = service.search(searchEngine);
                if (products != null){
                    products.forEach(System.out::println);
                }
                break;

            case 3:
                product = service.inputProduct();
                ProductRepo.getProductList().add(product);
                service.insert(product);
                break;

            case 4:
                Map<String, String> updates;
                while (true){
                    System.out.println("Input product id to update :");
                    userInput = InputUtils.getString();
                    if (!ValidateUtils.numberValid(userInput)){
                        System.err.println("Please input integer!");
                        continue;
                    }
                    product = repoService.findById(Long.parseLong(userInput));
                    if (product == null){
                        continue;
                    }
                    System.out.println("PLEASE INPUT NEW INFORMATION FOR PRODUCT ID : " + product.getId());
                    updates = service.inputUpdate(service.getColumnName());
                    break;
                }
                service.updateById(product.getId(), updates);
                break;

            case 5:
                while (true){
                    System.out.println("Input product id to delete :");
                    userInput = InputUtils.getString();
                    if (!ValidateUtils.numberValid(userInput)){
                        System.err.println("Please input integer!");
                        continue;
                    }
                    product = repoService.findById(Long.parseLong(userInput));
                    if (product == null){
                        System.err.println("PRODUCT WITH ID : " + userInput + " IS NOT EXIST!");
                        continue;
                    }
                    break;
                }
                service.deleteById(product.getId());
                break;

            case 6:
                do {
                    System.out.println("Input Y to confirm exist or N to cancel!");
                    userInput = InputUtils.getString();
                    if (userInput.equalsIgnoreCase("Y")) {
                        System.exit(0);
                    }
                } while (!userInput.equalsIgnoreCase("N"));
                break;

            default:
                System.err.println("Please select option 1-4!");
        }
    }
    public static class searchFeatureControl{
        public static SearchEngine inputSearchCondition(){
            String input;
            List<Operator> operatorList = new ArrayList<>();
            List<String> columnNameList = new ArrayList<>();
            List<String> valueList = new ArrayList<>();
            List<StringSql.ExtendCondition> extendConditionList = new ArrayList<>();
            Integer[] limit_offset = new Integer[2];
            while (true){
                int valueIndex = 1;
                Operator operator;
                while (true){
                    System.out.println("Input field for search :");
                    MenuUtils.SubMenu.columnList();
                    input = InputUtils.getString();
                    if (!numberValid(input)){
                        System.out.println("Please input integer 1-5!");
                        continue;
                    }
                    int index = Integer.parseInt(input);
                    if (index < 1 || index > 5){
                        System.out.println("Please input integer 1-5!");
                        continue;
                    }
                    String colName = searchFeatureControl.getColumnName(index);
                    if (colName == null){
                        System.err.println("Error to get column");
                        continue;
                    }
                    columnNameList.add(colName);
                    break;
                }
                while (true){
                    MenuUtils.SubMenu.conditionType();
                    input = InputUtils.getString();
                    operator = searchFeatureControl.getOperator(input);
                    if (operator == null){
                        continue;
                    }
                    operatorList.add(operator);
                    if (operator.equals(Operator.BETWEEN) || operator.equals(Operator.IN)){
                        valueIndex = 2;
                    }
                    break;
                }
                for (int i = 0; i < valueIndex; i++) {
                    System.out.println("Input value to compare :");
                    input = InputUtils.getString();
                    if (input == null){
                        System.err.println("Value cannot empty!");
                        i--;
                        continue;
                    }
                    if (operator.equals(Operator.LIKE)){
                        input = "%"+input+"%";
                    }
                    valueList.add(input);
                }
                int check;
                while (true){
                    moreCondition();
                    input = InputUtils.getString();
                    if(!numberValid(input)){
                        System.err.println("Please input integer!");
                    }
                    int i = Integer.parseInt(input);
                    if (i > 4 || i < 1){
                        System.err.println("Please input 1-4!");
                        continue;
                    }
                    switch (i){
                        case 1:
                            check = 1;
                            extendConditionList.add(StringSql.ExtendCondition.AND);
                            break;
                        case 2:
                            check = 1;
                            extendConditionList.add(StringSql.ExtendCondition.OR);
                            break;
                        case 3:
                            check = 2;
                            limit_offset = searchFeatureControl.getLimitOffset();
                            break;
                        default:
                            check = 0;
                            System.out.println("Executing...");
                            break;
                    }
                    if (check == 2){
                        continue;
                    }
                    break;
                }
                if (check == 0){
                    break;
                }
            }
            SearchEngine searchEngine;
            if (limit_offset[0] != null){
                searchEngine =
                        new SearchEngine(columnNameList, valueList, operatorList, extendConditionList, limit_offset);
            } else {
                searchEngine =
                        new SearchEngine(columnNameList, valueList, operatorList, extendConditionList, null);
            }
            return searchEngine;
        }
        public static Operator getOperator(String index){
            Operator operator = null;
            if (!ValidateUtils.numberValid(index)){
                System.err.println("Please input Integer between 1-9!");
            } else {
                operator = controllerValid.conditionType(Integer.parseInt(index));
            }
            return operator;
        }
        public static String getColumnName(int index){
            return switch (index) {
                case 1 -> "id";
                case 2 -> "name";
                case 3 -> "producer";
                case 4 -> "line";
                case 5 -> "price";
                default -> null;
            };
        }
        public static Integer[] getLimitOffset(){
            Integer[] integers = new Integer[2];
            String input;
            while (true){
                System.out.println("Input limit :");
                input = InputUtils.getString();
                if (!numberValid(input)){
                    System.out.println("Please input integer!");
                    continue;
                }
                integers[0] = Integer.parseInt(input);
                break;
            }
            while (true){
                System.out.println("Input offset ( this can be null ) :");
                input = InputUtils.getString();
                if (input == null){
                    break;
                }
                if (!numberValid(input)){
                    continue;
                }
                integers[1] = Integer.parseInt(input);
                break;
            }
            return integers;
        }
    }

}
