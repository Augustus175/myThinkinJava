package com.thinkinjava.myjava.chap05.Test;

/**
 * Created by zhangzhibo-dell on 17-11-5.
 */
class unit{
    public unit(){
        System.out.println("initialization unit");
    }
    public void print(Object... args){
        for (Object object: args) {
            System.out.print(object+" ");
        }
        System.out.println();
    }
}
public class Test17 {
    public static void main(String[] args) {
        unit[] units;
        System.out.println("--------");
        units =new unit[] {new unit()};
        int[] a = {1};
        System.out.println(new unit());
        new unit().print();
        System.out.println(new char[0].getClass());
    }
}
