package Greedy;

import java.util.HashMap;

public class DiaoDu {

    public static void main(String[] args) {
        int[] test = {3, 2, 3};
        System.out.println(majorityElement(test));
    }


    public static int majorityElement(int[] nums) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.containsKey(nums[i]) ? map.get(nums[i]) + 1 : 1);
        }
        for (Integer ele : map.keySet()) {
            if (map.get(ele) > nums.length / 2) {
                res = ele;
            }
        }
        return res;
    }
}
