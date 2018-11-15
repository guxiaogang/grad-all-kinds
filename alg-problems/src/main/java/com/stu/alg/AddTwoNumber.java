package com.stu.alg;

/**
 * Created by gut on 10/12/18.
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class AddTwoNumber {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode l1CurNode = l1, l2CurNode = l2, curr = result;
        int carry = 0;
        while (l1CurNode != null || l2CurNode != null) {
            int x = (l1CurNode != null) ? l1CurNode.val : 0;
            int y = (l2CurNode != null) ? l2CurNode.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (l1CurNode != null) {
                l1CurNode = l1CurNode.next;
            }
            if (l2CurNode != null) {
                l2CurNode = l2CurNode.next;
            }
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(9);
        ListNode node2 = new ListNode(9);
        node1.next = node2;

        ListNode node4 = new ListNode(1);

        ListNode res = addTwoNumbers(node1, node4);
        ListNode node = res;
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
