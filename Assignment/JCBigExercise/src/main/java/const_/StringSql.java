package const_;


public enum StringSql {
    SELECT_CLAUSE("SELECT * FROM "),
    INSERT_INTO("INSERT INTO "),
    DELETE_FROM("DELETE FROM "),
    UPDATE("UPDATE "),
    WHERE(" WHERE "),
    VALUES("VALUES"),
    SET("SET "),
    PERCENT("%"),
    ORDER_BY(" ORDER BY "),
    LIMIT(" LIMIT "),
    OFFSET(" OFFSET "),
    EQUAL(" = "),
    COMMA(", "),
    PARENTHESES("("),
    PARENTHESES_CLOSE(") "),
    SPACE(" "),
    QUESTION_MARK("?"),
    ON_DUPLICATE_KEY_UPDATE(" ON DUPLICATE KEY UPDATE ")
    ;
    public enum Operator {
        EQUAL(" = "),
        GREATER_THAN(" > "),
        LESS_THAN(" < "),
        GREATER_THAN_OR_EQUAL(" >= "),
        LESS_THAN_OR_EQUAL(" <= "),
        NOT_EQUAL(" <> "),
        BETWEEN(" BETWEEN "),
        LIKE(" LIKE "),
        IN(" IN ")
        ;
        public final String val;
        Operator(String val) {
            this.val = val;
        }

    }
    public enum ExtendCondition {
        AND(" AND "),
        OR(" OR ")
        ;
        public final String val;
        ExtendCondition(String val) {
            this.val = val;
        }

    }
    public final String val;
    StringSql(String val) {
        this.val = val;
    }
}
