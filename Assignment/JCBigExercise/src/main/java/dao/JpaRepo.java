package dao;

import entity.Product;

import java.util.List;

public interface JpaRepo<T> {
    void insert(T product);
    void insert(List<T> objList);
    T getById(String id);
    List<T> getAll();
    List<T> getAll(int limit , int offset);
    boolean deleteById(long id);
    boolean update(long id);
}
