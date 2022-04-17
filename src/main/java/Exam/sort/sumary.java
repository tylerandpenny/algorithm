package Exam.sort;

/**
 * 排序算法
 */


public class sumary {
    public static void main(String[] args) {

    }

    /**
     * 插入排序
     */
    public static void insertSort(int[] a) {
        int n = a.length;
        if (a == null || n == 0) {
            return;
        }
        for (int i = 1; i < n; i++) {
            if (a[i] < a[i - 1]) {
                // 当前元素需要插入
                int j = i;
                int temp = a[i];
                while (j > 0 && a[j] > temp) {
                    // 从后往前，比要插入的元素大的元素后移一位，直到找到比要插入元素小的第一个数，插入
                    a[j] = a[j - 1];
                    j--;
                }
                // 插入
                a[j] = temp;
            }
        }
    }
}
