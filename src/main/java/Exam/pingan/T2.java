package Exam.pingan;

import java.util.Scanner;


// N皇后问题
public class T2 {

    static int n;     //用来存储皇后的个数
    static int sum = 0; //用来记录可行解的个数
    static int[] a;    // 用来存储列数

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        a = new int[n + 1]; //创建一个列数加一的数组,第一个数弃用,方便取得列数从1开始便于比较和增强可读性。
        int t;
        t = queen(1);
        if (n == 0) //如果n=0，则可行解个数为0，这种情况一定不要忽略
            t = 0;
        System.out.println(t);
    }

    public static boolean place(int k) {
        int i;
        for (i = 1; i < k; i++)
            if (Math.abs(k - i) == Math.abs(a[k] - a[i]) || a[k] == a[i])    //在对角线或者在同一列。皇后的个数在递增行数也跟着递增。
                return false;
        return true;
    }


    public static int queen(int t) {
        if (t > n && n > 0) //当放置的皇后超过n时，可行解个数加1，此时n必须大于0
            sum++;
        else
            for (int i = 1; i <= n; i++) {
                a[t] = i; //标明第t个皇后放在第i列
                if (place(t)) //如果可以放在某一位置，则继续放下一皇后
                    queen(t + 1);
            }
        return sum;
    }


}
