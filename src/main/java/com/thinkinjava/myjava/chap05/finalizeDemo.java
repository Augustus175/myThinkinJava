package com.thinkinjava.myjava.chap05;

/**
 * Created by zhangzhibo-dell on 17-10-7.
 */
class finalizetest {
    public void finalize() {
        System.out.println("Year I am here ^_^");
    }
}

public class finalizeDemo {
    public static void main(String[] args) {
        int i = 10000000;
        while (i > 0) {
            new finalizetest();
            i--;
        }
//        System.gc();
        new finalizetest().finalize();
    }
}
