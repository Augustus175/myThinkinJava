package com.thinkinjava.myjava.chap15;

import java.util.ArrayList;
import java.util.List;

class Biology {
}

class Animal extends Biology {
}

//class Dog extends Animal {
//}

public class ExtendAndSuperTest {
    public static void main(String[] args) {
        List<? extends Animal> list1 = new ArrayList<>();
//        list1.add(new Animal());
//        list1.add(new Dog());

        List<? super Animal> list2 = new ArrayList<>();
        list2.add(new Animal());
//        list2.add(new Dog());
//        list2.add(new Biology());

    }
}
