package DataStructure;

/**
 * 颜色分类
 */

public class CplorSort {
    public static void main(String[] args) {

    }

    public static void sortColors(int[] nums) {
//        //插入排序
//        for (int i = 1; i < nums.length; i++) {
//            // 将比nums[i]大的数放到其之后
//            for (int j = i; j > 0 && nums[j] < nums[j - 1]; j--) {
//                // 只要前面的比当前位置大，就交换两者
//                swap(nums, j, j-1);
//            }
//        }

        // 双指针
        // 双指针
        int n = nums.length;
        int p0 = 0, p1 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                swap(nums, i, p0);
                if (p0 < p1) {
                    swap(nums, i, p1);
                }
                ++p0;
                ++p1;
            } else if (nums[i] == 1) {
                swap(nums, i, p1);
                ++p1;
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

}
