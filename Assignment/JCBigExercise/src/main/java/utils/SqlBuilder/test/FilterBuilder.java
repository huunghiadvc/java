package utils.SqlBuilder.test;

import java.util.ArrayList;
import java.util.List;

public class FilterBuilder extends WhereCriteriaBuilder {
    public FilterBuilder(List<String> columnName, Integer limit, Integer offset) {
        super(columnName, limit, offset);
    }

    @Override
    protected void conditionsBuild() {
        List<String> duplicateList = new ArrayList<>();

        for (int i = 0; i < columnName.size(); i++) {

            if (i == 0){
                lessThanOrEqual(columnName.get(i));
                duplicateList.add(columnName.getFirst());
                continue;
            }

            if (checkDuplicate(duplicateList, columnName.get(i))){
                duplicateList.add(columnName.get(i));
                and();
            } else {
                or();
            }

            lessThanOrEqual(columnName.get(i));
        }
    }

    private boolean checkDuplicate(List<String> cols, String col){
        System.out.println(cols);
        for (String c : cols) {
            if (col.equals(c)){
                return false;
            }
        }
        return true;
    }

}
