import java.util.Scanner;

public class Q39_Segregate_012_Node_In_Linked_List {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregate012(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode curr = head;
        ListNode zero = new ListNode(-1);
        ListNode one = new ListNode(-1);
        ListNode two = new ListNode(-1);
        ListNode pz = zero, po = one, pt = two;
        while(curr != null){
            if(curr.val == 0){
                pz.next = curr;
                pz = pz.next;
            }
            else if(curr.val == 1){
                po.next = curr;
                po = po.next;
            }
            else{
                pt.next = curr;
                pt = pt.next;
            }
            curr = curr.next;
        }
        po.next = two.next;
        pz.next = one.next;
        pt.next = null;
        return zero.next;
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode createList(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        int n = scn.nextInt();
        ListNode h1 = createList(n);
        h1 = segregate012(h1);
        printList(h1);
    }
}
