import java.util.Scanner;

public class Q31_Multiplication_Of_Linked_List {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode reverse(ListNode node) {
        ListNode prev = null, forw = null;
        ListNode curr = node;
        while(curr != null){
            forw = curr.next;
            curr.next = prev;

            prev = curr;
            curr = forw;
        }
        return prev;
    }

    public static ListNode multiplyLLwithDigit(ListNode head, int dig) {
        ListNode dummy = new ListNode(-1);
        ListNode ac = dummy;
        ListNode curr = head;
        int carry = 0;
        while(curr != null || carry != 0){
            int ans = carry + (curr != null ? curr.val : 0) * dig;
            int digit = ans % 10;
            carry = ans / 10;
            ac.next = new ListNode(digit);
            ac = ac.next;
            if(curr != null) curr = curr.next;
        }
        return dummy.next;
    }

    public static void addTwoLL(ListNode l1, ListNode ansItr) {
        ListNode c1 = l1;
        ListNode c2 = ansItr;
        int carry = 0;
        while(c1 != null || carry != 0){
            int sum = carry + (c1 != null ? c1.val : 0) + (c2.next != null ? c2.next.val : 0);
            int digit = sum % 10;
            carry = sum / 10;
            if(c2.next != null) c2.next.val = digit;
            else c2.next = new ListNode(digit);
            if(c1 != null) c1 = c1.next;
            c2 = c2.next;
        }
    }

    public static ListNode multiplyTwoLL(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode l2_itr = l2;
        ListNode dummy = new ListNode(-1);
        ListNode itr = dummy;
        while(l2_itr != null){
            ListNode prod = multiplyLLwithDigit(l1, l2_itr.val);
            l2_itr = l2_itr.next;

            addTwoLL(prod, itr);
            itr = itr.next;
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

        ListNode ans = multiplyTwoLL(head1, head2);
        printList(ans);
    }
}
