package me.syrym.easy;

import me.syrym.ListNode;

import java.util.ArrayList;
import java.util.List;

public class MiddleOfTheLinkedList {
    public static ListNode middleNode(ListNode head) {
        List<ListNode> l = new ArrayList<>();
        int count = 0;
        while(head != null) {
            l.add(head);
            head = head.next;
            count++;
        }
        return l.get((int) Math.ceil(count / 2));
    }
}
