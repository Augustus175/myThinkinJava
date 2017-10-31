package com.thinkinjava.myjava.chap05;

/**
 * Created by zhangzhibo-dell on 17-10-7.
 */
public class NewVarArgs {
    public static void printArray(Object... args) {
        for (Object obj :
                args) {
            System.out.print(obj + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printArray(new Object[]{new Integer(1),new Integer(2),new Integer(3)});
        printArray(new Object[]{"one","tow","three"});
        printArray(new Object[]{new A(),new A(),new A()});
        printArray((Object[])new Integer[]{1,2,3,});
        printArray();
        printArray("test");
    }
}
