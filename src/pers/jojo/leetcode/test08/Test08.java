package pers.jojo.leetcode.test08;

/**
 * @author jojo
 * @date 2022/10/2 14:59
 */
public class Test08 {
    public static void main(String[] args) {
        String s = "4193 with words";
        Solution solution = new Solution();
        System.out.println(solution.myAtoi(s));
    }
}

class Solution {
    public int myAtoi(String s) {
        int i = 0;
        int sign = 1;
        int n = s.length();
        int res = 0;
        for (; i < n && s.charAt(i) == ' '; i++) {
        }
        if (i >= n) {
            return 0;
        }
        switch (s.charAt(i)) {
            case '+':
                i++;
            case '-':
                sign = -1;
                i++;
        }
        for (; i < n; i++) {
            int tmpNumber = s.charAt(i) - '0';
            if (tmpNumber < 0 || tmpNumber > 9) {
                break;
            }
            if ((res > 214748364 && sign == 1) || (res == 214748364 && tmpNumber > 7 && sign == 1)) {
                return Integer.MAX_VALUE;
            }
            if ((res > 214748364 && sign == -1) || (res == 214748364 && tmpNumber > 8 && sign == -1)) {
                return Integer.MIN_VALUE;
            }
            res = res * 10 + tmpNumber;
        }
        return res * sign;
    }
}
