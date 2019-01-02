package com.thinkinjava.myjava.chap15;

public class Holder<T> {
    private T value;

    public Holder() {
    }

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }

    public static void main(String[] args) {
        Holder<Apple> Apple = new Holder<>();
        Apple apple = Apple.getValue();
        Apple.setValue(apple);
    }
}
