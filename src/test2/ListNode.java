package test2;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    static ListNode toNode(int... x) {
        ListNode root = new ListNode(0);
        ListNode next = root;
        for (int i : x) {
            next.next = new ListNode(i);
            next = next.next;
        }
        return root.next;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode n = this;
        while (n != null) {
            sb.append(n.val).append(", ");
            n = n.next;
        }
        return sb.toString();
    }
}
