package com.thinkinjava.myjava.chap21.bookexc;

/**
 * Created by zhangzhibo on 17-7-30.
 */
public class BasicThread {
    public static void main(String[] args) {
        Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("waiting for LiftOff");
    }
}
