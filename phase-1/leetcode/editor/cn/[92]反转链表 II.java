//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [5], left = 1, right = 1
//输出：[5]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目为 n 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//
// 进阶： 你可以使用一趟扫描完成反转吗？ 
// Related Topics 链表 👍 1123 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        // base case
        if (left == 1) {
            return reverseN(head, right);
        }
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    ListNode successor = null;
    private ListNode reverseN(ListNode head, int n) {
        // base case
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
