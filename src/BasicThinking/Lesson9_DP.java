package BasicThinking;


public class Lesson9_DP {
    public static void main(String[] args) {
//        String str1 = "mitcmu";
//        String str2 = "mtacnu";
        String str1 = "mitcmubdgcbfd";
        String str2 = "mtacnufghcbdg";
        long beginTime = System.currentTimeMillis();
        char[] a = str1.toCharArray();
        char[] b = str2.toCharArray();
        int n = a.length;
        int m = b.length;
        int minDist = lwstDP(a, n, b, m);
        long endTime = System.currentTimeMillis();
        System.out.println("最小编辑距离为：" + minDist);
        System.out.println("程序运行时间：" + (endTime - beginTime) + "ms");

    }

    public static int lwstDP(char[] a, int n, char[] b, int m) {
        //设置一个二维数组存储最小编辑距离
        int[][] minDist = new int[n][m];
        //初始化第0行:a[0..0]与b[0..j]的编辑距离
        for (int j = 0; j < m; j++) {
            if (a[0] == b[j]) {
                minDist[0][j] = j;
            } else if (j != 0) {
                minDist[0][j] = minDist[0][j - 1] + 1;
            } else {
                minDist[0][j] = 1;
            }
        }
        // 初始化第0列:a[0..i]与b[0..0]的编辑距离
        for (int i = 0; i < n; i++) {
            if (a[i] == b[0]) {
                minDist[i][0] = i;
            } else if (i != 0) {
                minDist[i][0] = minDist[i - 1][0] + 1;
            } else {
                minDist[i][0] = 1;
            }
        }
        //状态转移方程式
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (a[i] == b[j]) {
                    int min = Math.min(minDist[i - 1][j] + 1, minDist[i][j - 1] + 1);
                    minDist[i][j] = Math.min(min, minDist[i - 1][j - 1]);
                } else {
                    int min = Math.min(minDist[i - 1][j] + 1, minDist[i][j - 1] + 1);
                    minDist[i][j] = Math.min(min, minDist[i - 1][j - 1] + 1);
                }
            }
        }
        return minDist[n - 1][m - 1];
    }
}
