package utils.SqlBuilder;

import annotations.data.Column;
import entity.SearchEngine;
import utils.SqlBuilder.WhereClauseBuilder.InBetweenCondition;
import utils.SqlBuilder.WhereClauseBuilder.NormalCondition;
import utils.SqlBuilder.test.SearchBuilder;

import java.util.ArrayList;
import java.util.List;
import static const_.StringSql.*;

public class SqlClauseBuilder {
    public static String insertBuilder(String tableName, List<Column> columnName){
        StringBuilder result = new StringBuilder()
                .append(INSERT_INTO.val)
                .append(tableName)
                .append(PARENTHESES.val);
        for (Column col : columnName) {
            if (!col.equals(columnName.getLast())){
                result.append(col.columnName()).append(COMMA.val);
                continue;
            }
            result.append(col.columnName());
        }
        result.append(PARENTHESES_CLOSE.val);
        return result.toString();
    }

    public static String selectBuilder(String tableName){
        return SELECT_CLAUSE.val + tableName;
    }

    public static String updateBuilder(String tableName, List<String> columnList){
        StringBuilder updateClause = new StringBuilder(UPDATE.val);
        updateClause.append(tableName).append(SPACE.val).append(SET.val);
        for (int i = 0; i < columnList.size(); i++) {
            updateClause.append(columnList.get(i))
                    .append(EQUAL.val)
                    .append(QUESTION_MARK.val);
            if (i < columnList.size() - 1){
                updateClause.append(COMMA.val);
            }
        }
        return updateClause.toString();
    }

    public static String deleteBuilder(String tableName){
        return DELETE_FROM.val + tableName;
    }

    public static String valuesBuilder(int index){
        List<String> value = new ArrayList<>(index);
        for (int i = 0; i < index; i++) {
            value.add(QUESTION_MARK.val);
        }
        return VALUES.val + PARENTHESES.val +
                String.join(COMMA.val, value) +
                PARENTHESES_CLOSE.val
                ;
    }

    public static String whereBuilder(SearchEngine searchEngine){
        StringBuilder whereClause = new StringBuilder(WHERE.val);

        if (searchEngine.getOperatorList().size() == 1){
            Operator operator = searchEngine.getOperatorList().getFirst();
            String columnName = searchEngine.getColumnList().getFirst();
            switch (operator){

                case IN, BETWEEN -> whereClause.append(new InBetweenCondition(columnName, operator.val));

                default -> whereClause.append(new NormalCondition(columnName, operator.val));
            }
        } else {
            for (int i = 0; i < searchEngine.getColumnList().size(); i++) {
                Operator operator = searchEngine.getOperatorList().get(i);
                String col = searchEngine.getColumnList().get(i);
                switch (operator){

                    case IN, BETWEEN -> whereClause.append(new InBetweenCondition(col, operator.val));

                    default -> whereClause.append(new NormalCondition(col, operator.val));
                }
                if (i < searchEngine.getColumnList().size() - 1){
                    whereClause.append(searchEngine.getExtendList().get(i).val);
                }
            }
        }

        if (searchEngine.getLimit() != null){
            whereClause.append(limitOffsetClause(searchEngine.getLimit(), searchEngine.getOffset()));
        }

        return whereClause.toString();
    }

    public static String whereBuilder(String column){
        return WHERE.val + column + EQUAL.val + QUESTION_MARK.val;
    }
    public static String limitOffsetClause(Integer limit, Integer offset){
        if (offset == null){
            return LIMIT.val + limit;
        }
        return LIMIT.val + limit + OFFSET.val + offset;
    }

}
