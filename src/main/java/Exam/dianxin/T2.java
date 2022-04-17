package Exam.dianxin;

import java.util.Scanner;

/**
 * 不相邻最大和
 * https://blog.csdn.net/mine_song/article/details/70196254
 */
public class T2 {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        String s = in.nextLine();
        String[] s1 = s.split(",");
        int n  = s1.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.valueOf(s1[i]);
        }
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        if (nums == null)
            return 0;
        int n = nums.length;
        if (n == 0)
            return 0;
        if (n == 1)
            return nums[0];
        nums[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++)
            nums[i] = Math.max(nums[i - 2]
                    + nums[i], nums[i - 1]);
        return nums[n - 1];
    }
}
