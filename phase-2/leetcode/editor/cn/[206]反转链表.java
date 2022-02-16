//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
// 
// 
// Related Topics 递归 链表 👍 2276 👎 0


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
//    public ListNode reverseList(ListNode head) {
//        // 头插法进行链表反转
//        ListNode newHead = new ListNode();
//        ListNode p = head, next = newHead;
//        while (p != null) {
//            ListNode tmp = p.next;
//            p.next = newHead.next;
//            newHead.next = p;
//            p = tmp;
//        }
//        return newHead.next;
//    }
    // 递归解法
    public ListNode reverseList(ListNode head) {
        // 特殊情形
        if (head == null || head.next == null) {
            return head;
        }
        return reverse(head);

    }

    private ListNode reverse(ListNode head) {
        // 终止条件
        if (head == null) {
            return null;
        }
        // 新的头结点
        ListNode node = reverseList(head.next);
        // 遍历到尾结点拼接头结点
        ListNode p = node;
        while (p.next != null) {
            p = p.next;
        }
        p.next = head;
        head.next = null;
        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
