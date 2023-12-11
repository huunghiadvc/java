package dao.impl;

import config.DataSource;
import dao.JpaRepo;
import entity.ClassElement;
import entity.Product;
import entity.ProductRepo;
import service.ProductService;
import utils.ClassUtils;
import utils.validate.ResultUtils;
import utils.statement.StatementUtils;
import utils.statement.impl.StatementUtilsImpl;
import utils.statement.SqlBuilder;
import java.sql.*;
import java.util.List;

public abstract class JpaRepoImpl<T> implements JpaRepo<T> {
    private final ClassElement classElement;

    protected abstract List<T> rowMapper(ResultSet rs);

    public JpaRepoImpl(Class<?> clazz) {
        ClassUtils annotationUtils = new ClassUtils();
        classElement = annotationUtils.getField(clazz);
    }

    public static void main(String[] args) {
        Product b = new Product("67", "46", "c", 1.2);
        Product a = new Product("45", "4rf36", "234", 1.9);
        ProductRepo.getProductList().add(b);
        ProductRepo.getProductList().add(a);
        JpaRepo<Product> service = new ProductService();
        service.insert(ProductRepo.getProductList());
    }
    @Override
    public void insert(T obj) {
        Connection connection = DataSource.getConn();
        String sql = SqlBuilder.insert(classElement);
        StatementUtils<T> stateUtils = (StatementUtils<T>) new StatementUtilsImpl();
        PreparedStatement preStmt;

        try {
            preStmt = connection.prepareStatement(sql);
            stateUtils.setValues(preStmt, classElement, obj);
            System.out.println(preStmt);
            if (preStmt.executeUpdate() != 0){
                System.err.println("INSERT NEW PRODUCT SUCCESSFULLY!");
            }
        } catch (SQLException e) {
            System.err.println("INSERT NEW PRODUCT FAILURE!");
        }
    }

    @Override
    public void insert(List<T> objList) {
        String sql = SqlBuilder.insert(classElement);
        StatementUtils<T> stateUtils = (StatementUtils<T>) new StatementUtilsImpl();

        Connection connection = DataSource.getConn();
        PreparedStatement preStmt;

        try {
            preStmt = connection.prepareStatement(sql);
            for (T obj : objList){
                stateUtils.setValues(preStmt, classElement, obj);
                preStmt.addBatch();
            }

            for (int i : preStmt.executeBatch()){
                ResultUtils.resultCheck(i);
            }
            ResultUtils.resultReport();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public T getById(String id) {
        String sql = SqlBuilder.getById(classElement.getTableName(), classElement.getIdColumn().columnName());

        Connection connection = DataSource.getConn();
        PreparedStatement preStmt;
        try {
            preStmt = connection.prepareStatement(sql);
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
    public List<T> getAll() {
        return null;
    }

    @Override
    public List<T> getAll(int limit, int offset) {
        return null;
    }

    @Override
    public boolean deleteById(long id) {
        return false;
    }

    @Override
    public boolean update(long id) {
        return false;
    }

}
