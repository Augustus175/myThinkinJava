package com.thinkinjava.myjava.chap21.Test;

/**
 * Created by zhangzhibo on 17-7-31.
 */
class Printer implements Runnable {
    public static int taskCount = 0;
    private final int id = taskCount++;

    Printer() {
        System.out.println("Task " + id + " Start ! ");
    }

    public void run() {
        System.out.println("Stage 1 , id = " + id);
        System.out.println("Stage 2 , id = " + id);
        System.out.println("Stage 3 , id = " + id);
        Thread.yield();
    }
}
public class E01_Runnable {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new Printer()).start();
        }
    }
}
