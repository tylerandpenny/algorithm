package DataStructure;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 三数之和为0
 */
public class ThreeNums {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        if(nums[0] >= 0 || nums.length < 3){
            return res;
        }
        for (int i = 0; i < nums.length; i++) {
            
        }

        return res;
    }
}
