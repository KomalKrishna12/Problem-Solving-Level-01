import java.util.Scanner;

public class Q22_Mid_Node_Of_Linked_List {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode midNode(ListNode head) {
        // if head == null or head.next is null(means only one node in list) then return head
        // create two ListNode fast and slow
        // slow will move one step while fast will move two step so fast will move at end at x step
        // and slow will be at x/2 that time slow is at our mid node
        // run loop till fast.next != null and fast.next.next != null the second
        // cond is for getting first mid node in even nodes
        if (head == null || head.next == null)
            return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        ListNode head = midNode(dummy.next);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
