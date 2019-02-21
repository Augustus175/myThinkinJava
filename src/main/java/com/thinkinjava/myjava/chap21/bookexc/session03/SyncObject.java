package com.thinkinjava.myjava.chap21.bookexc.session03;

class DualSynch {
    private Object synObject = new Object();

    public synchronized void f() {
        for (int i = 0; i < 5; i++) {
            System.out.println("f()");
            Thread.yield();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void g() {
        synchronized (synObject) {
            for (int i = 0; i < 5; i++) {
                System.out.println("g()");
                Thread.yield();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
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
