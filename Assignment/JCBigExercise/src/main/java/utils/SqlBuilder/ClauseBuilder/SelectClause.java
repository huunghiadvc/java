package utils.SqlBuilder.ClauseBuilder;

import const_.StringSql;

public class SelectClause {
    private final String selectClause;
    private final String tableName;

    public SelectClause(String tableName) {
        this.selectClause = StringSql.SELECT_CLAUSE.val;
        this.tableName = tableName;
    }

    public String toSql(){
        return selectClause + tableName;
    }

    @Override
    public String toString() {
        return toSql();
    }
}
