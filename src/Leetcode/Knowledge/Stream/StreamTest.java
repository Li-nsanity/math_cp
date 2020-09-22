package Leetcode.Knowledge.Stream;

import java.util.ArrayList;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        ArrayList<String> manList = new ArrayList<>();
        manList.add("周润发");
        manList.add("成龙");
        manList.add("刘德华");
        manList.add("吴京");
        manList.add("周星驰");
        manList.add("李连杰");
        ArrayList<String> womenList = new ArrayList<>();
        womenList.add("林心如");
        womenList.add("张曼玉");
        womenList.add("林青霞");
        womenList.add("柳岩");
        womenList.add("林志玲");
        womenList.add("王祖贤");
        Stream<String> manStream = manList.stream().filter(s -> s.length() == 3).limit(3);
        Stream<String> womenStream = womenList.stream().filter(s -> s.startsWith("林")).skip(1);
        Stream<String> stream = Stream.concat(manStream, womenStream);
        stream.map(Actor::new).forEach(p->System.out.println(p.getName()));
    }
}
