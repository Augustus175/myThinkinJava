package com.thinkinjava.myjava.chap15;

import java.util.ArrayList;

public class TupleList<A, B> extends ArrayList<TowTuple<A, B>> {
    public static void main(String[] args) {
        TupleList<String, Integer> tupleList = new TupleList<>();
        tupleList.add(TupleTest.h());
        tupleList.add(TupleTest.h());
        for (TowTuple<String, Integer> i :
                tupleList) {
            System.out.println(i);
        }
    }
}
