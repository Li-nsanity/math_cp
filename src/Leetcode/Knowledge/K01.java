package Leetcode.Knowledge;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class K01 {
    public static void main(String[] args) {
        Integer i1 = Integer.valueOf(100);
        Integer i2 = 100;
        Integer i3 = 200;
        Integer i4 = 200;
        System.out.println(i1 == i2);
        System.out.println(i3 == i4);
        Collection<String> c = new ArrayList<>();
        c.add("helo");
        Iterator<String> it = c.iterator();
    }
}
