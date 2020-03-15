package BasicThinking;

import java.util.Arrays;

public class Lesson3_3 {
    public static void main(String[] args) {
        String[] dictionary = {"i", "am", "one", "of", "the", "authors", "in", "geekbang"};
        Arrays.sort(dictionary);
//        for (String s : dictionary) {
//            System.out.println(s);
//        }
//        String a = "i";
//        String b = "in";
//        System.out.println(a.compareTo(b));
        String wordToFind = "i";
        boolean found = Lesson3_3.search(dictionary, wordToFind);
        if (found) {
            System.out.println(String.format(" 找到了单词 %s", wordToFind));
        } else {
            System.out.println(String.format(" 未能找到单词 %s", wordToFind));
        }
    }
    public static boolean search(String[] dictionary,String wordToFind){
        if(wordToFind == null){
            return false;
        }
        if (dictionary.length == 0) {
            return false;
        }
        int left = 0, right = dictionary.length - 1;
        while (left <= right) {
            int middle = left + (right - left)/2;
            if (dictionary[middle].equals(wordToFind)) {
                return true;
            } else {
                if (dictionary[middle].compareTo(wordToFind) > 0) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
        }

        return false;
    }
}
