package com.thinkinjava.myjava.chap05;

/**
 * Created by zhangzhibo-dell on 17-11-4.
 */
class I{
    int i ;
    void print(){
//       可以由Java进行自动初始化
        System.out.println(i);
    }
}
public class Initialization {
    static int j;
    public static void main(String[] args) {
        int i;
//       Java不会自动进行方法局部变量的初始化
//        System.out.println(i);
//       同样可以由Java进行自动初始化
        System.out.println(j);
    }
}
