import java.util.*;
public class Q28_Unfold_Linked_List {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    
    public static ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode forw = null;
        while(curr != null){
            forw = curr.next; // bachup
            curr.next = prev; // link
            prev = curr;      // move
            curr = forw;
        }
        return prev;
    }

    public static void unfold(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode fh = head, sh = head.next;
        ListNode ft = fh, st = sh;
        ListNode f = null;
        while(st != null && st.next != null){
            f = st.next; //backup
            
            ft.next = f;
            st.next = f.next;
            
            ft = ft.next;
            st = st.next;
        }
        ft.next = null;
        sh = reverse(sh);
        ft.next = sh;
    }

    static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
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

        ListNode head = dummy.next;
        unfold(head);
        printList(head);
    }
}
