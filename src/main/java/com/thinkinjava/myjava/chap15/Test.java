package com.thinkinjava.myjava.chap15;

public class Test {
    static TowTuple<String,Integer> f2(){
        return new TowTuple("12",1);
    }

    public static void main(String[] args) {
        f2();
    }
}
