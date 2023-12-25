package entity;

import const_.StringSql.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchEngine {
    private List<String> columnList;
    private List<String> valueList;
    private List<Operator> operatorList;
    private List<ExtendCondition> extendList;
    private Integer limit;
    private Integer offset;

    public SearchEngine(String column, Operator operator, String value){
        assignValue(column, operator, value, null);
    }

    public SearchEngine(List<String> column, List<Operator> operator, List<String> value,
                        ExtendCondition condition){
        assignValue(column, operator, value, condition);
    }

    public void assignValue(String column, Operator operator, String value,
                            ExtendCondition condition){
        if (columnList == null){
            columnList = new ArrayList<>();
        }
        columnList.add(column);

        if (operatorList == null){
            operatorList = new ArrayList<>();
        }
        operatorList.add(operator);

        if (valueList == null){
            valueList = new ArrayList<>();
        }
        valueList.add(value);

        if (condition != null){
            if (extendList == null){
                extendList = new ArrayList<>();
            }
            extendList.add(condition);
        }
    }

    public void assignValue(List<String> column, List<Operator> operator, List<String> value,
                            ExtendCondition condition){
        if (columnList == null){
            columnList = new ArrayList<>();
        }
        columnList.addAll(column);

        if (operatorList == null){
            operatorList = new ArrayList<>();
        }
        operatorList.addAll(operator);

        if (valueList == null){
            valueList = new ArrayList<>();
        }
        valueList.addAll(value);

        if (condition != null){
            if (extendList == null){
                extendList = new ArrayList<>();
            }
            extendList.add(condition);
        }
    }
}
