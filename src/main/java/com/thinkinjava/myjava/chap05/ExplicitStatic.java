package com.thinkinjava.myjava.chap05;

import java.util.Arrays;

/**
 * Created by zhangzhibo-dell on 17-10-7.
 */
class Cup {
    public Cup(int maker) {
        System.out.println("Cup(" + maker + ")");
    }

    public void f(int maker) {
        System.out.println("f(" + maker + ")");
    }
}


class Cups {
    static Cup cup1;
    static Cup cup2;

    static {
        cup1 = new Cup(1);
        cup2 = new Cup(2);
    }

    public Cups() {
        System.out.println("Cups()");
    }
}

public class ExplicitStatic {
    static Cups cups1 = new Cups();
    static Cups cups2 = new Cups();

    public static void main(String[] args) {
        int[] a = {1, 2,};
        int k = a.length;
        System.out.println(Arrays.toString(a));
        System.out.println("Inside main()");
        Cups.cup1.f(99);
    }
}
