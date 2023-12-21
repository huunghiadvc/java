package utils.SqlBuilder.ClauseBuilder;

import const_.StringSql;

public class LimitOffsetClause {
    private final String limit;
    private final String offset;
    private final Integer limitVal;
    private final Integer offsetVal;

    public LimitOffsetClause(Integer[] limit_offset) {
        limit = StringSql.LIMIT.val;
        offset = StringSql.OFFSET.val;
        this.limitVal = limit_offset[0];
        this.offsetVal = limit_offset[1];
    }

    public StringBuilder toSql(){
        if (offsetVal == null){
            return new StringBuilder(limit).append(limitVal);
        }
        return new StringBuilder(limit).append(limitVal).append(offset).append(offsetVal);
    }

    @Override
    public String toString() {
        return toSql().toString();
    }
}
