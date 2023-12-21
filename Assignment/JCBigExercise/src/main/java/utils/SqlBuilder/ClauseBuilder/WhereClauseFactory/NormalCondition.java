package utils.SqlBuilder.ClauseBuilder.WhereClauseFactory;

import static const_.StringSql.*;

public class NormalCondition extends ConditionFactory {

    public NormalCondition(String column, Operator operator) {
        super(column, operator);
    }

    @Override
    public StringBuilder conditionBuilder() {
        return new StringBuilder(column)
                .append(operator.val)
                .append(QUESTION_MARK.val)
                .append(SPACE.val)
                ;
    }

    @Override
    public String toString() {
        return conditionBuilder().toString();
    }
}
