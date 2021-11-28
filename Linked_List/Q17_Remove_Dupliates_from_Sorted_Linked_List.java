import java.util.Scanner;
// i/p : 1->1->1->4->5->6->6->7->8->9->9->9->null
// o/p : 1->4->5->6->7->8->9->null
public class Q17_Remove_Dupliates_from_Sorted_Linked_List {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode removeDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        //create a dummy node now create a itr node and curr node
        //itr will point to dummy and curr will point to head
        //start while loop till curr != null
        //now again startt while loop for check duplicates while(curr != null && itr.val == curr.val)
        //then move curr ahead
        //afer loop end when itr.val != curr.val then assign itr.next to curr
        //move itr at itr.next
        //move curr to curr.next if curr != null
        ListNode dummy = new ListNode(-1);
        ListNode itr = dummy;
        ListNode curr = head.next;
        while(curr != null){
            while(curr != null && itr.val == curr.val){
                curr = curr.next;
            }
            itr.next = curr;
            itr = itr.next;
            if(curr != null) curr = curr.next;
        }
        return dummy.next;
    }

    // InFput_code===================================================

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode makeList(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = makeList(scn.nextInt());

        ListNode ans = removeDuplicates(head);
        printList(ans);
    }
}
