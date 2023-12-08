package session4;

import session3.User;
import session4.dao.impl.UserDaoImpl;
import session4.service.UserService;
import session4.service.impl.UserServiceImpl;
import session4.thread.ThreadTest;
import session4.thread.ThreadTest2;

import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws SQLException, RuntimeException {
        UserDaoImpl obj = new UserDaoImpl();
        UserService sv = new UserServiceImpl();

        User u = obj.getById(4);
        System.err.println(u);

        System.out.println("FIND BY CARD YEAR BEFORE 2013:");
        List<User> a = obj.findDateIdCard("2013-01-01");

        a.forEach(System.out::println);

//        User u = obj.getByUserName("demo1");
//        System.err.println(u);

//        UserService userService = new UserServiceImpl();
//        if (userService.login("admin", "admin@123")){
//            System.err.println("Login successfully!");
//        } else {
//            System.err.println("Login failure!");
//        }
//        userService.register("huunghia98er", "1029384756@Aa");
//        userService.register("admin", "admin@123");


//        int count = obj.count("select count(*) from user_table");
//
//        int limit = 1000;
//        int num = count / limit;
//
//        if (count % limit != 0) num++;

//        Thread[] threads = new Thread[8];

//        for (int i = 0; i < num; i++) {
//            // Create a new thread for each iteration
//            threads[i % 8] = new ThreadTest2(i, limit, obj, sv);
//
//            // Start the thread
//            threads[i % 8].start();
//
//            // If we have started 8 threads, wait for any one of them to finish
//            if (i % 8 == 7) {
//                waitForThreads(threads);
//            }
//        }
// Wait for any remaining threads to finish
//        waitForThreads(threads);


//        ExecutorService executor= Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
//        try {
//            for (int i = 0; i < num; i = i + 3) {
//                ThreadTest threadTest = new ThreadTest(i, limit, obj, sv);
//                Thread t1 = new Thread(threadTest);
//                t1.start();
//                ThreadTest threadTest2 = new ThreadTest(i + 1, limit, obj, sv);
//                Thread t2 = new Thread(threadTest2);
//                t2.start();
//                ThreadTest threadTest3 = new ThreadTest(i + 2, limit, obj, sv);
//                Thread t3 = new Thread(threadTest3);
//                t3.start();
//                t3.join();
//            }

//                executor.execute(new Thread(threadTest, String.valueOf(i)));
//                executor.execute(new Thread(threadTest2, String.valueOf(i+1)));
//                executor.execute(new Thread(threadTest3, String.valueOf(i+2)));
//                    for (int j = 1; j <= Runtime.getRuntime().availableProcessors(); j++) {
//                        ThreadTest threadTest = new ThreadTest(i+j, limit, obj, sv);
//                        executor.execute(new Thread(threadTest, String.valueOf(j)));
//                    }

//            for (int i = 0; i < num; i++) {
//                Runnable thread = new ThreadTest(i, limit, obj, sv);
//                Thread thread1 = new Thread(thread);
//                thread1.start();
//            }
//            }catch(Exception err){
//                err.printStackTrace();
//            }

//        executor.shutdown();

//        for (int i = 0; i < num; i++) {
//
//            List<User> users = obj.findAll(limit, i*limit);
//
//            String fileName = "src/main/java/session4/UserList.txt";
//            if (sv.insertFile(users , fileName)){
//
//            }
//        }

    }
}
