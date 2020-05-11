package Leetcode.Q203;

public class Solution2 {
    public static ListNode removeElements(ListNode head, int val) {

        ListNode dummyhead = new ListNode(-1);
        dummyhead.next = head;
        ListNode prev = dummyhead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return dummyhead.next;
    }

    public static void main(String[] args) {
        int[] num = {1, 2, 6, 3, 4, 6, 5, 6};
        ListNode head = new ListNode(num);
        System.out.println(head);
        int val = 6;
        head = removeElements(head,val);
        System.out.println(head);
    }
}
