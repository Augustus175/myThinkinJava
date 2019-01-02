package com.thinkinjava.myjava.chap15;

class GenericBase<T> {
    private T element;

    public void set(T arg) {
        element = arg;
    }

    public T get() {
        System.out.println(element.getClass().getName());
        return element;
    }
}

class Drived1<T> extends GenericBase<T> {
}

class Drived2 extends GenericBase {
}

//class Drived3 extends GenericBase<?> {
//
//}

public class ErasureAndInheritance {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Drived2 d2 = new Drived2();
        Object object = d2.get();
        d2.set(object);
    }
}
