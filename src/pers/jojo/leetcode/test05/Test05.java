package pers.jojo.leetcode.test05;

/**
 * @author jojo
 * @date 2022/9/30 15:41
 */
public class Test05 {
    public static void main(String[] args) {
        String s = "bb";
//        Solution02 solution02 = new Solution02();
//        System.out.println(solution02.longestPalindrome(s));
        Solution03 solution03 = new Solution03();
        System.out.println(solution03.longestPalindrome(s));
    }
}


// 暴力法 会超时
class Solution01 {
    public String longestPalindrome(String s) {
        int length = s.length();
        int maxLen = 0;
        String res = s.substring(0, 1);
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (isPalindrome(s.substring(i, j + 1)) && (j - i + 1) > maxLen) {
                    maxLen = j - i + 1;
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}

// 中心扩散
class Solution02 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}

// 动态规划
class Solution03 {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) {
            return s;
        }
        int maxLen = 0;
        String res = s.substring(0, 1);
        boolean[][] dp = new boolean[n][n];
        // 初始化动态规划的数组
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        for (int col = 1; col < n; col++) {
            for (int row = 0; row <= col - 1; row++) {
                if (s.charAt(row) == s.charAt(col)) {
                    if ((col - row == 1) || dp[row + 1][col - 1]) {
                        dp[row][col] = true;
                    }
                }
                if (dp[row][col] && (col - row + 1) > maxLen) {
                    maxLen = col - row + 1;
                    res = s.substring(row, col + 1);
                }
            }
        }
        return res;
    }
}