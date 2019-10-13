package me.syrym.medium;

import me.syrym.ListNode;

import java.util.ArrayList;
import java.util.List;

public class NextGreaterNodeInLinkedList {
    /**
     * Can be solved using stack in O(n)
     */
    public int[] nextLargerNodes(ListNode head) {
        if (head == null) {
            return new int[]{};
        }
        if (head.next == null) {
            return new int[]{0};
        }
        ListNode pointer;
        List<Integer> l = new ArrayList<>();
        while (head != null) {
            int s = l.size();
            pointer = head;
            int v = head.val;
            while (pointer.next != null) {
                if (v < pointer.next.val) {
                    l.add(pointer.next.val);
                    break;
                } else {
                    pointer = pointer.next;
                }
            }
            if (l.size() == s) {
                l.add(0);
            }
            head = head.next;
        }
        return l.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
