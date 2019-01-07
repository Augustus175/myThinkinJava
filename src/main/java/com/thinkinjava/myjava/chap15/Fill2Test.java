package com.thinkinjava.myjava.chap15;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

interface Addable<T> {
    void add(T t);
}

class Fill2 {
    public static <T> void fill(Addable<T> addable,
                                Class<? extends T> classToken, int size) {
        for (int i = 0; i < size; i++) {
            try {
                addable.add(classToken.newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e1) {
                e1.printStackTrace();
            }
        }
    }

    public static <T> void fill(Addable<T> addable,
                                Generator<T> generator, int size) {
        for (int i = 0; i < size; i++) {
            addable.add(generator.next());
        }
    }
}

class AddableCollectionAdapter<T> implements Addable<T> {
    private Collection<T> c;

    public AddableCollectionAdapter(Collection<T> c) {
        this.c = c;
    }

    @Override
    public void add(T item) {
        c.add(item);
    }
}

class Adapter {
    public static <T>
    Addable<T> collectionAdapter(Collection<T> c) {
        return new AddableCollectionAdapter<T>(c);
    }
}

class AddableSimpleQueue<T> extends SimpleQueue<T> implements Addable<T> {
    @Override
    public void add(T item) {
        super.add(item);
    }
}

public class Fill2Test {
    public static void main(String[] args) {
        List<Coffee> carrier = new ArrayList<>();
        Fill2.fill(new AddableCollectionAdapter<>(carrier),
                Coffee.class, 3);
        Fill2.fill(new AddableCollectionAdapter<>(carrier),
                Latte.class, 3);
        for (Coffee c :
                carrier) {
            System.out.println(c);
        }
        System.out.println("-------------------------------");
        AddableSimpleQueue<Coffee> coffeeQueue = new AddableSimpleQueue<>();
        Fill2.fill(coffeeQueue, Mocha.class, 4);
        Fill2.fill(coffeeQueue, Latte.class, 4);
        for (Coffee c :
                coffeeQueue) {
            System.out.println(c);
        }
    }
}
