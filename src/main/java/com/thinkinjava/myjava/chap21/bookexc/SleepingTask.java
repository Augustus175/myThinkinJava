package com.thinkinjava.myjava.chap21.bookexc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhangzhibo on 17-7-31.
 */
public class SleepingTask extends LiftOff{
    public void run(){
        try{
            while(countDown-- >0){
                System.out.print(status());
                TimeUnit.MILLISECONDS.sleep(100);
            }
        }catch (InterruptedException e){
            System.err.println("Interrupted");
        }
    }
    public static void main(String[] args){
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new SleepingTask());
            exec.shutdown();
        }
    }

}
