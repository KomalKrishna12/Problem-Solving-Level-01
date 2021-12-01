import java.util.Scanner;

public class Q32_Multiply_Linked_List_No {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
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

    public static int linklistToNo(ListNode node) {
        int sum = 0;
        int power = 1;
        ListNode curr = node;
        while(curr != null){
            sum += curr.val * power;
            power *= 10;
            curr = curr.next;
        }
        return sum;
    }

    public static int multiply(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        int prod1 = linklistToNo(l1);
        System.out.println(prod1);
        int prod2 = linklistToNo(l2);
        System.out.println(prod2);
        return prod1*prod2;
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

        // display linked list
        printList(head1);
        printList(head2);

        int res = multiply(head1, head2);
        System.out.println(res);
        
    }
}
