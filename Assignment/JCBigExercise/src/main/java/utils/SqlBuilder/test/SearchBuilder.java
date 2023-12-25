package utils.SqlBuilder.test;

import java.util.List;

public class SearchBuilder extends WhereCriteriaBuilder {
    public SearchBuilder(List<String> columnName, Integer limit, Integer offset) {
        super(columnName, limit, offset);
    }

    @Override
    protected void conditionsBuild() {
        for (int i = 0; i < columnName.size(); i++) {
            if (i != columnName.size() - 1){
                lessThanOrEqual(columnName.get(i));
                or();
                continue;
            }
            lessThanOrEqual(columnName.get(i));
        }
    }

}
