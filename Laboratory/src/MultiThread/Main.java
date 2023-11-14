package MultiThread;

import MultiThread.Thread.ThreadClone;

public class Main {
    public static void main(String[] args) {
//        ThreadClone threadFormat1 = new ThreadClone("1" , 10);
//        ThreadClone threadFormat2 = new ThreadClone("2" , 10);
//        Thread t1 = new Thread(threadFormat1);
//        Thread t2 = new Thread(threadFormat2);
//        t1.start();
//        t2.start();

//        Thread[] threadGroup = new Thread[];

        for (int i = 0; i < 10; i++){
            ThreadClone t = new ThreadClone(String.valueOf(i) , 10);
            Thread tRun = new Thread(t);
            tRun.start();
        }



    }
}
