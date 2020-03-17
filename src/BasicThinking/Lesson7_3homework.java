package BasicThinking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Lesson7_3homework {
    public static void main(String[] args) {
        String password = password(4);
        System.out.println(password);
        int length = password.length();
        Lesson7_3homework.Bruteforce(new ArrayList<String>(), password, length);
    }

    public static String password(int length) {
        String[] str = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "g" ,"k", "l", "m", "n", "o",
                "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "1", "2", "3", "4" ,"5",
                "6", "7", "8", "9", "0", "!", "@", "$", "_"};
        String password = "";
        for (int i = 0; i < length; i++) {
            int temp = new Random().nextInt(str.length);
            String t = str[temp];
            password += t;
        }
        return password;
    }

    public static ArrayList<String> str = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "g" ,"k", "l", "m", "n", "o",
            "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "1", "2", "3", "4" ,"5",
            "6", "7", "8", "9", "0", "!", "@", "$", "_"));

    public static void Bruteforce(ArrayList<String> result, String password, int length) {
        if (result.size() == length) {
            //System.out.println(result);
            String pass = "";
            for (String s : result) {
                pass += s;
            }
            //System.out.println(pass);
            if (pass.equals(password)) {
                System.out.println("破解成功，密码为：" + pass);
            }
            return;
        }
        for (int i = 0; i < str.size(); i++) {
            String temp = str.get(i);
            ArrayList<String> newresult = (ArrayList<String>) result.clone();
            newresult.add(temp);
            Bruteforce(newresult, password, length);
        }
    }
}
