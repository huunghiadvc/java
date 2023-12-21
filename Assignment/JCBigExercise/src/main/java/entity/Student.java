package entity;

import annotations.data.Column;
import annotations.data.Id;
import annotations.data.Table;
import const_.DataType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(tableName = "students", group = "data/")
public class Student {
    private static long autoId = 1;
    @Id(columnName = "id", type = DataType.BIGINT)
    private long id;
    @Column(columnName = "name", type = DataType.VARCHAR)
    private String name;
    @Column(columnName = "address", type = DataType.VARCHAR)
    private String address;
    @Column(columnName = "tel", type = DataType.VARCHAR)
    private String tel;
    public Student(String name, String address, String tel) {
        this.id = autoId++;
        this.name = name;
        this.address = address;
        this.tel = tel;
    }
}
