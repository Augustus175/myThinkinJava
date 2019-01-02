package com.thinkinjava.myjava.chap15;

import java.util.ArrayList;
import java.util.List;

public class ListMaker<T> {
    List<T> creat() {
        return new ArrayList<>();
    }

    List<T> creat2() {
        return new ArrayList();
    }

    public static void main(String[] args) {

    }
}
