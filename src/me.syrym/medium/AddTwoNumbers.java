package me.syrym.medium;

import me.syrym.ListNode;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        //l1.next = new ListNode(4);
        //l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        //l2.next.next = new ListNode(4);
        AddTwoNumbers a = new AddTwoNumbers();
        ListNode res = a.addTwoNumbers(l1, l2);
        while(res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode p = result;
        int remainder = 0;
        while (l1 != null && l2 != null) {
            int a = l1.val + l2.val + remainder;
            if (a > 9) {
                remainder = 1;
                a %= 10;
            } else {
                remainder = 0;
            }
            result.next = new ListNode(a);
            l1 = l1.next;
            l2 = l2.next;
            result = result.next;
        }
        while (l1 != null) {
            int a = l1.val + remainder;
            if (a > 9) {
                remainder = 1;
                a %= 10;
            } else {
                remainder = 0;
            }
            result.next = new ListNode(a);
            l1 = l1.next;
            result = result.next;
        }
        while (l2 != null) {
            int a = l2.val + remainder;
            if (a > 9) {
                remainder = 1;
                a %= 10;
            } else {
                remainder = 0;
            }
            result.next = new ListNode(a);
            l2 = l2.next;
            result = result.next;
        }
        if (remainder != 0) {
            result.next = new ListNode(remainder);
        }
        return p.next;
    }
}
