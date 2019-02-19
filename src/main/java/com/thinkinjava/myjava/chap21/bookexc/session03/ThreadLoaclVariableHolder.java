package com.thinkinjava.myjava.chap21.bookexc.session03;

class Accessor implements Runnable {
    private final int id;

    public Accessor(int id) {
        this.id = id;
    }

    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            ThreadLoaclVariableHolder.increment();
            System.out.println(this);
            Thread.yield();
        }
    }

    public String toString() {
        return "#" + id + ": " + ThreadLoaclVariableHolder.get();
    }
}

public class ThreadLoaclVariableHolder {
    public static void main(String[] args) {
    }

    public static void increment() {
    }

    public static int get() {
        return 0;
    }
}
