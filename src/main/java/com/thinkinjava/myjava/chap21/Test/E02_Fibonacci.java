package com.thinkinjava.myjava.chap21.Test;

import java.util.Arrays;

/**
 * Created by zhangzhibo on 17-7-31.
 */
class Fibonacci implements Runnable{
    private static int count;
    private final int id;
    Fibonacci(){
        this.id = ++count;
    }
    private int fibonacci(int n){
        if(n<=2){
            return 1;
        }
        int a = 1;
        int b = 1;
        int c = 0;
        for (int i = 3; i <= n; i++) {
            c = a+b;
            b = a;
            a = c;
        }
        return c;
    }
    public void run(){
        int[] sequence = new int[id];
        for (int i = 0; i < id; i++) {
            sequence[i] = fibonacci(i+1);
        }
        System.out.println("Seq : of "+id+" : "+ Arrays.toString(sequence));
    }
}
public class E02_Fibonacci {
    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            new Thread(new Fibonacci()).start();
        }
    }
}
