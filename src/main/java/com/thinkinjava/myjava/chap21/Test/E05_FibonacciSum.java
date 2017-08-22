package com.thinkinjava.myjava.chap21.Test;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by zhangzhibo on 17-8-19.
 */
class FibonacciSum implements Callable<Integer> {
    private final int n;

    public FibonacciSum(int n) {
        this.n = n;
    }

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

    public Integer call() {
        return fibonacci(n);
    }
}

public class E05_FibonacciSum {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<Integer>> results = new ArrayList<Future<Integer>>();
        for (int i = 0; i < 8; i++) {
            results.add(exec.submit(new FibonacciSum(i)));
        }
        Thread.yield();
        exec.shutdown();
        for (Future<Integer> fi :
                results) {
            try{
                System.out.println(fi.get());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
