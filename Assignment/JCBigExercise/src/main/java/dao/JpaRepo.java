package dao;

import entity.SearchEngine;

import java.util.List;
import java.util.Map;

public interface JpaRepo<T> {
    void insert(T product);
    void insert(List<T> objList);
    T getById(long id);
    List<T> getAll(Integer limit , Integer offset);
    public List<T> search(SearchEngine searchEngine);
    void deleteById(long id);
    void updateById(long id, Map<String, String> updates);
}
