package utils;

import annotations.data.Column;
import annotations.data.Id;
import annotations.data.Table;
import entity.ClassElement;

import java.lang.reflect.Field;

public class ClassUtils {
    public ClassElement getField(Class<?> clazz){
        ClassElement classElement = new ClassElement();

        Table tableAnnotation = clazz.getAnnotation(Table.class);

        // lấy tên bảng
        classElement.setTableName(clazz.getSimpleName());
        if (tableAnnotation != null) {
            classElement.setTableName(tableAnnotation.tableName());
        }

        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            Id idAnnotation = f.getAnnotation(Id.class);
            if (idAnnotation != null){
                classElement.setIdColumn(idAnnotation);
            }
            Column column = f.getAnnotation(Column.class);
            if (column != null){
                classElement.getColumnName().add(column);
            }
        }

        if (classElement.getColumnName().isEmpty()){
            System.err.println("Column name is empty!");
        }
        return classElement;
    }
}
