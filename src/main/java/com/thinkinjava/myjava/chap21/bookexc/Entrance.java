package com.thinkinjava.myjava.chap21.bookexc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Count {
    private int count = 0;
    private Random random = new Random(47);

    public synchronized int increment() {
        int temp = count;
        if (random.nextBoolean()) {
            Thread.yield();
        }
        return (count = ++temp);
    }

    public synchronized int value() {
        return count;
    }
}


public class Entrance implements Runnable {
    public static Count count = new Count();
    private static List<Entrance> entrances = new ArrayList<>();
    private int number = 0;
//    private final int id;
    private static volatile boolean canceled = false;

    public static void cancel() {
        canceled = true;
    }

    @Override
    public void run() {
    }
}
