package com.thinkinjava.myjava.chap15;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Fruit {
}

class Apple extends Fruit {
}

class Jonathan extends Apple {
}

class Orange extends Fruit {
}

public class CovariantArrays {
    public static void main(String[] args) {
        Fruit[] fruits = new Apple[10];
        fruits[0] = new Apple();
        fruits[1] = new Jonathan();
        try {
            fruits[0] = new Fruit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            fruits[0] = new Orange();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        List<? extends Fruit> fruitList = new ArrayList<Apple>();
//        fruitList.add(new Apple());
//        fruitList.add(new Fruit());
//        fruitList.add(new Object());
//        fruitList.add(null);
        List<? extends Fruit> fruitList = Arrays.asList(new Apple());
        Apple apple = (Apple) fruitList.get(0);
        System.out.println(fruitList.contains(new Apple()));
        System.out.println(fruitList.indexOf(new Apple()));

    }
}
