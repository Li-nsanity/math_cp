package Leetcode;

public class Q1108 {
    public static void main(String[] args){
        String address = "1.1.1.1";
        //String result = defangIPaddr1(address);
        //String result = defangIPaddr2(address);
        String result = defangIPaddr3(address);
        System.out.println(result);
    }
    public static String defangIPaddr1(String address) {
        //System.out.println(address);
        String[] str = address.split("\\.");
        String result = "";
        for(int i = 0; i < str.length ;i++){
            String temp = str[i];
            if(i == str.length - 1){
                result += str[i];
            }else{
                result += str[i]+"[.]";
            }
        }
        return result;
    }
    public static String defangIPaddr2(String address) {
        return address.replaceAll("\\.","[.]");
    }
    public static String defangIPaddr3(String address) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            if (address.charAt(i) == '.') {
                s.append("[.]");
            } else {
                s.append(address.charAt(i));
            }
        }
        return s.toString();
    }
}
