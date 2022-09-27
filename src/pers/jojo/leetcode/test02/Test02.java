package pers.jojo.leetcode.test02;

/**
 * @author jojo
 * @date 8-3
 */
public class Test02 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode node1 = new ListNode().createListNode();
        ListNode node2 = new ListNode().createListNode();
        node1.printInformation(solution.addTwoNumbers(node1, node2));
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            if (carry == 1) {
                cur.next = new ListNode(carry);
            }
        }
        return pre.next;
    }

    int getLength(ListNode node) {
        int length = 1;
        while (node.next != null) {
            length++;
            node = node.next;
        }
        return length;
    }

}