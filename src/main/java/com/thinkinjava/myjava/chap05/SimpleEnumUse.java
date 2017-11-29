package com.thinkinjava.myjava.chap05;

/**
 * Created by zhangzhibo-dell on 17-11-5.
 */
enum Spininess {
    NOT, MILD, MEDIUM, HOT, FLAMING
}

public class SimpleEnumUse {
    public static void main(String[] args) {
        Spininess howHot = Spininess.FLAMING;
        System.out.println(howHot);
        for (Spininess s :
                Spininess.values()) {
            System.out.println(s+" .ordinal "+s.ordinal());
        }
    }
}
