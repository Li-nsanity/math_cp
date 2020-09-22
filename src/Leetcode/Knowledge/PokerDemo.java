package Leetcode.Knowledge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

public class PokerDemo {
    public static void main(String[] args) {
        HashMap<Integer, String> hm = new HashMap<>();
        ArrayList<Integer> arr = new ArrayList<>();
        String[] huase = {"♠", "♥", "♣", "♦"};
        String[] shuzi = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "1", "2"};
        int bianhao = 0;
        for (String hs : huase) {
            for (String sz : shuzi) {
                hm.put(bianhao, hs + sz);
                arr.add(bianhao);
                bianhao++;
            }
        }
        hm.put(bianhao, "小王");
        arr.add(bianhao);
        bianhao++;
        hm.put(bianhao, "大王");
        arr.add(bianhao);
        Collections.shuffle(arr);
        TreeSet<Integer> s1 = new TreeSet<>();
        TreeSet<Integer> s2 = new TreeSet<>();
        TreeSet<Integer> s3 = new TreeSet<>();
        TreeSet<Integer> dp = new TreeSet<>();
        for (int i = 0; i < arr.size(); i++) {
            if (i >= arr.size() - 3) {
                dp.add(arr.get(i));
            } else if (i % 3 == 0) {
                s1.add(arr.get(i));
            } else if (i % 3 == 1) {
                s2.add(arr.get(i));
            } else if (i % 3 == 2) {
                s3.add(arr.get(i));
            }
        }
        lookPoker("张天爱", s1, hm);
        lookPoker("李沁", s2, hm);
        lookPoker("李纯", s3, hm);
        lookPoker("底牌", dp, hm);
    }

    public static void lookPoker(String name, TreeSet<Integer> ts, HashMap<Integer, String> hm) {
        StringBuilder s = new StringBuilder();
        s.append(name);
        for (Integer t : ts) {
            String p = hm.get(t);
            s.append(p);
            s.append(" ");
        }
        String sl = s.toString();
        System.out.println(sl);
    }
}
