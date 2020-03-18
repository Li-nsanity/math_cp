package BasicThinking;

import java.util.ArrayList;
import java.util.Arrays;

public class Lesson8_2homework {
    public static void main(String[] args) {
        ArrayList<String> participants = new ArrayList<>(Arrays.asList("乔丹", "科比", "邓肯", "加内特"
                , "奥尼尔", "库里", "姚明", "詹姆斯", "麦迪", "安东尼"));
        int firstprize = 1;
        int secondprize = 2;
        int thirdprize = 3;
        Lesson8_2homework.lucky(participants,new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),firstprize,secondprize,thirdprize);
    }

    public static void lucky(ArrayList<String> participants, ArrayList<String> firstprize, ArrayList<String>
            secondprize, ArrayList<String> thirdprize, int f, int s, int t) {
        if(firstprize.size() == f && secondprize.size() == s && thirdprize.size() == t){
            System.out.println("一等奖："+firstprize);
            System.out.println("二等奖："+secondprize);
            System.out.println("三等奖："+thirdprize);
            return;
        }
        for(int i = 0;i < participants.size() ;i++){
            if(firstprize.size() < f){
                ArrayList<String> newfirstprize = (ArrayList<String>) firstprize.clone();
                newfirstprize.add(participants.get(i));
                ArrayList<String> newpanticipants = new ArrayList<>(participants.subList(i+1,participants.size()));
                lucky(newpanticipants,newfirstprize,secondprize,thirdprize,f,s,t);
            }else{
                if(secondprize.size() < s){
                    ArrayList<String> newsecondprize = (ArrayList<String>) secondprize.clone();
                    newsecondprize.add(participants.get(i));
                    ArrayList<String> newpanticipants = new ArrayList<>(participants.subList(i+1,participants.size()));
                    lucky(newpanticipants,firstprize,newsecondprize,thirdprize,f,s,t);
                }else{
                    ArrayList<String> newthirdprize = (ArrayList<String>) thirdprize.clone();
                    newthirdprize.add(participants.get(i));
                    ArrayList<String> newpanticipants = new ArrayList<>(participants.subList(i+1,participants.size()));
                    lucky(newpanticipants,firstprize,secondprize,newthirdprize,f,s,t);
                }
            }
        }
    }
}
