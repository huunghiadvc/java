package utils.SqlBuilder.ClauseBuilder;

import const_.StringSql;

public class DeletedClause {
    private final String deletedClause;
    private final String tableName;

    public DeletedClause(String tableName) {
        deletedClause = StringSql.DELETE_FROM.val;
        this.tableName = tableName;
    }

    public String toSql(){
        return deletedClause + tableName;
    }

    @Override
    public String toString() {
        return toSql();
    }
}
