package DesignPattern.Strategy.Test.Factory;

import java.util.Map;

public class JpaRepoCloneImpl<K, V> implements JpaRepo<K, V> {

    @Override
    public V getById(int id) {
        return null;
    }

    @Override
    public Boolean insert(V cus) {
        return null;
    }

    @Override
    public Map<K, V> getAll() {
        return null;
    }

    @Override
    public Map<K, V> getAll(int limit, int offset) {
        return null;
    }
}
