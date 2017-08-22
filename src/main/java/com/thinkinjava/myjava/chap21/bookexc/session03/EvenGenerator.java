package com.thinkinjava.myjava.chap21.bookexc.session03;

/**
 * Created by zhangzhibo-dell on 17-8-19.
 */
public class EvenGenerator extends IntGenerator {
    //    private int currentEvenValue = 0;
    private volatile int currentEvenValue = 0;

    //    public synchronized int next() {
    public int next() {
        ++currentEvenValue;
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }
}
