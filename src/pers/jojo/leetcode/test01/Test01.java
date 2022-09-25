package pers.jojo.leetcode.test01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test01 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println("===Solution01===");
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.twoSum(nums, target)));
        System.out.println("===Solution02===");
        Solution solution02 = new Solution();
        System.out.println(Arrays.toString(solution02.twoSum(nums, target)));
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
}

class Solution02 {
    public int[] twoSum(int[] nums, int target) {
        // 用 hashmap 来了解位置
        Map<Integer, Integer> hashtable = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
