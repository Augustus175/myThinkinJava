package com.thinkinjava.myjava.chap21.bookexc;

class Sleeper extends Thread {
    private int duration;

    public Sleeper(String name, int sleepTime) {
        super(name);
        duration = sleepTime;
        start();
    }

    public void run() {
        try {
            System.out.println("The " + Thread.currentThread().getName() + " is running.");
            Thread.sleep(duration);
            System.out.println("The " + Thread.currentThread().getName() + " done.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class Joiner extends Thread {
    private Sleeper sleeper;

    public Joiner(String name, Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }

    public void run() {
        try {
            System.out.println("The " + Thread.currentThread().getName() + " is waiting.");
            sleeper.join();
            System.out.println("The " + Thread.currentThread().getName() + " done.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

public class JoiningTest {
    public static void main(String[] args) {
        Sleeper sleeper = new Sleeper("Sleeper", 15000);
        Joiner joiner = new Joiner("Joiner", sleeper);
//        sleeper.interrupt();
    }
}
