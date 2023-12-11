package utils.statement;

import annotations.data.Column;
import const_.StringSql;
import entity.ClassElement;

import java.util.List;

public class SqlBuilder {
    public static String insert(ClassElement element){
        return StringSql.INSERT_INTO.val +
                StringSql.SPACE.val + element.getTableName() +
                StringSql.SPACE.val + setColumnName(element.getIdColumn().columnName(), element.getColumnName()) +
                StringSql.SPACE.val + StringSql.VALUES.val +
                StringSql.SPACE.val + setValuesIndex(element.getColumnName().size()) +
                StringSql.SPACE.val + StringSql.ON_DUPLICATE_KEY_UPDATE.val +
                StringSql.SPACE.val + setDuplicateUpdate(element.getColumnName());
    }

    public static String getById(String tableName, String idColumnName){
        return StringSql.SELECT_CLAUSE.val +
                StringSql.SPACE.val + tableName +
                StringSql.SPACE.val + StringSql.WHERE.val +
                StringSql.SPACE.val + idColumnName +
                StringSql.SPACE.val + StringSql.EQUAL.val +
                StringSql.SPACE.val + StringSql.QUESTION_MARK.val;
    }

    public static String setColumnName(String idColumnName, List<Column> columnName){
        StringBuilder columnValue = new StringBuilder(StringSql.PARENTHESES.val);
        columnValue.append(idColumnName).append(StringSql.COMMA.val);
        for (int i = 0; i < columnName.size(); i++) {
            if (i != columnName.size() - 1){
                columnValue.append(columnName.get(i).columnName());
                columnValue.append(StringSql.COMMA.val);
                continue;
            }
            columnValue.append(columnName.get(i).columnName());
        }
        columnValue.append(StringSql.PARENTHESES_CLOSE.val);
        return columnValue.toString();
    }

    public static String setValuesIndex(int index){
        StringBuilder valueInsert = new StringBuilder(StringSql.PARENTHESES.val);
        for (int i = 0; i <= index; i++) {
            if (i != index){
                valueInsert.append(StringSql.QUESTION_MARK.val);
                valueInsert.append(StringSql.COMMA.val);
                continue;
            }
            valueInsert.append(StringSql.QUESTION_MARK.val);
        }
        valueInsert.append(StringSql.PARENTHESES_CLOSE.val);
        return valueInsert.toString();
    }

    public static String setDuplicateUpdate(List<Column> columnName){
        StringBuilder duplicate = new StringBuilder();
        for (int i = 0; i < columnName.size(); i++) {
            if (i != columnName.size() - 1){
                duplicate.append(columnName.get(i).columnName()).append(StringSql.EQUAL.val)
                        .append(StringSql.VALUES.val).append(StringSql.PARENTHESES.val)
                        .append(columnName.get(i).columnName()).append(StringSql.PARENTHESES_CLOSE.val)
                        .append(StringSql.COMMA.val);
                continue;
            }
            duplicate.append(columnName.get(i).columnName()).append(StringSql.EQUAL.val)
                    .append(StringSql.VALUES.val).append(StringSql.PARENTHESES.val)
                    .append(columnName.get(i).columnName()).append(StringSql.PARENTHESES_CLOSE.val);
        }
        return duplicate.toString();
    }

}
