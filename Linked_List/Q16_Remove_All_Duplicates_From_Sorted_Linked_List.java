import java.util.Scanner;
// i/p : 1->1->1->4->5->6->6->7->8->9->9->9->null
// o/p : 4->5->7->8->null
public class Q16_Remove_All_Duplicates_From_Sorted_Linked_List {
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
        //create a dummy node with val -1 and point itr to dummy
        //create curr point to head.next
        //now assume itr.next = head
        //start the loop
        //create a boolean var islooptrue initialize it with false
        //if curr.val == itr.next.val that means here is some duplicate values
        //so set true in boolean varaible and point curr to curr.next now again check
        //till itr.next.val != curr.next
        //if condition false
        //then check boolena variable if it is true then point itr.next to curr and if false 
        //then set itr = itr.next
        //again if curr != null then curr = curr.next
        ListNode dummy= new ListNode(-1);
        ListNode itr = dummy;
        ListNode curr = head.next;
        itr.next = head;
        while(curr != null){
            boolean islooptrue = false;
            while(curr != null && itr.next.val == curr.val){
                islooptrue = true;
                curr = curr.next;
            }
            if(islooptrue){
                itr.next = curr;
            }
            else{
                itr = itr.next;
            }
            if(curr != null){
                curr = curr.next;
            }
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
