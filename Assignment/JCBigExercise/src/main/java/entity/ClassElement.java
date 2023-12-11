package entity;

import annotations.data.Column;
import annotations.data.Id;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class ClassElement {
    private String tableName;
    private Id idColumn;
    private List<Column> columnName;

    public ClassElement() {
        if (columnName == null){
            columnName = new ArrayList<>();
        }
    }
}
