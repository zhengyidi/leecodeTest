package test2;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode root = new ListNode(0);
        ListNode cur = root;
        int carry = 0;
        while (l1 != null || l2 != null || carry > 0) {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;

            // 当前值为 两个节点值以及进位的和
            int curVal = val1 + val2 + carry;
            if (curVal >= 10) {
                carry = curVal / 10; // 除以10 获取新的进位
                curVal = curVal - 10;
            } else {
                carry = 0;
            }

            cur.next = new ListNode(curVal);
            cur = cur.next;

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        return root.next;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.toNode(9);
        ListNode l4 = ListNode.toNode(8);
        System.out.println(l1);
        System.out.println(l4);
        System.out.println(addTwoNumbers(l1, l4));
    }

}
