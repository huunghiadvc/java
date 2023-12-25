package utils.SqlBuilder.WhereClauseBuilder;

import lombok.AllArgsConstructor;

import static const_.StringSql.*;

@AllArgsConstructor
public class NormalCondition {
    private final String column;
    private final String operator;

    public StringBuilder conditionBuilder() {
        return new StringBuilder(column)
                .append(operator)
                .append(QUESTION_MARK.val)
                .append(SPACE.val)
                ;
    }

    public String toString() {
        return conditionBuilder().toString();
    }
}
