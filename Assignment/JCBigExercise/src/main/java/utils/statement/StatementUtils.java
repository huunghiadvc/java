package utils.statement;

import entity.ClassElement;

import java.sql.PreparedStatement;

public interface StatementUtils<T> {
    PreparedStatement setValues(PreparedStatement preStmt, ClassElement classElement, T obj);
}
