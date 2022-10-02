package pers.jojo.leetcode.test07;

/**
 * @author jojo
 * @date 2022/9/30 18:21
 */
public class Test07 {
    public static void main(String[] args) {
        int x = 123;
        // 2147483647
        System.out.println(Integer.MAX_VALUE);
        // -2147483648
        System.out.println(Integer.MIN_VALUE);
        Solution solution = new Solution();
        System.out.println(solution.reverse(x));
    }
}

class Solution {
    public int reverse(int x) {
        int tmp;
        int res = 0;
        while (x != 0) {
            // 取最后一位
            tmp = x % 10;
            // 2147483647
            if (res > 214748364 || (res == 214748364 && tmp > 7)) {
                return 0;
            }
            if (res < -214748364 || (res == -214748364 && tmp < -8)) {
                return 0;
            }
            res = res * 10 + tmp;
            x = x / 10;
        }
        return res;
    }
}
