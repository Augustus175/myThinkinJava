package com.thinkinjava.myjava.chap15;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
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
}
