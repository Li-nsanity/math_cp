package BasicThinking;

import java.util.ArrayList;

public class Lesson5_1 {
    public static void main(String[] args) {
        int totalReward = 20;
        Lesson5_1.get(totalReward, new ArrayList<Long>());
        System.out.println("总计："+count);
    }

    public static long[] rewards = {1, 2, 5, 10};
    //count计数器
    public static int count = 0;
    public static void get(long totalReward, ArrayList<Long> result) {
        //判断totalReward
        if (totalReward == 0) {
            System.out.println(result);
            count++;
        } else if (totalReward < 0) {
            return;
        } else {
            for(int i=0;i<rewards.length;i++){
                ArrayList<Long> newresult = (ArrayList<Long>) result.clone();
                newresult.add(rewards[i]);
                get(totalReward-rewards[i],newresult);
            }
        }
    }
}
