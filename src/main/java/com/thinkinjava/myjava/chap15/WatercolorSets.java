package com.thinkinjava.myjava.chap15;

import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class WatercolorSets {
    public static void main(String[] args) {
//        Set<Watercolors> set1 = EnumSet.range(Watercolors.BRILLIANT_RED,Watercolors.VIRIDIAN_HUE);
//        Set<Watercolors> set2 = EnumSet.range(Watercolors.CERULEN_BLUE_HUE,Watercolors.BURNT_UMBER);
        Set<Latters> set1 = EnumSet.range(Latters.A,Latters.E);
        Set<Latters> set2 = EnumSet.range(Latters.C,Latters.J);
        Iterator iterator= set1.iterator();
        System.out.println("set1 is :");
        while (iterator.hasNext()){
            System.out.print(iterator.next());
            System.out.print(" ");
        }
        System.out.println();
        iterator = set2.iterator();
        System.out.println("set2 is :");
        while (iterator.hasNext()){
            System.out.print(iterator.next());
            System.out.print(" ");
        }
        System.out.println();
        System.out.println("union is :");
        iterator = Sets.union(set1,set2).iterator() ;
        while (iterator.hasNext()){
            System.out.print(iterator.next());
            System.out.print(" ");
        }
        System.out.println();
        System.out.println("intersection is :");
        iterator = Sets.intersection(set1,set2).iterator() ;
        while (iterator.hasNext()){
            System.out.print(iterator.next());
            System.out.print(" ");
        }
        System.out.println();
        System.out.println("difference is :");
        iterator = Sets.diffrence(set1,set2).iterator() ;
        while (iterator.hasNext()){
            System.out.print(iterator.next());
            System.out.print(" ");
        }
        System.out.println();
        System.out.println("complement is :");
        iterator = Sets.complement(set1,set2).iterator() ;
        while (iterator.hasNext()){
            System.out.print(iterator.next());
            System.out.print(" ");
        }




    }
}
