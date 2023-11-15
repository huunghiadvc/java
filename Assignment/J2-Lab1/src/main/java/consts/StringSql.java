package consts;


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
    QUESTION_MARK("?")
    ;
    public final String val;
    StringSql(String val) {
        this.val = val;
    }
}
