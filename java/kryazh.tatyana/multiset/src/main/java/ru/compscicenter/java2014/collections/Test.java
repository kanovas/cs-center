package ru.compscicenter.java2014.collections;

import java.util.Iterator;

/**
 * Created by kano_vas on 27/10/14.
 */
public class Test {
    public static void main(String[] args) {
        MyMultiSet<String> a = new MyMultiSet<>();
        MyMultiSet<String> b = new MyMultiSet<>();
        a.add("hi", 4);
        a.add("bye", 3);
        b.add("hi");
        b.add("hii");
        a.print();
        a.retainAll(b);
        a.print();
        MyMultiSet<String> c = new MyMultiSet<>(b);
        c.print();
        Iterator it = c.iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
        c.print();
    }
}
