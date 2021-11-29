import java.util.Scanner;
//this is same as pallindrome 
//in pallindrome we check c1 and c2 val
//but here we are connect c1 and c2 using c1.next = c2 and c2.next = f1
public class Q27_Fold_Linked_List {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    
    public static ListNode mid(ListNode head){
        ListNode fast = head, slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    public static ListNode rev(ListNode head){
        ListNode prev = null, curr = head, forw = null;
        while(curr!=null){
            forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
        }
        return prev;
    }

    public static void fold(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode mid = mid(head);
        ListNode nhead = mid.next;
        mid.next = null;
        
        nhead = rev(nhead);
        ListNode c1 = head, c2 = nhead, f1 = null, f2 = null;
        while(c2 != null){
            f1 = c1.next;
            f2 = c2.next;
            
            c1.next = c2;
            c2.next = f1;
            
            c1 = f1;
            c2 = f2;
        }
        
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
        fold(head);
        printList(head);
    }
}
