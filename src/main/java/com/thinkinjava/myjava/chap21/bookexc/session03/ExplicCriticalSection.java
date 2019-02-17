package com.thinkinjava.myjava.chap21.bookexc.session03;


class ExplicitPariManager1 extends PairManager {

    public synchronized void increment() {
        p.incrementX();
        p.incrementY();
        store(getPair());
    }
}

class ExplicitPariManager2 extends PairManager {

    public void increment() {
        Pair temp;
        lock.lock();
        try {
            p.incrementX();
            p.incrementY();
            temp = getPair();
        } finally {
            lock.unlock();
        }
        store(temp);
    }
}

public class ExplicCriticalSection {
    public static void main(String[] args) {
        PairManager
                pman1 = new ExplicitPariManager1(),
                pman2 = new ExplicitPariManager2();
        CriticalSection.testApproaches(pman1, pman2);
    }
}
