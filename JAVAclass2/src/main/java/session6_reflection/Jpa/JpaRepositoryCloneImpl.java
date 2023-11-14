package session6_reflection.Jpa;

import StudentsLab.config.DataBaseConnect;
import session6_reflection.annotation.Column;
import session6_reflection.annotation.Id;
import session6_reflection.annotation.Table;
import session6_reflection.consts.StringSql;
import session6_reflection.entity.Students;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class JpaRepositoryCloneImpl<T> implements JpaRepositoryClone<T> {
    private  String tableName;
    private String idColumnName;
    private final List<String> columnName;
    protected abstract List<T> rowMapper(ResultSet rs);

    public JpaRepositoryCloneImpl(Class<?> clazz) {
        Table tableAnnotation = clazz.getAnnotation(Table.class);
        tableName = clazz.getSimpleName();
        if (tableAnnotation != null) {
            this.tableName = tableAnnotation.tableName();
        }
        Field[] fields = clazz.getDeclaredFields();
        this.columnName = new ArrayList<>();
        for (Field f : fields) {
            Id idAnnotation = f.getAnnotation(Id.class);
            if (idAnnotation != null) this.idColumnName = idAnnotation.columnName();

            Column column = f.getAnnotation(Column.class);
            if (column != null){
                this.columnName.add(column.columnName());
            }
        }

//        if (StringUtils.isEmpty(this.idColumnName)){
            // throw exception
//        }
    }

    @Override
    public T getById(int id) {
        StringBuilder sql = new StringBuilder(StringSql.SELECT_CLAUSE.val)
                .append(StringSql.SPACE.val).append(tableName)
                .append(StringSql.SPACE.val).append(StringSql.WHERE.val )
                .append(StringSql.SPACE.val).append(idColumnName)
                .append(StringSql.SPACE.val).append(StringSql.EQUAL.val)
                .append(StringSql.SPACE.val).append(StringSql.QUESTION_MARK.val);
        Connection connection = DataBaseConnect.getConnection();
        PreparedStatement preStmt;
        try {
            preStmt = connection.prepareStatement(sql.toString());
            preStmt.setInt(1, id);
            ResultSet rs = preStmt.executeQuery();
            List<T> data = rowMapper(rs);
            if(data != null && !data.isEmpty()){
                return data.getFirst();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Boolean insert(Students stu) {

        StringBuilder sql = new StringBuilder(StringSql.INSERT_INTO.val)
                .append(StringSql.SPACE.val).append(tableName)
                .append(StringSql.SPACE.val).append(setColumnName())
                .append(StringSql.SPACE.val).append(StringSql.VALUES.val)
                .append(StringSql.SPACE.val).append(setValuesInsert());

        Connection connection = DataBaseConnect.getConnection();
        PreparedStatement preStmt;

        try {
            preStmt = connection.prepareStatement(sql.toString());
            preStmt.setString (1, stu.getName());
            preStmt.setDate (2, (Date) stu.getDateOfBirth());
            preStmt.setString (3, stu.getAddress());
            preStmt.execute();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<T> getAll() {
        StringBuilder sql = new StringBuilder(StringSql.SELECT_CLAUSE.val)
                .append(StringSql.SPACE.val).append(tableName);

        Connection connection = DataBaseConnect.getConnection();
        PreparedStatement preStmt;

        try {
            preStmt = connection.prepareStatement(sql.toString());
            ResultSet rs = preStmt.executeQuery();
            List<T> data = rowMapper(rs);
            if(data != null && !data.isEmpty()){
                return data;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<T> getAll(int limit, int offset) {
        StringBuilder sql = new StringBuilder(StringSql.SELECT_CLAUSE.val)
                .append(StringSql.SPACE.val).append(tableName)
                .append(StringSql.SPACE.val).append(StringSql.ORDER_BY.val)
                .append(StringSql.SPACE.val).append(idColumnName)
                .append(StringSql.SPACE.val).append(StringSql.LIMIT.val)
                .append(StringSql.SPACE.val).append(limit)
                .append(StringSql.SPACE.val).append(StringSql.OFFSET.val)
                .append(StringSql.SPACE.val).append(offset)
                ;

        Connection connection = DataBaseConnect.getConnection();
        PreparedStatement preStmt;

        try {
            preStmt = connection.prepareStatement(sql.toString());
            ResultSet rs = preStmt.executeQuery();
            List<T> data = rowMapper(rs);
            if(data != null && !data.isEmpty()){
                return data;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public String setColumnName(){
        StringBuilder columnValue = new StringBuilder(StringSql.PARENTHESES.val);
        for (int i = 0; i < this.columnName.size(); i++) {
            if (i != this.columnName.size() - 1){
                columnValue.append(this.columnName.get(i));
                columnValue.append(StringSql.COMMA.val);
                continue;
            }
            columnValue.append(this.columnName.get(i));
        }
        columnValue.append(StringSql.PARENTHESES_CLOSE.val);
        return columnValue.toString();
    }

    public String setValuesInsert(){
        StringBuilder valueInsert = new StringBuilder(StringSql.PARENTHESES.val);
        for (int i = 0; i < this.columnName.size(); i++) {
            if (i != this.columnName.size() - 1){
                valueInsert.append(StringSql.QUESTION_MARK.val);
                valueInsert.append(StringSql.COMMA.val);
                continue;
            }
            valueInsert.append(StringSql.QUESTION_MARK.val);
        }
        valueInsert.append(StringSql.PARENTHESES_CLOSE.val);
        return valueInsert.toString();
    }

}
