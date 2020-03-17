package BasicThinking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Lesson7_2 {
    public static void main(String[] args) {

        ArrayList<String> t_horses = new ArrayList<String>(Arrays.asList("t1", "t2", "t3"));
        ArrayList<ArrayList<String>> t_results = new ArrayList<>();
        Lesson7_2.permutate(t_horses, new ArrayList<String>(), t_results);

        ArrayList<String> q_horses = new ArrayList<String>(Arrays.asList("q1", "q2", "q3"));
        ArrayList<ArrayList<String>> q_results = new ArrayList<>();
        Lesson7_2.permutate(q_horses, new ArrayList<String>(), q_results);

        System.out.println(t_results);
        System.out.println(q_results);
        System.out.println();

        for (int i = 0; i < t_results.size(); i++) {
            for (int j = 0; j < q_results.size(); j++) {
                Lesson7_1.compare(t_results.get(i), q_results.get(j));
            }
        }

    }
    // 设置齐王的马跑完所需时间
    public static HashMap<String, Double> q_horses_time = new HashMap<String, Double>() {
        {
            put("q1", 1.0);
            put("q2", 2.0);
            put("q3", 3.0);
        }
    };
    // 设置田忌的马跑完所需时间
    public static HashMap<String, Double> t_horses_time = new HashMap<String, Double>() {
        {
            put("t1", 1.5);
            put("t2", 2.5);
            put("t3", 3.5);
        }
    };
    public static void permutate(ArrayList<String> horses, ArrayList<String> result, ArrayList<ArrayList<String>> t_result) {
        if(horses.size() == 0){
//            System.out.println(result);
//            System.out.println();
            t_result.add(result);
        }
        for (int i = 0; i < horses.size(); i++) {
            ArrayList<String> newresult = (ArrayList<String>) result.clone();
            newresult.add(horses.get(i));
            ArrayList<String> reshorses = (ArrayList<String>) horses.clone();
            reshorses.remove(i);
            permutate(reshorses,newresult,t_result);
        }
    }
    public static void compare(ArrayList<String> t, ArrayList<String> q) {
        int t_won_cnt = 0;
        for (int i = 0; i < t.size(); i++) {
            System.out.println(t_horses_time.get(t.get(i)) + "" + q_horses_time.get(q.get(i)));
            if (t_horses_time.get(t.get(i)) < q_horses_time.get(q.get(i))) t_won_cnt++;
        }
        if (t_won_cnt > (t.size() / 2)) {
            System.out.println("田忌获胜！");
        } else {
            System.out.println("齐威王获胜！");
        }
    }
}
