package BasicThinking;

import java.util.ArrayList;
import java.util.Arrays;

public class Lesson8_1 {
    public static void main(String[] args){
        ArrayList<String> teams = new ArrayList<String>(Arrays.asList("t1","t2","t3","t4"));
        Lesson8_1.combine(teams,new ArrayList<>(),2);
    }
    /**
     * @Description:	使用函数的递归（嵌套）调用，找出所有可能的队伍组合
     * @param teams- 目前还剩多少队伍没有参与组合，result- 保存当前已经组合的队伍
     * @return void
     */
    public static void combine(ArrayList<String> teams,ArrayList<String> result,int length){
        if(result.size() == length){
            System.out.println(result);
            return;
        }
        for (int i = 0; i < teams.size(); i++) {
            ArrayList<String> newresult = (ArrayList<String>) result.clone();
            newresult.add(teams.get(i));
            ArrayList<String> newteams = new ArrayList<String>(teams.subList(i + 1, teams.size()));
            combine(newteams,newresult,length);
        }
    }
}
