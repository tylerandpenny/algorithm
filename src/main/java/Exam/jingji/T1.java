package Exam.jingji;

import java.util.Scanner;

public class T1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
    }

    // 寻找数组峰值
    public static int findPeakElement(int[] nums) {
        if (nums.length == 1){
            return 0;
        }
        for (int i = nums.length - 1; i > 0 ; i++) {
            if (nums[i] > nums[i - 1])
                return i;
        }
        return 0;
    }

    

}
