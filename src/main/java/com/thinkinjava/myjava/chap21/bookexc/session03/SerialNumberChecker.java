package com.thinkinjava.myjava.chap21.bookexc.session03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhangzhibo-dell on 17-8-20.
 */
class SerialNumberGenerator {
    private static volatile int serialNumber = 0;

    //    public static synchronized int nextSerialNumber(){
    public static int nextSerialNumber() {
        return serialNumber++;
    }
}

class CircularSet {
    private int[] array;
    private int len;
    private int index = 0;

    public CircularSet(int len) {
        this.len = len;
        array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = -1;
        }
    }

    public synchronized void add(int i) {
        array[index] = i;
        index = ++index % len;
    }

    public synchronized boolean contains(int val) {
        for (int i = 0; i < len; i++) {
            if (array[i] == val) {
                return true;
            }
        }
        return false;
    }
}

public class SerialNumberChecker {
    private static final int SIZE = 10;
    private static CircularSet serials = new CircularSet(1000);
    private static ExecutorService exec = Executors.newCachedThreadPool();

    static class SerialChecker implements Runnable {
        public void run() {
            while (true) {
                int serial = SerialNumberGenerator.nextSerialNumber();
                if (serials.contains(serial)) {
                    System.out.println("Duplicate " + serial);
                    System.exit(0);
                }
                serials.add(serial);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < SIZE; i++) {
            exec.execute(new SerialChecker());
        }
        TimeUnit.SECONDS.sleep(10);
        System.out.println("No duplicate detected");
        System.exit(0);
    }
}
