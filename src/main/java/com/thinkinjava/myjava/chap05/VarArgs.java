package com.thinkinjava.myjava.chap05;

/**
 * Created by zhangzhibo-dell on 17-10-7.
 */
class A {
    int i;

    void print() {
        System.out.println(i);
    }
}

public class VarArgs {
    static void printArray(Object[] args) {
        for (Object obj :
                args) {
            System.out.print(obj + " ");
        }
        System.out.println();
    }
static int i;

    public static void main(String[] args) {
        printArray(new Object[]{new Integer(1), new Integer(2), new Integer(3)});
        printArray(new Object[]{"one", "tow", "three"});
        printArray(new Object[]{new A(), new A(), new A()});
        A a = new A();
        a.print();

        System.out.println(i);
    }
}
