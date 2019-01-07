package com.thinkinjava.myjava.chap15;

public class Coffee {
    private static long count = 1;
    public final long id;

    public Coffee() {
        this.id = count++;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + id;
    }
}

class Latte extends Coffee {
}

class Mocha extends Coffee {
}
