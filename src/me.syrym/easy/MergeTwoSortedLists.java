package me.syrym.easy;

import me.syrym.ListNode;

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        boolean isL1Larger = l1.val > l2.val;
        ListNode main = isL1Larger ? l1 : l2, aux = isL1Larger ? l2 : l1;

        while (main != null) {
            while (main.val >= aux.val || main.next.val >= aux.val) {
                ListNode p = main.next;
                main.next = new ListNode(aux.val);
                main.next.next = p;
                aux = aux.next;
            }
            main = main.next;
        }

        return main;
    }
}
