import java.util.Scanner;

public class Q40_Segregate_Node_Of_Linked_List_Over_Last_Node {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    
    // this is the function to return the tail of list
    public static ListNode getTail(ListNode head){

        // if head is null then return head
        if(head == null) return head;

        // create a node tail initialize it with head
        ListNode tail = head;

        // if tail.next is not null then move tail to its next step
        while(tail.next != null){
            tail = tail.next;
        }
        // at end return tail node
        return tail;
    }

    public static ListNode segregateOnLastIndex(ListNode head) {
        if(head == null || head.next == null) return head;
        // tail is the last node of list
        ListNode tail = getTail(head);
        // smaller list will point to all nodes less then equal to tail
        ListNode s = new ListNode(-1);
        // larger node will point to all nodes greater than tail
        ListNode l = new ListNode(-1);
        // ps is pointer smaller and pl is pointer larger
        // both will move forward to create its next node
        ListNode ps = s, pl = l,curr = head;

        // curr is for traversing in actual list
        while(curr != null){
            // if curr.val is less then equal to tail.val then ps will point to that and move ps also
            // else pl will point to curr and pl will move forward
            // and curr will move forward in both cases
            if(curr.val <= tail.val){
                ps.next = curr;
                ps = ps.next;
            }
            else{
                pl.next = curr;
                pl = pl.next;
            }
            curr = curr.next;
        }
        // at end of ps connect ps with larger list whose head is larger.head
        // and for larger tail connect it with null otherwise it'll connect to its previous nodes
        ps.next = l.next;
        pl.next = null;
        return ps;
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
        h1 = segregateOnLastIndex(h1);
        printList(h1);
    }
}
