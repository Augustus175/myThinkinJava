package com.thinkinjava.myjava.chap05;

/**
 * Created by zhangzhibo-dell on 17-10-7.
 */
class Person{
    public void eat(Apple apple){
        Apple peeled = apple.getPeeled();
        System.out.println("Yummy");
    }
}
class Peeler{
    static Apple peel(Apple apple){
        return  apple;
    }
}
class Apple{
    public Apple getPeeled(){
        return Peeler.peel(this);
    }
}
public class PassingThis {
    public static void main(String[] args) {
        new Person().eat(new Apple());
    }
}
