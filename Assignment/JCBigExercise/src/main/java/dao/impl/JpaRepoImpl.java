package dao.impl;

import annotations.data.Column;
import annotations.data.Id;
import annotations.data.Table;
import config.DataSource;
import dao.JpaRepo;
import entity.SearchEngine;
import lombok.Getter;
import utils.validate.ResultUtils;
import utils.statement.StatementUtils;
import utils.SqlBuilder.SqlBuilder;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.*;

@Getter
public abstract class JpaRepoImpl<T> implements JpaRepo<T> {
    private String tableName;
    private Id idColumn;
    private final List<Column> columnName;

    protected abstract List<T> rowMapper(ResultSet rs);

    public JpaRepoImpl(Class<?> clazz) {
        columnName = new ArrayList<>();
        Table tableAnnotation = clazz.getAnnotation(Table.class);

        // lấy tên bảng
        this.tableName = clazz.getSimpleName();
        if (tableAnnotation != null) {
            this.tableName = tableAnnotation.tableName();
        }

        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            Id idAnnotation = f.getAnnotation(Id.class);
            if (idAnnotation != null){
                idColumn = idAnnotation;
            }
            Column column = f.getAnnotation(Column.class);
            if (column != null){
                columnName.add(column);
            }
        }

        if (columnName.isEmpty()){
            System.err.println("Column name is empty!");
        }
    }
    @Override
    public void insert(T obj) {
        Connection connection = DataSource.getConn();
        String sql = SqlBuilder.insert(tableName, columnName);
        System.out.println(sql);
        PreparedStatement preStmt;
        try {
            preStmt = connection.prepareStatement(sql);
            StatementUtils.setValues(preStmt, columnName, obj);
            System.out.println(preStmt);
            if (preStmt.executeUpdate() > 0){
                System.err.println("INSERT NEW "+ obj.getClass().getSimpleName()+ " SUCCESSFULLY!");
            } else {
                System.err.println("INSERT NEW "+ obj.getClass().getSimpleName()+ " FAILED!");
            }
        } catch (SQLException e) {
            System.err.println("INSERT NEW "+ obj.getClass()+ " FAILURE!");
        }
    }

    @Override
    public void insert(List<T> objList) {
        Connection connection = DataSource.getConn();
        String sql = SqlBuilder.insert(tableName, columnName);
        System.out.println(sql);
        PreparedStatement preStmt;
        try {
            preStmt = connection.prepareStatement(sql);
            for (T obj : objList){
                StatementUtils.setValues(preStmt, columnName, obj);
                preStmt.addBatch();
            }
            ResultUtils resultUtils = new ResultUtils();
            for (int i : preStmt.executeBatch()){
                System.err.println(i);
                resultUtils.resultCheck(i);
            }
            resultUtils.resultReport();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public T getById(long id) {
        String sql = SqlBuilder.getById(tableName, idColumn.columnName());
        Connection connection = DataSource.getConn();
        PreparedStatement preStmt;
        try {
            preStmt = connection.prepareStatement(sql);
            preStmt.setLong(1, id);
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
    public List<T> getAll(Integer limit, Integer offset) {
        String sql  = SqlBuilder.getAll(tableName, limit, offset);
        System.out.println(sql);
        PreparedStatement preSt;
        Connection conn = DataSource.getConn();
        try {
            preSt  = conn.prepareStatement(sql);
            ResultSet rs = preSt.executeQuery();
            List<T> data = rowMapper(rs);
            if(data != null && !data.isEmpty()){
                return data;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<T> search(SearchEngine searchEngine) {
        String sql = SqlBuilder.search(searchEngine, tableName);
        System.out.println(sql);
        PreparedStatement preSt;
        Connection conn = DataSource.getConn();
        try {
            preSt  = conn.prepareStatement(sql);
            StatementUtils.setValues(preSt, searchEngine.getValueList());
            ResultSet rs = preSt.executeQuery();
            List<T> data = rowMapper(rs);
            if(data != null && !data.isEmpty()){
                return data;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void updateById(long id, Map<String, String> updates) {
        List<String> keys = updates.keySet().stream().toList();
        String sql = SqlBuilder.updateById(tableName, idColumn.columnName(), keys);
        System.out.println(sql);
        Connection conn = DataSource.getConn();
        PreparedStatement preStmt;
        try {
            preStmt  = conn.prepareStatement(sql);
            List<String> values = new ArrayList<>(updates.values().stream().toList());
            values.add(String.valueOf(id));
            StatementUtils.setValues(preStmt, values);
            if (preStmt.executeUpdate() > 0){
                System.out.println("UPDATED SUCCESSFULLY!");
            } else {
                System.out.println("UPDATED FAILED!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(long id) {
        String sql = SqlBuilder.deleteById(tableName, idColumn.columnName());
        System.out.println(sql);
        Connection connection = DataSource.getConn();
        PreparedStatement preStmt;
        try {
            preStmt = connection.prepareStatement(sql);
            preStmt.setLong(1, id);
            if (preStmt.execute()){
                System.out.println("Delete id " + id + " from table " + tableName + " successfully!");
            } else {
                System.out.println("Delete id " + id + " from table " + tableName + " failed!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
