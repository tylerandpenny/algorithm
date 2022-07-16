package Greedy;

/**
 * https://leetcode.cn/problems/container-with-most-water/
 *
 * 思路：
 *  设最大值max = (right - left) * min(height[left], height[right])
 *  贪心策略：每次都去增高相对矮的边
 *
 *
 */

public class MaxAreaSolution {
    public static void main(String[] args) {
        int[] height = {1,1};
        System.out.println(maxArea(height));
    }


    public static int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0;
        int len = height.length;
        int right = len - 1;
        int max = (right - left) * Math.min(height[left], height[right]);
        while (left < right && left < len - 2 ){
            // 移动指针的贪心策略：每次都去增高相对矮的边
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
            int cur = (right - left) * Math.min(height[left], height[right]);
            if (cur >= max) {
                max = cur;
            }
        }
        return max;
    }
}
