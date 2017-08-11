package com.thinkinjava.myjava.chap21;

/**
 * Created by zhangzhibo on 17-7-30.
 */
public class MoreBsicThread {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new LiftOff()).start();
        }
        System.out.println("Waiting for LiftOff");
    }
}
