package com.thinkinjava.myjava.chap15;

import java.util.ArrayList;
import java.util.List;

class FArry {
    public static <T> T[] fill(T[] a, Generator<T> gen) {
        for (int i = 0; i < a.length; i++) {
            a[i] = gen.next();
        }
        return a;
    }

    public static <T> T[] fillInt(T[] a, List list) {
        for (int i = 0; i < a.length; i++) {
            a[i] = (T) list.get(i);
        }
        return a;
    }
}

public class PrimitveGenericTest {
    public static void main(String[] args) {
        String[] strings = FArry.fill(new String[7], new RandomGenerator.String(10));
        for (String s :
                strings) {
            System.out.print(s + " ");
        }
        System.out.println();
        Integer[] integers = FArry.fill(new Integer[7], new RandomGenerator.Integer());
        for (Integer i :
                integers) {
            System.out.println(i + " ");
        }
        System.out.println();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
//        int[] b = FArry.fillInt(new int[7], new ArrayList<>());
        int[] arrays = new int[10];
        arrays[1] = new Integer(10);
    }

}
