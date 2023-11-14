package session4.service.impl;

import session4.dao.UserDao;
import session4.dao.impl.UserDaoImpl;
import org.apache.commons.lang3.StringUtils;
import session3.User;
import session4.consts.UserStatus;
import session4.service.UserService;
import utils.encryptionUtils.AES256;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import static session4.consts.UserStatus.*;

public class UserServiceImpl implements UserService {

    private static final int MAX_LOGIN_FAIL = 5;

    UserDao userRepo = new UserDaoImpl();

    @Override
    public boolean login(String username, String password) {
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password))
            return false;

        User u = userRepo.getByUserName(username);

        String passwordEncrypt = AES256.encrypt(password);
        UserStatus userStatus = UserStatus.values()[u.getStatus() - 1];

        if (u.getPassword().equals(passwordEncrypt)){
            return switch (userStatus) {
                case ACTIVE -> {
                    u.setLoginFail(0);
                    userRepo.update(u);
                    yield true;
                }
                case INACTIVE -> {
                    System.out.println("Account is inactive!");
                    yield false;
                }
                case DELETED -> {
                    System.out.println("Account is deleted!");
                    yield true;
                }
                case BLOCKED -> {
                    System.out.println("Account is blocked!");
                    userRepo.update(u);
                    yield false;
                }
            };
        } else {
            if (u.getLoginFail() + 1 >= MAX_LOGIN_FAIL){
                // block user
                u.setLoginFail(u.getLoginFail() + 1);
                u.setStatus(BLOCKED.status);
            } else {
                u.setLoginFail(u.getLoginFail() + 1);
            }
            userRepo.update(u);
        }

        userRepo.validateUser(username, password);
        // get user by username (username unique)
        // tinh tu lan dang nhap moi nhat , toi da 5 lan dang nhap that bai
        // bo sung them 1 truong login_fail , status (active  , inactive)
        // compare password -> true : login ok / not ok
        return false;
    }

    @Override
    public void register(String username, String password) {
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password))
            System.out.println("Invalid!");

        User u = User.builder()
                    .username(username)
                    .password(AES256.encrypt(password))
                    .loginFail(0)
                    .status(1)
                    .createdAt(new Date())
                    .updatedAt(new Date())
                    .createdBy("admin")
                    .updatedBy("admin")
                    .build();
        UserDaoImpl objInsert = new UserDaoImpl();
        if (objInsert.insert(u))
            System.err.println("Resister successfully!");
    }

    @Override
    public boolean insertFile(List<User> users, String fileName) {
        File idea = new File(fileName);
        FileWriter writer;
        try {
            writer = new FileWriter(idea, true);
            users.forEach(user -> {
                try {
                    writer.write(user.toString()+"\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            writer.close();
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
