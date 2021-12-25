import java.util.Scanner;


public class Quick_sort_of_linked_list{
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    
    public static ListNode quickSort(ListNode head) {
        return quick_sort(head)[0];
    }

    public static ListNode[] quick_sort(ListNode node) {
        if(node == null || node.next == null){
            return new ListNode[]{node, node};
        }
        int len = length(node);
        int pivotidx = len/2;
        ListNode[] segregated = segregate(node, pivotidx);
        ListNode[] leftseg = quick_sort(segregated[0]);
        ListNode[] rightseg = quick_sort(segregated[2]);
        return merge(leftseg, segregated[1], rightseg);
    }
    public static ListNode[] merge(ListNode[] left, ListNode pivot, ListNode[] right) {
        ListNode head = null, tail = null;
        if(left[0] != null && right[0] != null){
            head = left[0];
            left[1].next = pivot;
            pivot.next = right[0];
            tail = right[1];
        }
        else if(left[0] != null){
            head = left[0];
            left[1].next = pivot;
            tail = pivot;
        }
        else if(right[0] != null){
            head = pivot;
            pivot.next = right[0];
            tail = right[1];
        }
        else{
            head = tail = pivot;
        }
        return new ListNode[]{head, tail};
    }

    public static int length(ListNode node){
        if(node == null) return 0;
        if(node.next == null) return 1;
        int len = 0;
        ListNode curr = node;
        while(curr != null){
            len++;
            curr = curr.next;
        }
        return len;
    }

    public static ListNode[] segregate(ListNode node, int pivotIdx){
        ListNode small = new ListNode(-1);
        ListNode large = new ListNode(-1);
        ListNode sp = small, lp = large, curr = node, pivot = node;
        while(pivotIdx-- > 0){
            pivot = pivot.next;
        }
        while(curr != null){
            if (curr != pivot) {
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
        sp.next = lp.next = pivot.next = null;
        return new ListNode[]{small.next, pivot, large.next};
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