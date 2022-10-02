package pers.jojo.leetcode.test06;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jojo
 * @date 2022/9/30 17:19
 */
public class Test06 {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        Solution solution = new Solution();
        System.out.println(solution.convert(s, numRows));
    }
}


class Solution {
    public String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        int i = 0, flag = -1;
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            if (i == 0 || i == numRows - 1) {
                flag = -flag;
            }
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) {
            res.append(row);
        }
        return res.toString();
    }
}
