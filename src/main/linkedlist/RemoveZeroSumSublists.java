package leetcode.linkedlist;

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

class ListNode {
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
}

public class RemoveZeroSumSublists {
    public ListNode removeZeroSumSublists(ListNode head) {
        
     /*   while(head != null && head.val == 0){
            head = head.next;
        } */
        ListNode start = head, prev = null;
        while (start != null) {
            ListNode end = start;
            boolean sumFound = false;
            int sum = 0;
            while (end != null) {
                sum += end.val;
                if (sum == 0) {
                    sumFound = true;
                    break;
                }
                end = end.next;
            }


            if (sumFound) {
                if (head == start) {
                    head = end.next;
                }
                start = end.next;
                if (prev != null)
                    prev.next = start;
            } else {
                prev = start;
                if (start != null)
                    start = start.next;
            }


        }
        return head;
    }
}