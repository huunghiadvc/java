package session4.thread;

import session3.User;
import session4.dao.impl.UserDaoImpl;
import session4.service.UserService;

import java.util.List;

public class ThreadTest implements Runnable {
    int id;
    int limit;
    UserDaoImpl obj;
    UserService sv;
    public ThreadTest(int id, int limit, UserDaoImpl obj, UserService sv) {
        this.id = id;
        this.limit = limit;
        this.obj = obj;
        this.sv = sv;
    }

    @Override
    public void run() {
        System.out.println("Thread " + id + " is running...");
        List<User> users = obj.findAll(limit, id*limit);
        String fileName = "src/main/java/session4/UserList.txt";
        if (sv.insertFile(users , fileName)){
            System.out.println("Successfully " + id * limit);
        }
        System.out.println("Thread " + id + " is finished running!!!");
    }
}
