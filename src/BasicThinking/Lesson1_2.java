package BasicThinking;

public class Lesson1_2 {
    public static void main(String[] args) {

        int num = 53;
        int m = 1;
        System.out.println(String.format(" 数字 %d 的二进制向左移 %d 位是 %d", num, m, Lesson1_2.leftShift(num, m)));   // 测试向左移位
        System.out.println(String.format(" 数字 %d 的二进制逻辑向右移 %d 位是 %d", num, m, Lesson1_2.locrightShift(num, m)));   // 测试逻辑右移
        System.out.println(String.format(" 数字 %d 的二进制算数向右移 %d 位是 %d", num, m, Lesson1_2.mathrightShift(num, m))); // 测试算术右移
        System.out.println();

        m = 3;
        System.out.println(String.format(" 数字 %d 的二进制向左移 %d 位是 %d", num, m, Lesson1_2.leftShift(num, m)));   // 测试向左移位
        System.out.println(String.format(" 数字 %d 的二进制逻辑向右移 %d 位是 %d", num, m, Lesson1_2.locrightShift(num, m)));   // 测试逻辑右移
        System.out.println(String.format(" 数字 %d 的二进制算数向右移 %d 位是 %d", num, m, Lesson1_2.mathrightShift(num, m)));   // 测试算术右移
    }

    /**
     * @param num- 等待移位的十进制数, m- 向左移的位数
     * @return int- 移位后的十进制数
     * @Description: 向左移位
     */
    public static int leftShift(int num, int m) {
        return num << m;
    }

    /**
     * @param num- 等待移位的十进制数, m- 向右移的位数
     * @return int- 移位后的十进制数
     * @Description: 向右移位
     */
    public static int locrightShift(int num, int m) {
        return num >>> m;
    }

    public static int mathrightShift(int num, int m) {
        return num >> m;
    }
}
