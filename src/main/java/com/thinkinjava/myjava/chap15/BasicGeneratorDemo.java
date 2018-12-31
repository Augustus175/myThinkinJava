package com.thinkinjava.myjava.chap15;

public class BasicGeneratorDemo {
    public static void main(String[] args) {
        Generator<CountedObject> gen = BasicGenerator.creat(CountedObject.class);
        Generator<CountedObject> gen2 = new BasicGenerator<>(CountedObject.class);
        for (int i = 0; i < 3; i++) {
            System.out.println(gen.next());
        }
        System.out.println("=======================");
        for (int i = 0; i < 3; i++) {
            System.out.println(gen.next());
        }
    }
}
