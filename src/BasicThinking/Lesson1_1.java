package BasicThinking;

import java.math.BigInteger;

public class Lesson1_1 {
    public static void main(String[] args) {
        int a = 53;
        //String b = "110101";
        String b = "11010";
        System.out.println(String.format(" 数字 %d 的二进制是 %s", a, Lesson1_1.decimalToBinary(a))); // 获取十进制数 53 的二进制数
        System.out.println(String.format(" 数字 %s 的十进制是 %d", b, Lesson1_1.binaryToDecimal(b))); // 获取二进制数 110101 的十进制数

    }

    /**
     * @param decimalSource
     * @return String
     * @Description: 十进制转换成二进制
     */
    public static String decimalToBinary(int decimalSource) {
        BigInteger bi = new BigInteger(String.valueOf(decimalSource));
        return bi.toString(2);
    }

    /**
     * @param binarySource
     * @return int
     * @Description: 二进制转换成十进制
     */
    public static int binaryToDecimal(String binarySource) {
        BigInteger bi = new BigInteger(binarySource, 2);  // 转换为 BigInteger 类型，参数 2 指定的是二进制
        return Integer.parseInt(bi.toString());     // 默认转换成十进制
    }

}

