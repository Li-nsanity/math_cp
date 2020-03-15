package BasicThinking;

public class Lesson3_2 {
    public static void main(String[] args) {

        int number = 10;
        double squareRoot = Lesson3_2.getSqureRoot(number, 0.000001, 10000);
        if (squareRoot == -1.0) {
            System.out.println(" 请输入大于 1 的整数 ");
        } else if (squareRoot == -2.0) {
            System.out.println(" 未能找到解 ");
        } else {
            System.out.println(String.format("%d 的平方根是 %f", number, squareRoot));
        }

    }

    public static double getSqureRoot(int n, double deltaThreshold, int maxTry) {
        if (n <= 1) {
            return -1.0;
        }
        double min = 1.0, max = (double) n;
        for (int i = 0; i < maxTry; i++) {
            double middle = (min + max) / 2;
            double square = middle * middle;
            double delta = Math.abs((square / n) - 1);
            if (delta <= deltaThreshold) {
                return middle;
            } else {
                if (square > n) {
                    max = middle;
                } else {
                    min = middle;
                }
            }
        }

        return -2.0;
    }
}
