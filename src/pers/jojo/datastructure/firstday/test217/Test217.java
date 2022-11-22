package pers.jojo.datastructure.firstday.test217;

import java.util.Arrays;

/**
 * @author jojo
 * @date 2022/11/22 20:13
 */
public class Test217 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(new Solution().containsDuplicate(nums));
    }
}


class Solution {
    /**
     * 判断这个数组内有没有重复的元素
     *
     * @param nums 数组
     * @return 重复是True，不重复是False
     */
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}