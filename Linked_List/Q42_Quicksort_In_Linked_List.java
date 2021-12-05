import java.util.Scanner;


public class Q42_Quicksort_In_Linked_List{
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    // here we are segregating nodes of head over pivot
    // if any node is smaller than equal to pivot then store in smaller list
    // greater will store in large list
    public static ListNode[] segregateNode(ListNode head, int pivotIdx) {
        ListNode small = new ListNode(-1);
        ListNode large = new ListNode(-1);
        ListNode curr = head, sp = small, lp = large, pivot = head;
        // here firstly pivot assign to head
        // run loop till we get pivotidx as zero
        // at pivot 0 we get our actual pivot node
        while(pivotIdx-- > 0){
            pivot = pivot.next;
        }

        while(curr != null){
            if(curr != pivot){
                // connect smaller and larger node of curr if curr is not equal to pivot
                if(curr.val <= pivot.val){
                    sp.next = curr;
                    sp = sp.next;
                }
                else{
                    lp.next = curr;
                    lp = lp.next;
                }
            }
            curr = curr.next;
        }
        // after loop make all tail point to next
        // and return a ListNode array with head of smaller, pivot node and head of larger as element
        sp.next = null;
        pivot.next = null;
        lp.next = null;
        return new ListNode[]{small.next, pivot, large.next};
    }

    public static int length(ListNode head) {
        int len = 0;
        ListNode curr = head;
        while(curr != null){
            len++;
            curr = curr.next;
        }
        return len;
    }
    public static ListNode[] mergeseg(ListNode[] leftseg, ListNode pivot, ListNode[] rightseg) {
        ListNode head = null, tail = null;
        if(leftseg[0] != null && rightseg[0] != null){
            leftseg[1].next = pivot;
            pivot.next = rightseg[0];
            head = leftseg[0];
            tail = rightseg[1];
        }
        else if(leftseg[0] != null){
            leftseg[1].next = pivot;
            head = leftseg[0];
            tail = pivot;
        }
        else if(rightseg[0] != null){
            head = pivot;
            pivot.next = rightseg[0];
            tail = rightseg[1];
        }
        else{
            head = tail = pivot;
        }
        return new ListNode[]{head, tail};
    }
    public static ListNode[] quickSort_(ListNode head) {
        if(head == null || head.next == null){
            return new ListNode[]{head, head};
        }
        int len = length(head);
        int pivot = len / 2;

        ListNode[] segreagate = segregateNode(head, pivot);
        ListNode[] leftseg = quickSort_(segreagate[0]);
        ListNode[] rightseg = quickSort_(segreagate[2]);


        return mergeseg(leftseg, segreagate[1], rightseg);
    }

    public static ListNode quickSort(ListNode head) {
        return quickSort_(head)[0];
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

        ListNode head = quickSort(h1);
        printList(head);
    }
}