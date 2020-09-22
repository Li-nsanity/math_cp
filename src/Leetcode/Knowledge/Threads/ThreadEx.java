package Leetcode.Knowledge.Threads;

public class ThreadEx {
    public static void main(String[] args) {
        ThreadDemo01 chardemo = new ThreadDemo01();
        Thread t1 = new Thread(chardemo,"char");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName()+"---"+i);
                }
            }
        },"num");
        t1.start();
        t2.start();
    }
}
