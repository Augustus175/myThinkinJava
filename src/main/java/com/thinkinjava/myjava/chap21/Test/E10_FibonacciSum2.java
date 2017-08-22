package com.thinkinjava.myjava.chap21.Test;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by zhangzhibo-dell on 17-8-19.
 */
class FibonacciSum2 {

    private static ExecutorService exec;

    private int fibonacci(int n) {
        int count = 0;
        if (n <= 2) {
            for (int i = 0; i < n; i++) {
                count++;
            }
            return count;
        }
        int a = 1;
        int b = 1;
        int c = 0;
        count = 2;
        for (int i = 3; i <= n; i++) {
            c = a + b;
            b = a;
            a = c;
            count += c;
        }
        return count;
    }

    public synchronized Future<Integer> runTask(final int n) {
        if (exec == null) {
            return null;
        }
        return exec.submit(new Callable<Integer>() {
            public Integer call() {
                return fibonacci(n);
            }
        });
    }

    public synchronized void init() {
        if (exec == null) {
            exec = Executors.newCachedThreadPool();
        }
    }

    public synchronized void shutdown() {
        if (exec != null) {
            exec.shutdown();
            exec = null;
        }
    }
}

public class E10_FibonacciSum2 {
    public static void main(String[] args) {
        ArrayList<Future<Integer>> results = new ArrayList<Future<Integer>>();
        FibonacciSum2 fibonacciSum2 = new FibonacciSum2();
        fibonacciSum2.init();
        for (int i = 0; i < 5; i++) {
            results.add(fibonacciSum2.runTask(i));
        }
        Thread.yield();
        fibonacciSum2.shutdown();
        for (Future<Integer> fi :
                results) {
            try {
                System.out.println(fi.get());
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }
}
