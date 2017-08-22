package com.thinkinjava.myjava.chap21.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhangzhibo on 17-8-19.
 */

public class E04_Fibonacci2 {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new Fibonacci());
        }
        Thread.yield();
        exec.shutdown();
        exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new Fibonacci());
        }
        Thread.yield();
        exec.shutdown();
        exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new Fibonacci());
        }
        Thread.yield();
        exec.shutdown();
        exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new Fibonacci());
        }
        Thread.yield();
        exec.shutdown();
        exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new Fibonacci());
        }
        Thread.yield();
        exec.shutdown();
    }
}
