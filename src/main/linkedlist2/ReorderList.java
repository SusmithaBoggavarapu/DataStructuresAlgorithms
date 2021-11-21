package leetcode.linkedlist2;
//https://leetcode.com/problems/reorder-list/


class ReorderList {
    public void reorderList(ListNode head) {
        ListNode start = head;
        while (start != null) {

            ListNode end = start, endPrev = null;
            while (end != null && end.next != null) {
                endPrev = end;
                end = end.next;
            }
            if (endPrev != null) {
                endPrev.next = null;
            }

            ListNode tmp = start.next;
            start.next = end;
            end.next = tmp;
            start = tmp;

        }
    }
}