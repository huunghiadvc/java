package utils.SqlBuilder.ClauseBuilder;

import annotations.data.Column;
import const_.StringSql;

import java.util.Arrays;
import java.util.List;

public class InsertClause {
    private final String tableName;
    private final List<Column> columnName;

    public InsertClause(String tableName, List<Column> columnName) {
        this.tableName = tableName;
        this.columnName = columnName;
    }
    public StringBuilder toSql(){
        StringBuilder result = new StringBuilder()
                .append(StringSql.INSERT_INTO.val)
                .append(tableName)
                .append(StringSql.PARENTHESES.val);
        for (Column col : columnName) {
            if (!col.equals(columnName.getLast())){
                result.append(col.columnName()).append(StringSql.COMMA.val);
                continue;
            }
            result.append(col.columnName());
        }
        result.append(StringSql.PARENTHESES_CLOSE.val);
        return result;
    }

    @Override
    public String toString() {
        return toSql().toString();
    }
}
