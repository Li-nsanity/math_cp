package BasicThinking;

import java.util.Arrays;

public class Lesson6_1 {
    public static void main(String[] args) {
        int[] to_sort = {67, 3434, 3356, 67, 12334, 878667, 387};
        int[] sorted = Lesson6_1.merge_sort(to_sort);

        for (int i = 0; i < sorted.length; i++) {
            System.out.println(sorted[i]);
        }
    }

    public static int[] merge_sort(int[] to_sort) {
        /**
         * @Description: 使用函数的递归（嵌套）调用，实现归并排序（从小到大）
         * @param to_sort- 等待排序的数组
         * @return int[]- 排序后的数组
         */
        if (to_sort.length == 0) return new int[0];
        // 如果分解到只剩一个数，返回该数
        if (to_sort.length == 1) return to_sort;
        // 将数组分解成左右两半
        int mid = to_sort.length / 2;
        int[] left = Arrays.copyOfRange(to_sort, 0, mid);
        int[] right = Arrays.copyOfRange(to_sort, mid, to_sort.length);
        // 嵌套调用，对两半分别进行排序
        left = merge_sort(left);
        right = merge_sort(right);
        // 合并排序后的两半
        int[] merged = merge(left, right);
        return merged;
    }

    public static int[] merge(int[] a, int[] b) {
        /**
         * @Description: 合并两个已经排序完毕的数组（从小到大）
         * @param a- 第一个数组，b- 第二个数组
         * @return int[]- 合并后的数组
         */
        if (a == null) return new int[0];
        if (b == null) return new int[0];
        int[] merge_out = new int[a.length + b.length];
        int ai = 0, bi = 0, mi = 0;
        while (ai < a.length && bi < b.length) {
            if (a[ai] < b[bi]) {
                merge_out[mi] = a[ai];
                ai++;
            } else {
                merge_out[mi] = b[bi];
                bi++;
            }
            mi++;
        }
        if (ai < a.length) {
            for (int i = ai; i < a.length; i++) {
                merge_out[mi] = a[ai];
                ai++;
                mi++;
            }
        } else if (bi < b.length) {
            for (int i = bi; i < b.length; i++) {
                merge_out[mi] = b[bi];
                bi++;
                mi++;
            }
        }
        return merge_out;
    }
}
