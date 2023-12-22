package utils.SqlBuilder.WhereClauseBuilder;

import annotations.data.Column;
import const_.StringSql;

import java.util.List;

public class DuplicateKeyClause {
    private final List<Column> columnName;

    public DuplicateKeyClause(List<Column> columnName) {
        this.columnName = columnName;
    }

    public StringBuilder toSql(){
        StringBuilder duplicate = new StringBuilder(StringSql.ON_DUPLICATE_KEY_UPDATE.val);
        for (Column col : columnName) {
            duplicate.append(col.columnName())
                    .append(StringSql.EQUAL.val)
                    .append(StringSql.VALUES.val)
                    .append(StringSql.PARENTHESES.val)
                    .append(col.columnName())
                    .append(StringSql.PARENTHESES_CLOSE.val);
            if (!col.equals(columnName.getLast())){
                duplicate.append(StringSql.COMMA.val);
            }
        }
        return duplicate;
    }

    @Override
    public String toString() {
        return toSql().toString();
    }
}
