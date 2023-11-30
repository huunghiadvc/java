package DesignPattern.Strategy.Test.Factory;

import DesignPattern.Strategy.Test.entity.Customer;

import java.sql.ResultSet;
import java.util.Map;

public abstract class JpaRepoCloneImpl<K, V> implements JpaRepo<K, V> {
    public JpaRepoCloneImpl(Class<Customer> customerClass) {
    }

    protected abstract Map<K, V> rowMapper(ResultSet rs);

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
