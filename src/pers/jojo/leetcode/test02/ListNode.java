package pers.jojo.leetcode.test02;

import java.util.Scanner;

/**
 * @author jojo
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    ListNode createListNode() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please input length: ");
        int length = scanner.nextInt();
        // initialization a new node
        System.out.print("Begin input node information: ");
        int val = scanner.nextInt();
        ListNode pervNode = new ListNode(val, null);
        ListNode headerNode = pervNode;
        for (int i = 1; i < length; i++) {
            val = scanner.nextInt();
            ListNode newNode = new ListNode(val, null);
            pervNode.next = newNode;
            pervNode = newNode;
        }
        return headerNode;
    }

    void printInformation(ListNode node) {
        ListNode header = node;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.print("\nlength: " + getLength(header));
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
