package com.thinkinjava.myjava.chap05.Test;

/**
 * Created by zhangzhibo-dell on 17-11-3.
 */
class Flower{
    Flower(String colour){
        System.out.println("The Flower's colour is "+ colour);
    }
    Flower(){
        this("red");
        System.out.println("this is default colour ");
    }
}
public class Test09 {
    public static void main(String[] args) {
        Flower flower1 = new Flower("yellow");
        Flower flower2 = new Flower();
    }
}
