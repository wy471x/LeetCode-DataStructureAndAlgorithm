package cn.dunkwan.problems.problem92;

public class Problem92 {
    public static void main(String[] args) {
        ListNode one = new ListNode(3);
        ListNode two = new ListNode(5);
        one.next = two;
        Solution solution = new Solution();
        ListNode result = solution.reverseBetween(one, 1, 2);
        ListNode p = result;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
}
