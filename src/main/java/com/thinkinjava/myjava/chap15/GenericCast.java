package com.thinkinjava.myjava.chap15;

import java.io.FileInputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.util.List;

class FixedSizeStack<T> {
    private int index = 0;
    private Object[] storage;

    public FixedSizeStack(int size) {
        storage = new Object[size];
    }

    public void push(T item) {
        storage[index++] = item;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        return (T) storage[--index];
    }
}

public class GenericCast {
    public static final int size = 10;

    public void f(String[] args) throws Exception {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(args[0]));

        List<Widget> shapes = (List<Widget>) objectInputStream.readObject();
    }

    public static void main(String[] args) {
        FixedSizeStack<String> strings = new FixedSizeStack<>(size);
        for (String s :
                "ABCDEFGHIJ".split("")) {
            strings.push(s);
        }
        for (int i = 0; i < size; i++) {
            String s = strings.pop();
            System.out.print(s + "-");
        }
        System.out.println();
    }
}
