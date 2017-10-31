package com.thinkinjava.myjava.chap05;

/**
 * Created by zhangzhibo-dell on 17-10-8.
 */
public class OverloadingVaratgs2 {
    //    static void  f(float i,Character... args){
//        System.out.println("first");
//    }
    static void f(Character... args) {
        System.out.println("second");
    }

    public enum Spiciness {
        NOT, HOT
    }

    public static void main(String[] args) {
//        f(1,'a');
        f('a', 'b');
    }
}
