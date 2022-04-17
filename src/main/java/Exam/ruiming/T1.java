package Exam.ruiming;

import java.util.Scanner;

public class T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s = s.replace("[","");
        s = s.replace("]","");
        String[] input = s.split(",");
        int[] nums = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            nums[i] = Integer.valueOf(input[i]);
        }

        int[] res = bubbleSortSolution(nums);
        System.out.print("[");
        for (int i = 0; i < res.length - 1; i++) {
            System.out.print(res[i] + ",");
        }
        System.out.println(res[res.length - 1 ] + "]");
    }

    public static int[] bubbleSortSolution(int[] nums) {
        // 异常
        if (nums == null || nums.length < 0) {
            return nums;
        }

        int temp = 0;
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = 0; j < nums.length-1-i; j++) {
                // 内循环，比较交换，较大的数放在后面
                if (nums[j] > nums[j + 1]  ) {
                    temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] =temp;
                }
            }
        }
        return nums;
    }
}
