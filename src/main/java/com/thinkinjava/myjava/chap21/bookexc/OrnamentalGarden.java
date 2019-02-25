package com.thinkinjava.myjava.chap21.bookexc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Count {
    private int count = 0;
    private Random random = new Random(47);

    //    public int increment() {
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


class Entrance implements Runnable {
    public static Count count = new Count();
    private static List<Entrance> entrances = new ArrayList<>();
    private int number = 0;
    private final int id;
    private static volatile boolean canceled = false;

    public static void cancel() {
        canceled = true;
    }

    public Entrance(int id) {
        this.id = id;
        entrances.add(this);
    }

    @Override
    public void run() {
        while (!canceled) {
            synchronized (this) {
                ++number;
            }
        }
        System.out.println(this + " Total : " + count.increment());
        try {
            TimeUnit.MICROSECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Stopping " + this);
    }

    public synchronized int getValue() {
        return number;
    }

    public String toString() {
        return "Entrance " + id + ": " + getValue();
    }

    public static int getTotalCount() {
        return count.value();
    }

    public static int sumEntrance() {
        int sum = 0;
        for (Entrance entrance : entrances) {
            sum += entrance.getValue();
        }
        return sum;
    }
}

public class OrnamentalGarden {
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new Entrance(i));
        }
        TimeUnit.SECONDS.sleep(3);
        Entrance.cancel();
        exec.shutdown();
        if (!exec.awaitTermination(250, TimeUnit.SECONDS)) {
            System.out.println("Some task were not terminated!");
        }
        System.out.println("Total : " + Entrance.getTotalCount());
        System.out.println("Sum of Entrances : " + Entrance.sumEntrance());
    }
}
