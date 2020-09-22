package Leetcode.Knowledge.Stream;

import java.util.ArrayList;

public class StreamDemo {
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("关婷娜");
        arr.add("李纯");
        arr.add("李沁");
        arr.add("贾青");
        arr.add("虞书欣");
        arr.add("宋佳");
        arr.add("甘婷婷");
        arr.add("张书维");
        arr.add("刘诗诗");
        arr.add("刘亦菲");
        arr.stream().filter(s -> s.startsWith("李")).forEach(System.out::println);
        System.out.println("-------------");
        arr.stream().filter(s -> s.length() == 3).forEach(System.out::println);
        System.out.println("-------------");
        arr.stream().limit(3).forEach(System.out::println);
        System.out.println("-------------");
        arr.stream().skip(3).forEach(System.out::println);
        System.out.println("-------------");
        arr.stream().sorted((s1, s2) -> {
            int num = s1.length() - s2.length();
            int num2 = num == 0 ? s1.compareTo(s2) : num;
            return num2;
        }).forEach(System.out::println);
    }
}
