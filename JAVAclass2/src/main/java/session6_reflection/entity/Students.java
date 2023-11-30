package session6_reflection.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import session6_reflection.annotation.Column;
import session6_reflection.annotation.Id;
import session6_reflection.annotation.Table;
import session6_reflection.consts.DataType;

import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Types;
import java.lang.reflect.Field;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(tableName = "students")
public class Students implements Human, Animal {
    @Id(columnName = "id")
    private int id;
    @Column(columnName = "name" , dataType = "VARCHAR")
    private String name;
    @Column(columnName = "date_of_birth" , dataType = "TimeStamp")
    private Date dateOfBirth;
    @Column(columnName = "address" , dataType = "VARCHAR")
    private String address;
}
