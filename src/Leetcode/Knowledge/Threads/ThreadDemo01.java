package Leetcode.Knowledge.Threads;

public class ThreadDemo01 implements Runnable{
    @Override
    public void run() {
        int num = 1;
        while (num<50){
            for(char a = 'a';a <= 'z';a++){
                System.out.println(Thread.currentThread().getName()+"---"+a);
            }
            num++;
        }
    }
}
