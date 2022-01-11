package cn.dunkwan.problems.problem92;

class Solution {
    // 迭代解法
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        ListNode pLeft = null, pRight = null, previous = null, last = null, p = head;
        int i = 1;
        while (i <= right + 1) {
            if (i == left - 1) {
                previous = p;
            }
            if (i == left) {
                pLeft = p;
            }
            if (i == right) {
                pRight = p;
            }
            if (i == right + 1) {
                last = p;
            }
            if (p != null) {
                p = p.next;
            }
            i++;
        }
        pRight.next = null;
        reverseList(pLeft);
        if (previous != null) {
            previous.next = pRight;
        }
        pLeft.next = last;
        return left == 1 ? pRight : head;
    }

    // 反转链表
    public void reverseList(ListNode start) {
        ListNode p = start.next, next = start;
        start.next = null;
        while (p != null) {
            ListNode tmp = p.next;
            p.next = next;
            next = p;
            p = tmp;
        }
        start = next;
        //ListNode result = start;
    }
}
