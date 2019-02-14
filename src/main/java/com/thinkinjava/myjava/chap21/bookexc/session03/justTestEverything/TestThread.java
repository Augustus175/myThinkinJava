package com.thinkinjava.myjava.chap21.bookexc.session03.justTestEverything;


/**
 * Created by zhangzhibo-dell on 17-8-21.
 */

class TestSync {
    public void run1() {
        synchronized (this){
            for (int i = 0; i < 10; i++) {
                System.out.println("execute run1");
                Thread.yield();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
   TestThread tt = new TestThread();
    public synchronized void run2() {
        synchronized (tt){
            for (int i = 0; i < 10; i++) {
                Thread.yield();
                System.out.println("execute run2");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

public class TestThread {
    public static void main(String[] args) {
        final TestSync testSync = new TestSync();

        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                testSync.run1();
            }
        });

//        Thread thread2 = new Thread(new Runnable() {
//            public void run() {
//                testSync.run2();
//            }
//        });

        thread1.start();
        testSync.run2();
//        thread2.start();
    }
}


