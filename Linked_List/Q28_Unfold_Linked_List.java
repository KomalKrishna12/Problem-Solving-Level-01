import java.util.*;
// i/p : 1->7->2->6->3->5->4->null
// o/p : 1->2->3->4->5->6->7->null
// in fold linked list we have given o/p as i/p to fold the list
// and here we want to unfold it again to its prev stage
public class Q28_Unfold_Linked_List {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    
    public static ListNode reverse(ListNode head){
        ListNode prev = null; // it'll become our new head for reverse list
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

    public static ListNode mid(ListNode node) {
        ListNode fast = node;
        ListNode slow = node;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void fold(ListNode head) {
        if(head == null || head.next == null) return;

        ListNode mid = mid(head);
        ListNode nhead = mid.next; // new head
        mid.next = null;           // break link

        nhead = reverse(nhead);

        ListNode c1 = head;
        ListNode c2 = nhead;
        ListNode f1 = null, f2 = null;
        while(c2 != null){
            f1 = c1.next;
            f2 = c2.next;

            c1.next = c2;
            c2.next = f1;

            c1 = f1;
            c2 = f2;
        }
    }

    // create two node first head(fh) and second head(sh)
    // fh point to head and sh point to head.next
    // ft is tail of fh and st is tail of sh 
    // f is for storing next of sh
    public static void unfold(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode fh = head, sh = head.next;
        ListNode ft = fh, st = sh;
        ListNode f = null;
        // st is the smallest list so in odd no of node st go aat end
        // but in even no of cases st go to null
        // so we put condtion for st only
        while(st != null && st.next != null){
            f = st.next; //backup
            
            ft.next = f;
            st.next = f.next;
            
            ft = ft.next;
            st = st.next;
        }
        // in even no of nodes ft is still pointing to next node 
        // so after loop point ft.next to null
        ft.next = null;

        // now reverse the sh
        sh = reverse(sh);

        // link both list
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
        //fold(head);
        unfold(head);
        printList(head);
    }
}
