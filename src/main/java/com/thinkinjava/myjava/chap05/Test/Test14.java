package com.thinkinjava.myjava.chap05.Test;

/**
 * Created by zhangzhibo-dell on 17-11-4.
 */
public class Test14 {
    static String a ="a";
    static String b;
    static{
        b = "b";
        System.out.println(b);
        if (a!=null){
            System.out.println("a is already initialized");
        }
    }
    String t;
    {
        t = "t";
        System.out.println(t);
    }
    public static void main(String[] args) {
        System.out.println("main()");
        System.out.println(b);
        System.out.println(a);
    }
}
