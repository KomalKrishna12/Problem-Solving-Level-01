import java.util.Scanner;

public class Q23_Reverse_Node_In_Linked_List_In_K_Group_Order {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static int length(ListNode head) {
        ListNode node = head;
        int len = 0;
        while(node != null){
            node = node.next;
            len++;
        }
        return len;
    }

    static ListNode tempHead = null;
    static ListNode tempTail = null;

    public static void addFirstNode(ListNode node) {
        if(tempHead == null){
            tempHead = node;
            tempTail = node;
        }
        else{
            node.next = tempHead;
            tempHead = node;
        }
    }

    public static ListNode reverseInKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;
        int len = length(head);
        ListNode curr = head;
        ListNode forw = null;
        ListNode orgHead = null;
        ListNode orgTail = null;
        while(len >= k){
            int length = k;
            while(length-- > 0){
                forw = curr.next;
                curr.next = null;
                addFirstNode(curr);

                curr = forw;
            }
            if(orgHead == null){
                orgHead = tempHead;
                orgTail = tempTail;
            }
            else{
                orgTail.next = tempHead;
                orgTail = tempTail;
            }
            tempHead = null;
            tempTail = null;
            len = len - k;
        }
        return orgHead;
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

        int k = scn.nextInt();
        h1 = reverseInKGroup(h1, k);
        printList(h1);
    }
}
