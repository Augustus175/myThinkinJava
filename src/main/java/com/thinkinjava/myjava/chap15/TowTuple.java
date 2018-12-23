package com.thinkinjava.myjava.chap15;

public class TowTuple<A, B> {
    public final A first;
    public final B second;

    public TowTuple(A a, B b) {
        this.first = a;
        this.second = b;
    }

    @Override
    public String toString() {
        return "(" + first.getClass().getName() + " , "
                + second.getClass().getName() + ")";
    }
}
