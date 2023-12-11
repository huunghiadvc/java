package const_;


public enum StringSql {
    SELECT_CLAUSE("SELECT * FROM"),
    INSERT_INTO("INSERT INTO"),
    WHERE("WHERE"),
    VALUES("VALUES"),
    ORDER_BY("ORDER BY"),
    LIMIT("LIMIT"),
    OFFSET("OFFSET"),
    EQUAL("="),
    COMMA(","),
    PARENTHESES("("),
    PARENTHESES_CLOSE(")"),
    SPACE(" "),
    QUESTION_MARK("?"),
    ON_DUPLICATE_KEY_UPDATE("ON DUPLICATE KEY UPDATE")
    ;
    public final String val;
    StringSql(String val) {
        this.val = val;
    }
}
