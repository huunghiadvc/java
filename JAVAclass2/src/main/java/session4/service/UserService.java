package session4.service;

import session3.User;

import java.util.List;

public interface UserService {
    // xu ly nghiep vu
    boolean login(String username , String password);
    void register(String username , String password);
    boolean insertFile(List<User> users , String fileName);
}
