import java.util.Scanner;

public class Q26_Pallindrome_Linked_List {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    
    public static ListNode mid(ListNode node){
        if(node == null || node.next == null) return node;
        ListNode slow = node, fast = node;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    public static ListNode reverse(ListNode node){
        if(node == null || node.next == null) return node;
        ListNode prev = null, curr = node, forw = null;
        while(curr != null){
            forw = curr.next; //backup
            curr.next = prev; //link
            prev = curr;
            curr = forw;
        }
        return prev;
    }

    public static boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        boolean res = true;
        
        ListNode mid = mid(head);
        ListNode nhead = mid.next;
        mid.next = null;
        
        nhead = reverse(nhead);
        ListNode c1 = head;
        ListNode c2 = nhead;
        while(c2 != null){
            if(c1.val != c2.val){
                res = false;
                break;
            }
            c1 = c1.next;
            c2 = c2.next;
        }
        nhead = reverse(nhead);
        mid.next = nhead;
        return res;
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
        System.out.println(isPalindrome(dummy.next));
    }
}
