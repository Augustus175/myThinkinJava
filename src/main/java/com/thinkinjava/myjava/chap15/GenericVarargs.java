package com.thinkinjava.myjava.chap15;

import java.util.ArrayList;
import java.util.List;

public class GenericVarargs {
    public static <T> List<T> makeList(T... args) {
        List<T> result = new ArrayList<>();
        for (T item : args) {
            System.out.println("==========");
            result.add(item);
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> ls = makeList("A");
        for (String s :
                ls) {
            System.out.println(s);
        }
        System.out.println("=================");
        ls = makeList("ABCDEFGHIJKLMN".split(""));
        for (String s :
                ls) {
            System.out.println(s);
        }
    }
}
