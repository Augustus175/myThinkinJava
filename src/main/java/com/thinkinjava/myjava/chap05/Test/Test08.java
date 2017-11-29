package com.thinkinjava.myjava.chap05.Test;

/**
 * Created by zhangzhibo-dell on 17-11-3.
 */
public class Test08 {
    void f(){
        System.out.println("f()");
    }
    void g(){
        f();
        this.f();
    }

    public static void main(String[] args) {
        Test08 test08 = new Test08();
        test08.g();
    }
}
