package com.thinkinjava.myjava.chap15;

import java.lang.reflect.Method;
import java.util.*;

public class ContainsMethodDifferences {
    static Set<String> methodSet(Class<?> type) {
        Set<String> result = new TreeSet<>();
        for (Method m :
                type.getMethods()) {
            result.add(m.getName());
        }
        return result;
    }

    static void interfaces(Class<?> type) {
        System.out.print("Interfaces in " + type.getSimpleName() + " :");
        List<String> resut = new ArrayList<>();
        for (Class<?> c :
                type.getInterfaces()) {
            resut.add(c.getSimpleName());
        }
        System.out.println(resut);
    }

    static Set<String> object = methodSet(Object.class);

    static {
//      object method : [clone, equals, getClass, hashCode, notify, notifyAll, toString, wait]
        object.add("clone");
    }

    static void difference(Class<?> superset, Class<?> subset) {
        System.out.print(superset.getSimpleName() + " extend " + subset.getSimpleName()
                + ", adds :");
        Set<String> comp = Sets.diffrence(methodSet(superset), methodSet(subset));
        comp.removeAll(object);
        System.out.println(comp);
        interfaces(superset);
    }

    public static void main(String[] args) {
        System.out.println("Collection : " +
                methodSet(Collection.class));
        interfaces(Collection.class);
        difference(Set.class, Collection.class);
        System.out.println("--------------------------------");
        difference(HashSet.class, Set.class);
        System.out.println("--------------------------------");
        difference(LinkedHashSet.class, HashSet.class);
        System.out.println("--------------------------------");
        difference(TreeSet.class, Set.class);
        System.out.println("--------------------------------");
        difference(List.class, Collection.class);
        System.out.println("--------------------------------");
        difference(ArrayList.class, List.class);
        System.out.println("--------------------------------");
        difference(LinkedList.class, List.class);
        System.out.println("--------------------------------");
        difference(Queue.class, Collection.class);
        System.out.println("--------------------------------");
        difference(PriorityQueue.class, Queue.class);
        System.out.println("--------------------------------");
        System.out.println("Map: " + methodSet(Map.class));
        difference(HashMap.class, Map.class);
        System.out.println("--------------------------------");
        difference(LinkedHashMap.class, HashMap.class);
        System.out.println("--------------------------------");
        difference(SortedMap.class, Map.class);
        System.out.println("--------------------------------");
        difference(TreeMap.class, Map.class);
        System.out.println("--------------------------------");
    }
}

