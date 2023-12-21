package utils.SqlBuilder.ClauseBuilder;

import utils.SqlBuilder.ClauseBuilder.WhereClauseFactory.InBetweenCondition;
import utils.SqlBuilder.ClauseBuilder.WhereClauseFactory.NormalCondition;

import java.util.ArrayList;
import java.util.List;
import static const_.StringSql.*;

public class WhereClause {
    private final List<String> columnName;
    private final List<Operator> operatorList;
    private final List<ExtendCondition> extendCondition;

    public WhereClause(List<String> col, List<Operator> operator, List<ExtendCondition> extendCondition) {
        this.columnName = col;
        this.extendCondition = extendCondition;
        this.operatorList = operator;
    }

    public WhereClause(List<String> col, List<Operator> operator, ExtendCondition extendCondition) {
        this.columnName = col;
        this.operatorList = operator;
        this.extendCondition = new ArrayList<>();
        this.extendCondition.add(extendCondition);
    }

    public WhereClause(String col, Operator operator) {
        this.columnName = new ArrayList<>();
        this.columnName.add(col);
        this.operatorList = new ArrayList<>();
        this.operatorList.add(operator);
        extendCondition = null;
    }

    public StringBuilder toSql(){
        StringBuilder sql = new StringBuilder(WHERE.val);
        String col;
        Operator operator;

        for (int i = 0; i < columnName.size(); i++) {
            col = columnName.get(i);
            operator = operatorList.get(i);

            switch (operator){

                case IN, BETWEEN -> sql.append(new InBetweenCondition(col, operator));

                default -> sql.append(new NormalCondition(col, operator));
            }

            if (i < columnName.size() - 1){
                sql.append(extendCondition.get(i).val);
            }
        }

        return sql;
    }

    @Override
    public String toString() {
        return toSql().toString();
    }
}
