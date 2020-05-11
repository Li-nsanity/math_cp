package Leetcode.Q203;

public class Solution3 {
    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
//        ListNode res = removeElements(head.next, val);
//        if (head.val == val) {
//            return res;
//        } else {
//            head.next = res;
//            return head;
//        }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        int[] num = {1, 2, 6, 3, 4, 6, 5, 6};
        ListNode head = new ListNode(num);
        System.out.println(head);
        int val = 6;
        head = removeElements(head, val);
        System.out.println(head);
    }
}
