package utils.SqlBuilder.ClauseBuilder.WhereClauseFactory;

import static const_.StringSql.*;

public class InBetweenCondition extends ConditionFactory {
    public InBetweenCondition(String column, Operator operator) {
        super(column, operator);
    }

    @Override
    public StringBuilder conditionBuilder() {
        return new StringBuilder(column).append(operator)
                .append(PARENTHESES.val)
                .append(QUESTION_MARK.val)
                .append(COMMA.val)
                .append(QUESTION_MARK.val)
                .append(PARENTHESES_CLOSE.val)
                .append(SPACE.val);
    }

    @Override
    public String toString() {
        return conditionBuilder().toString();
    }
}
