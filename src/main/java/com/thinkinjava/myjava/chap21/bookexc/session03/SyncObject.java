package com.thinkinjava.myjava.chap21.bookexc.session03;

class DualSynch {
    private Object synOnject = new Object();

    public synchronized void f() {
        for (int i = 0; i < 5; i++) {
            System.out.println("f()");
            Thread.yield();
        }
    }

    public void g() {
        synchronized (synOnject) {
            for (int i = 0; i < 5; i++) {
                System.out.println("g()");
                Thread.yield();
            }
        }
    }
}

public class SyncObject {
    public static void main(String[] args) {
        final DualSynch dualSynch = new DualSynch();
        new Thread() {
            public void run() {
                dualSynch.f();
            }
        }.start();
        dualSynch.g();
    }
}
