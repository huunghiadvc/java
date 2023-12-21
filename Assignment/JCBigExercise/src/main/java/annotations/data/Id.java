package annotations.data;

import const_.DataType;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Id {
    String columnName();
    DataType type();
}
