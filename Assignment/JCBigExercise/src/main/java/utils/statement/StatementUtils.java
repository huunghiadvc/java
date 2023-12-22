package utils.statement;

import annotations.data.Column;
import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

public class StatementUtils {
    public static void setValues(PreparedStatement preStmt, List<Column> columnName, Object obj) {
        String type;
        Field[] objField = obj.getClass().getDeclaredFields();
        try {
            String objColumn;
            int index = 1;
            Field f;
            for (Field field : objField) {
                try {
                    objColumn = field.getAnnotation(Column.class).columnName();
                } catch (NullPointerException exception) {
                    continue;
                }
                for (Column col : columnName) {
                    if (objColumn.equals(col.columnName())) {
                        f = obj.getClass().getDeclaredField(field.getName());
                        type = col.type().val;
                        setPreStmt(preStmt, f, obj, type, index);
                        index++;
                        break;
                    }
                }
            }
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    public static void setValues(PreparedStatement preStmt, List<String> values) {
        try {
            System.out.println(preStmt);
            System.out.println(values.size());
            for (int i = 0; i < values.size(); i++) {
                System.err.println(i);
                preStmt.setObject(i+1, values.get(i));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void setPreStmt(PreparedStatement preStmt, Field f, Object obj, String type, int i){
        f.setAccessible(true);
        Object value;
        try {
            value = f.get(obj);
            preStmt.setObject(i, value, checkType(type));
        } catch (SQLException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
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
