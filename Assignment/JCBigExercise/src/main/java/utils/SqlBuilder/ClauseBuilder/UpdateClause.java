package utils.SqlBuilder.ClauseBuilder;


import annotations.data.Column;

import java.util.List;

import static const_.StringSql.*;
public class UpdateClause {
    private final String tableName;
    private final List<String> columnName;

    public UpdateClause(String tableName, List<String> columnName) {
        this.columnName = columnName;
        this.tableName = tableName;
    }

    public StringBuilder toSql(){
        StringBuilder sql = new StringBuilder();
        sql.append(UPDATE.val).append(tableName).append(SPACE.val).append(SET.val);

        if (columnName.size() == 1){
            sql.append(columnName.getFirst()).append(EQUAL.val).append(QUESTION_MARK.val);
        } else {
            for (String col : columnName) {
                if (col.equals(columnName.getLast())){
                    sql.append(col).append(EQUAL.val).append(QUESTION_MARK.val);
                    break;
                }
                sql.append(col).append(EQUAL.val).append(QUESTION_MARK.val).append(COMMA.val);
            }
        }

        return sql;
    }

    @Override
    public String toString() {
        return toSql().toString();
    }
}
