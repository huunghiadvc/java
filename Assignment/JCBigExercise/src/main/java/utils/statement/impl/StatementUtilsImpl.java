package utils.statement.impl;

import annotations.data.Column;
import entity.ClassElement;
import entity.Product;
import utils.statement.StatementUtils;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

public class StatementUtilsImpl implements StatementUtils<Product> {
    @Override
    public PreparedStatement setValues(PreparedStatement preStmt, ClassElement classElement, Product obj) {
        int i = 2;
        try {
            preStmt.setObject(1, obj.getId(), checkType(classElement.getIdColumn().type().val));
            for (Column element : classElement.getColumnName()) {
                if (element.columnName().equalsIgnoreCase("price")){
                    preStmt.setObject(
                            i, Double.parseDouble(checkField(element.columnName(), obj)), checkType(element.type().val)
                    );
                    continue;
                }
                preStmt.setObject(i, checkField(element.columnName(), obj), checkType(element.type().val));
                i++;
            }
            return preStmt;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static String checkField(String field, Product product) {
        return switch (field) {
            case "name" -> product.getName();
            case "producer" -> product.getProducer();
            case "line" -> product.getLine();
            case "price" -> String.valueOf(product.getPrice());
            default -> null;
        };
    }
    public static int checkType(String type) {
        return switch (type) {
            case "varchar" -> Types.VARCHAR;
            case "double" -> Types.DOUBLE;
            case "bigint" -> Types.BIGINT;
            default -> 0;
        };
    }
}
