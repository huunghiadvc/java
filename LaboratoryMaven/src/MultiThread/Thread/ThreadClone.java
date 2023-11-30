package MultiThread.Thread;

public class ThreadClone implements Runnable {

    String id;
    int num;

    public ThreadClone(String id , int num) {
        this.id = id;
        this.num = num;
    }

    @Override
    public void run() {
        System.out.println("Thread " + id + " is running...");
        for (int i = 0; i < this.num; i++) {
            System.out.println("Thread " + id + " : " + i);
        }
        System.out.println("Thread " + id + " is finished running!!!");
    }
}
