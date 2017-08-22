package com.thinkinjava.myjava.chap21.Test;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhangzhibo-dell on 17-8-19.
 */
class SleepingTask2 implements Runnable{
    private static Random rnd = new Random();
    private final int sleep_time = rnd.nextInt(10)+1;
    private final int id;

    public SleepingTask2(int id) {
        this.id = id;
    }
    public void run(){
        try{
            TimeUnit.SECONDS.sleep(sleep_time);
        }catch (Exception e){
            System.err.println("Interrupted "+ e);
        }
        System.out.println(id+" "+Thread.currentThread()+ " : "+sleep_time);
    }
}
public class E06SleepingTask2 {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 8; i++) {
            exec.execute(new SleepingTask2(i));
        }
        Thread.yield();
        exec.shutdown();
    }
}
