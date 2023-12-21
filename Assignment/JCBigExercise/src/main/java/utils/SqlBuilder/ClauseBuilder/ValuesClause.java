package utils.SqlBuilder.ClauseBuilder;

import const_.StringSql;
import java.util.ArrayList;
import java.util.List;

public class ValuesClause {
    private final String valueClause;
    private final int index;

    public ValuesClause(int index) {
        valueClause = StringSql.VALUES.val;
        this.index = index;
    }

    public StringBuilder toSql(){
        List<String> value = new ArrayList<>(index);
        for (int i = 0; i < index; i++) {
            value.add(StringSql.QUESTION_MARK.val);
        }
        return new StringBuilder(valueClause).append(StringSql.PARENTHESES.val)
                .append(String.join(StringSql.COMMA.val, value))
                .append(StringSql.PARENTHESES_CLOSE.val)
                ;
    }

    @Override
    public String toString() {
        return toSql().toString();
    }

}
