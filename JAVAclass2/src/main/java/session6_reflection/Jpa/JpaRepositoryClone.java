package session6_reflection.Jpa;

import session6_reflection.entity.Students;

import java.util.List;

public interface JpaRepositoryClone<T> {
    T getById(int id);
    Boolean insert (Students stu);
    List<T> getAll();
    List<T> getAll(int limit , int offset);

}
