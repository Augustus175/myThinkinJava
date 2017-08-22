package com.thinkinjava.myjava.chap21.Test;

import java.util.concurrent.*;

/**
 * Created by zhangzhibo-dell on 17-8-22.
 */
public class E22_BusyWait {
    private static volatile boolean flag;
    private static int spins;

    public static void main(String[] args) throws Exception {
        Runnable r1 = new Runnable() {
            public void run() {
//                for (; ; ) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(1000000000);
                    } catch (InterruptedException e) {
                        return;
                    }
                    flag = true;
                    System.out.println(flag);
//                }
            }
        };
        Runnable r2 = new Runnable() {
            public void run() {
//                for (; ; ) {
                    // The busy-wait loop
                    while (!flag &&
                            !Thread.currentThread().isInterrupted()){
                        spins++;
                        System.out.println("----> "+spins);
                    }
                    System.out.println("Spun " + spins + " times");
                    spins = 0;
                    flag = false;
                    System.out.println(flag);
                    if (Thread.interrupted())
                        return;
//                }
            }
        };
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(r1);
        exec.execute(r2);
        TimeUnit.SECONDS.sleep(1);
        exec.shutdownNow();
    }
}
