package pers.jojo.leetcode.test03;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jojo
 * @date 2022/9/27 21:45
 */
public class Test03 {
    public static void main(String[] args) {
        String s = "pwwkew";
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring(s));
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int rk = -1, ans = 1;
        Set<Character> occ = new HashSet<Character>();
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }
}
