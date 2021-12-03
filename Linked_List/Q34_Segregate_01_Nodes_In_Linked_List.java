import java.util.Scanner;
// i/p : 1->0->1->0->0->1->1->1->1->1->1->null
// o/p : 0->0->0->1->1->1->1->1->1->1->1->null
// we've to arrange list in order so that 0th node comes first then 1's
public class Q34_Segregate_01_Nodes_In_Linked_List {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregate01(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode curr = head;
        ListNode zero = new ListNode(-1);
        ListNode one = new ListNode(-1);
        ListNode pz = zero, po = one;
        while(curr != null){
            if(curr.val == 0){
                pz.next = curr;
                pz = pz.next;
            }
            else{
                po.next = curr;
                po = po.next;
            }
            curr = curr.next;
        }
        // now connect zero list tail to one list head
        // and also point one list tail to null becoz there is possiblity that one last node is 
        // pointing to any zero node
        pz.next = one.next;
        po.next = null;
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
        h1 = segregate01(h1);
        printList(h1);
    }
}
