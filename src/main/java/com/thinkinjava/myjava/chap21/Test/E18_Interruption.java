package com.thinkinjava.myjava.chap21.Test;

import java.util.concurrent.*;
/**
 * Created by zhangzhibo-dell on 17-8-22.
 */

class NonTask {
    static void longMethod() throws InterruptedException {
        TimeUnit.SECONDS.sleep(60);  // Waits one minute
    }
}

class Task implements Runnable {
    public void run() {
        try {
            NonTask.longMethod();
        } catch (InterruptedException ie) {
            System.out.println(ie.toString());
        } finally {
            // Any cleanup code here...
        }
    }
}

public class E18_Interruption {
    public static void main(String[] args) throws Exception {
        Thread t = new Thread(new Task());
        t.start();
        TimeUnit.SECONDS.sleep(1);
        t.interrupt();
    }
}
