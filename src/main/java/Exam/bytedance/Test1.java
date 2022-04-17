package Exam.bytedance;

import java.util.Scanner;

/**
 * 青蛙跳台阶
 */
public class Test1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(getCount(n));
    }

    // 动态规划
    public static int getCount(int n) {
        if (n != 1) {
            if (n != 2) {
                // 距离此楼梯前两步
                return getCount(n - 1) + getCount(n - 2);
            } else return 2;
        } else return 1;

    }

    // 计算连续跳两步有几种

}
