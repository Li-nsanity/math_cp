package BasicThinking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Lesson7_1 {
    public static void main(String[] args) {
        ArrayList<String> t_horses = new ArrayList<>(Arrays.asList("t1", "t2", "t3"));
        Lesson7_1.permutation(t_horses,new ArrayList<String>());
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
    // 设置齐威王的马的出战顺序
    public static ArrayList<String> q_horses = new ArrayList<String>(Arrays.asList("q1", "q2", "q3"));

    /*
     * @Description: 使用函数的递归（嵌套）调用，找出所有可能的马匹出战顺序
     * @param horses- 目前还剩多少马没有出战，result- 保存当前已经出战的马匹及顺序
     * @return void
     */
    public static void permutation(ArrayList<String> horses, ArrayList<String> result) {
        if (horses.size() == 0) {
            System.out.println(result);
            compare(result, q_horses);
            System.out.println();
        }
        for (int i = 0; i < horses.size(); i++) {
            // 将之前的结果复制到新的结果中，在添加
            ArrayList<String> newresult = (ArrayList<String>) result.clone();
            newresult.add(horses.get(i));
            // 将出战的马匹删除
            ArrayList<String> reshorse = (ArrayList<String>) horses.clone();
            reshorse.remove(i);
            permutation(reshorse, newresult);
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
