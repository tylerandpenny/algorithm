package Exam.meituan;

import java.util.Scanner;

public class T1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] nums = new int[4];
        for (int i = 0; i < 4; i++) {
            nums[i] = in.nextInt();
        }
        int[] prices = new int[3];
        int max = 0;
        int maxP = 0;
        for (int i = 0; i < 3; i++) {
            prices[i] = in.nextInt();
            if (prices[i] > max){
                max = prices[i];
                maxP = i;
            }
        }
        int min = Math.min(Math.min(prices[0],prices[1]),prices[2]);
        int minP = 0;
        for (int i = 0; i < 3; i++) {
            if (prices[i] == min){
                minP = i;
            }
        }
        int second = 0;
        int secondP = 0;
        for (int i = 0; i < 3; i++) {
            if (i !=maxP && i != minP){
                secondP = i;
                second = prices[i];
            }
        }
        // 4类型
        int shirt = nums[3];
        int sale = 0;
        if (shirt > nums[maxP]){
            // 先卖最贵的
            sale = nums[maxP] * max;
            shirt = shirt - nums[maxP];
            if (shirt > nums[secondP]){
                // 卖第二贵的，能卖完
                sale += nums[secondP] * second;
                shirt -= nums[secondP];
                if (shirt > nums[minP]){
                    // 最后卖第三贵的,能卖完
                    sale += nums[minP] * min;
                    shirt -= nums[minP];
                }else{
                    // 不够卖完第三贵
                    sale += shirt * min;
                }
            }else {
                // 不够卖完第二贵的
                sale += shirt * second;
            }
        }else {
            // 不能卖完最贵的
            sale += shirt * max;
        }
        System.out.println(sale);
    }
}
