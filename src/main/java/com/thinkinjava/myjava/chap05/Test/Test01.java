package com.thinkinjava.myjava.chap05.Test;

/**
 * Created by zhangzhibo-dell on 17-11-3.
 */
class MyString {
    String str;
}

public class Test01 {
    public static void main(String[] args) {
        MyString ms = new MyString();
        System.out.println(ms.str);


        double x = 0;

        f1((char)x);
    }

     static void f1(char x) {
        System.out.println("char");
    }

    static void f1(byte x) {
        System.out.println("byte");
    }

    static void f1(float x) {
        System.out.println("float");
    }
}
