package Exam.dianxin;

import java.util.Scanner;

/**
 * 丑数
 */
public class T1 {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        int index = in.nextInt();
        System.out.println(GetUglyNumber_Solution(index));
    }

    public static int GetUglyNumber_Solution(int index) {
        // 异常
        if(index <= 0){
            return 0;
        }

        // 按照顺序存放所有丑数
        int[] dp = new int[index];
        dp[0] = 1;
        int nextUglyIndex = 1;

        // 存储乘以2、3、5 的下标
        int i2 = 0, i3 = 0, i5 = 0;

        // 保证数组排序，由已知丑数得新丑数
        while(nextUglyIndex < index){
            int min = Math.min(Math.min(dp[i2] * 2, dp[i3] * 3), dp[i5] * 5);
            dp[nextUglyIndex] = min;

            if(dp[i2] * 2 == min){
                i2++;
            }
            if(dp[i3] * 3 == min){
                i3++;
            }
            if(dp[i5] * 5 == min){
                i5++;
            }
            nextUglyIndex++;
        }
        return dp[index - 1];
    }


}
