package com.thinkinjava.myjava.chap15;

public class CountedObject {
    private static long counter = 0;
    private final long id = counter++;

    public long id() {
        return id;
    }

    @Override
    public String toString() {
        return "CountedObjet " + id;
    }
}
