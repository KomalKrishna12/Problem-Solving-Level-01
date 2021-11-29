import java.util.Scanner;

public class Q9_Reverse_Linked_List {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode reverse(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        // create a prev node whihc points to null
        // create curr node which points to head it'll traverse the list
        // create forw for storing curr.next in backup because to reverse we point curr.next to prev
        // and for traverse we need to go on next of curr in linked list
        ListNode curr = head;
        ListNode prev = null;
        ListNode forw = null;
        while(curr != null){
            forw = curr.next;
            
            curr.next = prev;
            prev = curr;
            curr = forw;
        }
        // at end return prev that becomes our head
        return prev;
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
        scn.close();
        ListNode head = reverse(dummy.next);
        while (head != null) {
            System.out.print(head.val + " ");
head = head.next;
        }
    }
}
