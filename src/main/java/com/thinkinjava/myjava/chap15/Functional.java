package com.thinkinjava.myjava.chap15;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

interface Combiner<T> {
    T combine(T x, T y);
}

interface UnaryFunction<R, T> {
    R function(T x);
}

interface Collector<T> extends UnaryFunction<T, T> {
    T result();
}

interface UnaryPredicate<T> {
    boolean test(T x);
}

public class Functional {
    public static <T> T
    reduce(Iterable<T> seq, Combiner<T> combiner) {
        Iterator<T> it = seq.iterator();
        if (it.hasNext()) {
            T result = it.next();
            while (it.hasNext()) {
                result = combiner.combine(result, it.next());
            }
            return result;
        }
        return null;
    }

    public static <T> Collector<T>
    forEach(Iterable<T> seq, Collector<T> func) {
        for (T t :
                seq) {
            func.function(t);
        }
        return func;
    }

    public static <R, T> List<R>
    transform(Iterable<T> seq, UnaryFunction<R, T> func) {
        List<R> result = new ArrayList<R>();
        for (T t :
                seq) {
            result.add(func.function(t));
        }
        return result;
    }

    public static <T> List<T>
    filter(Iterable<T> seq, UnaryPredicate<T> pred) {
        List<T> result = new ArrayList<>();
        for (T t :
                seq) {
            if (pred.test(t)) {
                result.add(t);
            }
        }
        return result;
    }

    static class IntegerAdder implements Combiner<Integer> {
        public Integer combine(Integer x, Integer y) {
            return x + y;
        }
    }

    static class
    IntegerSubtracter implements Combiner<Integer> {
        public Integer combine(Integer x, Integer y) {
            return x - y;
        }
    }

    static class
    BigDecimalAdder implements Combiner<BigDecimal> {
        public BigDecimal combine(BigDecimal x, BigDecimal y) {
            return x.add(y);
        }
    }

    static class
    BigIntegerAdder implements Combiner<BigInteger> {
        public BigInteger combine(BigInteger x, BigInteger y) {
            return x.add(y);
        }
    }

    static class
    AtomicLongAdder implements Combiner<AtomicLong> {
        public AtomicLong combine(AtomicLong x, AtomicLong y) {
            return new AtomicLong(x.addAndGet(y.get()));
        }
    }

    static class BigDecimalUlp
            implements UnaryFunction<BigDecimal, BigDecimal> {
        public BigDecimal function(BigDecimal x) {
            return x.ulp();
        }
    }

    static class GreaterThan<T extends Comparable<T>>
            implements UnaryPredicate<T> {
        private T bound;

        public GreaterThan(T bound) {
            this.bound = bound;
        }

        @Override
        public boolean test(T x) {
            return x.compareTo(bound) > 0;
        }
    }

    static class MultiplingIntegerCollector
            implements Collector<Integer> {
        private Integer val = 1;

        public Integer function(Integer x) {
            val *= x;
            return val;
        }

        public Integer result() {
            return val;
        }
    }

    public static void main(String[] args) {
        List<Integer> li = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        System.out.println("1==========================");
        Integer result = reduce(li, new IntegerAdder());
        System.out.println(result);
        System.out.println("2==========================");
        result = reduce(li, new IntegerSubtracter());
        System.out.println(result);
        System.out.println("3==========================");
        System.out.println(filter(li, new GreaterThan<>(4)));
        System.out.println("4==========================");
        System.out.println(forEach(li, new MultiplingIntegerCollector()).result());
        System.out.println("5==========================");
        System.out.println(forEach(filter(li, new GreaterThan<Integer>(4)),
                new MultiplingIntegerCollector()).result());
        System.out.println("6==========================");
        MathContext mc = new MathContext(7);
        List<BigDecimal> lbd = Arrays.asList(
                new BigDecimal(1.1, mc), new BigDecimal(2.2, mc),
                new BigDecimal(3.3, mc), new BigDecimal(4.4, mc));
        BigDecimal rbd = reduce(lbd, new BigDecimalAdder());
        System.out.println(rbd);
        System.out.println("7==========================");
        System.out.println(filter(lbd, new GreaterThan<>(new BigDecimal(3))));
        System.out.println("8==========================");
        List<BigInteger> lbi = new ArrayList<>();
        BigInteger bi = BigInteger.valueOf(11);
        for (int i = 0; i < 11; i++) {
            lbi.add(bi);
            bi = bi.nextProbablePrime();
        }
        System.out.println(lbi);
        System.out.println("9==========================");
        BigInteger rbi = reduce(lbi, new BigIntegerAdder());
        System.out.println(rbi);
        System.out.println("10==========================");
        System.out.println(rbi.isProbablePrime(5));
        System.out.println("11==========================");
        List<AtomicLong> lal = Arrays.asList(
                new AtomicLong(11), new AtomicLong(47),
                new AtomicLong(74), new AtomicLong(133));
        AtomicLong ral = reduce(lal, new AtomicLongAdder());
        System.out.println(ral);
        System.out.println("12==========================");
        System.out.println(transform(lbd, new BigDecimalUlp()));
    }
}
