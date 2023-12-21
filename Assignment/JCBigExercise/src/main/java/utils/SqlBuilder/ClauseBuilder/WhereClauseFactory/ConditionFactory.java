package utils.SqlBuilder.ClauseBuilder.WhereClauseFactory;

import static const_.StringSql.Operator;

public abstract class ConditionFactory {
    public final String column;
    public final Operator operator;

    public ConditionFactory(String column, Operator operator) {
        this.column = column;
        this.operator = operator;
    }
    public abstract StringBuilder conditionBuilder();

}
