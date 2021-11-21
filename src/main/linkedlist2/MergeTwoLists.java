package leetcode.linkedlist2;

class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode i1, ListNode i2) {
        ListNode head = null, it = null;
        while (i1 != null && i2 != null) {
            System.out.println("i1 val: " + i1.val + " i2 val: " + i2.val);
            if (i1.val <= i2.val) {
                if (it == null) {
                    it = i1;
                    head = i1;
                } else {
                    it.next = i1;
                    it = it.next;

                }
                i1 = i1.next;
            } else {

                if (it == null) {
                    it = i2;
                    head = i2;
                } else {
                    it.next = i2;
                    it = it.next;
                }
                i2 = i2.next;
            }


        }

        ListNode tmp = null;
        if (i1 != null) {
            tmp = i1;
        }
        if (i2 != null) {
            tmp = i2;
        }

        while (tmp != null) {
            System.out.println("tmp val: " + tmp.val);
            if (it == null) {
                it = tmp;
                head = tmp;
            } else {
                it.next = tmp;
                it = it.next;

            }
            tmp = tmp.next;
        }

        return head;

    }
}