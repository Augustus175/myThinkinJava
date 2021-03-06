package com.thinkinjava.myjava.chap21.bookexc;

/**
 * Created by zhangzhibo-dell on 17-8-22.
 */

public class MultiLock {
    public synchronized void f1(int count) {
        if (count-- > 0) {
            System.out.println("f1() calling f2() with count " + count);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//            }
            f2(count);
        }
    }

    public synchronized void f2(int count) {
        if (count-- > 0) {
            System.out.println("f2() calling f1() with count " + count);
            f1(count);
        }
    }

    public static void main(String[] args) throws Exception {
        final MultiLock multiLock = new MultiLock();
        new Thread() {
            public void run() {
                multiLock.f1(10);
            }
        }.start();
    }
}