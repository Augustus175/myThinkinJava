package com.thinkinjava.myjava.chap15;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class Fill {
    public static <T> void fill(Collection<T> collection,
                                Class<? extends T> classToken, int size) {
        for (int i = 0; i < size; i++) {
            try {
                collection.add(classToken.newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e1) {
                e1.printStackTrace();
            }
        }
    }

}

class Contract {
    private static long counter = 0;
    private final long id = counter++;

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}

class TitleTransfer extends Contract {
}

public class FillTest {
    public static void main(String[] args) {
        List<Contract> contracts = new ArrayList<>();
        Fill.fill(contracts, Contract.class, 2);
        Fill.fill(contracts, TitleTransfer.class, 2);
        for (Contract c :
                contracts) {
            System.out.println(c);
        }
        SimpleQueue<Contract> contractSimpleQueue = new SimpleQueue<>();
//        Fill.fill(contractSimpleQueue, Contract.class);
    }
}
