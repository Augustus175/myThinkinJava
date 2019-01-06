package com.thinkinjava.myjava.chap15;

import java.util.Date;

interface TimeStampeds {
    long getStamp();
}

class TimeStampImp implements TimeStampeds {
    private final long timeStamp;

    public TimeStampImp() {
        timeStamp = new Date().getTime();
    }

    @Override
    public long getStamp() {
        return this.timeStamp;
    }
}

interface SerialNumbereds {
    long getSerialNumber();
}

class SerialNumberedImp implements SerialNumbereds {
    static long counter = 1;
    private final long serialNumberer = counter++;

    public long getSerialNumber() {
        return this.serialNumberer;
    }
}

interface BasicA {
    void set(String val);

    String get();
}

class BasicImp implements BasicA {
    private String value;

    @Override
    public void set(String value) {
        this.value = value;
    }

    @Override
    public String get() {
        return this.value;
    }
}

class Minin extends BasicImp implements TimeStampeds, SerialNumbereds {
    private TimeStampeds timeStamped = new TimeStampImp();
    private SerialNumbereds serialNumbered = new SerialNumberedImp();

    @Override
    public long getStamp() {
        return this.timeStamped.getStamp();
    }

    @Override
    public long getSerialNumber() {
        return this.serialNumbered.getSerialNumber();
    }
}

public class Mixins {
    public static void main(String[] args) {
        Minin minin1 = new Minin(), minin2 = new Minin();
        minin1.set("Test string 1");
        minin2.set("Test string 2");
        System.out.println(minin1.get() + " " + minin1.getStamp()
                + " " + minin1.getSerialNumber());
        System.out.println("===================================");
        System.out.println(minin2.get() + " " + minin2.getStamp()
                + " " + minin2.getSerialNumber());
    }
}
