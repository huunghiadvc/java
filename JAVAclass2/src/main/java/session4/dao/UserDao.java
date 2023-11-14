package session4.dao;

import session3.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    // tuong tac voi database
    boolean validateUser(String username , String password);
    User getByUserName(String username);
    Boolean insert(User u) throws SQLException;
    void update(User u);
    List<User> findAll(int limit , int offset);
    Integer count(String sql);
}
