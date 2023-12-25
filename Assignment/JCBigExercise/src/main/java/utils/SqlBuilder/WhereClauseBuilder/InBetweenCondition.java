package utils.SqlBuilder.WhereClauseBuilder;

import lombok.AllArgsConstructor;

import static const_.StringSql.*;

@AllArgsConstructor
public class InBetweenCondition {
    private final String column;
    private final String operator;
    public StringBuilder conditionBuilder() {
        return new StringBuilder(column)
                .append(operator)
                .append(PARENTHESES.val)
                .append(QUESTION_MARK.val)
                .append(COMMA.val)
                .append(QUESTION_MARK.val)
                .append(PARENTHESES_CLOSE.val)
                .append(SPACE.val);
    }

    public String toString() {
        return conditionBuilder().toString();
    }
}
