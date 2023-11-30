package DesignPattern.Strategy.Test.Factory;

import java.util.Map;

public interface JpaRepo<K, V> {
    V getById(int id);
    Boolean insert (V cus);
    Map<K, V> getAll();
    Map<K, V> getAll(int limit , int offset);
}
