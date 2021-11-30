import java.util.*;
public class Q30_Add_Two_Linked_List {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    
    public static ListNode reverse(ListNode node){
        ListNode prev = null;
        ListNode curr = node;
        ListNode forw = null;
        while(curr != null){
            forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
        }
        return prev;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // if any one of the node is null that means the other will be the summation
        if(l1 == null || l2 == null){
            return l1 != null ? l1 : l2;
        }
        // we want to add digits from end but it becomes complex to go to end and add and come back
        // one digit
        // so we reverse both the list and add them and reverse them back
        // reverse of l1 stores in c1
        // reverse of l2 stores in c2
        // create a dummy node which point to -1 currently and itr will move till end
        // dummy will store addition result
        // create a int variable carry and initialize it with 0
        // now loop will run if c1 != null or c2 != null or carry != 0
        // create a int var sum it will add carry + (if c1 != null then c1.val else 0) +
        // (if c2 != null then c2.val else 0)
        // now we store digit so
        // create a last digit int variable which will be sum % 10
        // carry become sum / 10
        // itr will point to the node which contain last digit as val so we create a node and
        // assign it as itr.next
        // now itr = itr.next 
        // if c1 != null then c1 = c1.next
        // if c2 != null then c2 = c2.next
        ListNode c1 = reverse(l1);
        ListNode c2 = reverse(l2);
        ListNode dummy = new ListNode(-1);
        ListNode itr = dummy;
        int carry = 0;
        while(c1 != null || c2 != null || carry != 0){
            int sum = carry + (c1 != null ? c1.val : 0) + (c2 != null ? c2.val : 0);

            int lastdigit = sum % 10;
            carry = sum / 10;

            itr.next = new ListNode(lastdigit);
            itr = itr.next;
            if(c1 != null) c1 = c1.next;
            if(c2 != null) c2 = c2.next;
        }
        return reverse(dummy.next);
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
        ListNode head1 = makeList(scn.nextInt());
        ListNode head2 = makeList(scn.nextInt());

        ListNode ans = addTwoNumbers(head1, head2);
        printList(ans);
    }
}
