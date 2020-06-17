package BasicThinking;

public class Lesson9_BA {
    public static void main(String[] args) {
        long beginTime = System.currentTimeMillis();
//        String str1 = "mitcmu";
//        String str2 = "mtacnu";
        String str1 = "mitcmubdgcbfd";
        String str2 = "mtacnufghcbdg";
        char[] a = str1.toCharArray();
        char[] b = str2.toCharArray();
        int n = a.length;
        int m = b.length;
        int i = 1;
        int j = 1;
        int edist = 0;
        Lesson9_BA.lwstBT(a, b, n, m, i, j, edist);
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - beginTime) + "ms");
    }

    public static int minDist = Integer.MAX_VALUE; // 存储结果

    public static void lwstBT(char[] a, char[] b, int n, int m, int i, int j, int edist) {
        if (i == n || j == m) {
            if (i < n) edist += (n - i);
            if (j < m) edist += (m - j);
            if (edist < minDist) minDist = edist;
            System.out.println("最小编辑距离为：" +minDist);
            return;
        }
        if (a[i] == b[j]) {
            lwstBT(a, b, n, m, i + 1, j + 1, edist);
        }
        if (a[i] != b[j]) {
            lwstBT(a, b, n, m, i + 1, j, edist + 1);//删除a[i]或者b[j]前添加一个字符
            lwstBT(a, b, n, m, i, j + 1, edist + 1);//删除b[j]或者a[i]前添加一个字符
            lwstBT(a, b, n, m, i + 1, j + 1, edist + 1);//将a[i]和b[j]替换为相同字符
        }
    }
}
