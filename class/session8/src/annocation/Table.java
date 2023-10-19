package annocation;

import java.lang.annotation.*;

@Documented // Đánh dấu là 1 tài liệu trong java
@Target(ElementType.TYPE) // TYPE: phạm vi class
@Inherited // Có thể được kế thừa từ super class
@Retention(RetentionPolicy.RUNTIME) // nhận biết lúc runtime
public @interface Table {
    //
    String table_name();
    boolean indexing() default false;
    boolean pattrioning() default false;
}
