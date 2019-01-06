package com.thinkinjava.myjava.chap15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Pet {
}

class Cat extends Pet {
}

class Dog extends Pet {
}

public class CheckedList {
    @SuppressWarnings("unchecked")
    static void oldStyleMethod(List probablyDogd) {
        probablyDogd.add(new Cat());
    }

    public static void main(String[] args) {
        List<Dog> dog1 = new ArrayList<>();
        oldStyleMethod(dog1);
        List<Dog> dog2 = Collections.checkedList(new ArrayList<>(), Dog.class);
        try {
            oldStyleMethod(dog2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Pet> pets = Collections.checkedList(new ArrayList<>(), Pet.class);
        pets.add(new Dog());
        pets.add(new Cat());
    }
}
