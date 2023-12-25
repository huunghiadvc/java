package utils.SqlBuilder.test;

import java.util.Arrays;
import java.util.List;
import static const_.StringSql.*;

public abstract class WhereCriteriaBuilder {
    List<String> columnName;
    StringBuilder sql;
    Integer limit;
    Integer offset;

    protected abstract void conditionsBuild();

    public String toSql() {
        conditionsBuild();
        if (sql.toString().equals(WHERE.val)){
            return "";
        }
        return sql.toString();
    }

    public static void main(String[] args) {
        FilterBuilder s = new FilterBuilder(Arrays.asList("name", "name", "id", "name"), null, null);
        System.out.println(s.toSql());
    }

    public WhereCriteriaBuilder(List<String> columnName, Integer limit, Integer offset) {
        sql = new StringBuilder(WHERE.val);
        this.columnName = columnName;
        if (limit != null){
            this.limit = limit;
        }
        if (offset != null){
            this.offset = offset;
        }
    }

    protected void equal(String column) {
        sql.append(column).append(EQUAL.val).append(QUESTION_MARK.val);
    }

    protected void and() {
        sql.append(" AND ");
    }

    protected void or() {
        sql.append(" OR ");
    }

    protected void greaterThan(String column) {
        sql.append(column).append(" > ").append(QUESTION_MARK.val);
    }

    protected void greaterThanOrEqual(String column) {
        sql.append(column).append(" >= ").append(QUESTION_MARK.val);
    }

    protected void lessThan(String column) {
        sql.append(column).append(" < ").append(QUESTION_MARK.val);
    }

    protected void lessThanOrEqual(String column) {
        sql.append(column).append(" <= ").append(QUESTION_MARK.val);
    }

    protected void in(String column) {
        sql.append(column).append(" IN ")
                .append(PARENTHESES.val).append(QUESTION_MARK.val)
                .append(COMMA.val).append(QUESTION_MARK.val)
                .append(PARENTHESES_CLOSE.val);
    }

    protected void between(String column) {
        sql.append(column).append(" BETWEEN ")
                .append(PARENTHESES.val).append(QUESTION_MARK.val)
                .append(COMMA.val).append(QUESTION_MARK.val)
                .append(PARENTHESES_CLOSE.val);
    }

    @Override
    public String toString() {
        return toSql();
    }
}
