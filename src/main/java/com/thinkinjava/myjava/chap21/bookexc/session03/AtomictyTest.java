package com.thinkinjava.myjava.chap21.bookexc.session03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhangzhibo-dell on 17-8-20.
 */
public class AtomictyTest implements Runnable{
    private  int i = 0;
    public int getValue(){
        return i;
    }
    private synchronized void evenIncrement(){
        i++;
        i++;
    }
    public void run(){
       while (true){
           evenIncrement();
       }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        AtomictyTest at = new AtomictyTest();
        exec.execute(at);
        while (true){
            int val = at.getValue();
            if (val%2!=0){
                System.out.println(val);
                System.exit(0);
            }
        }
    }
}
