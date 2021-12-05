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

    // this function will calculate and return the length of head
    // which we use in finding the pivot index
    public static int length(ListNode head) {
        int len = 0;
        ListNode curr = head;
        while(curr != null){
            len++;
            curr = curr.next;
        }
        return len;
    }

    // now this function will merge leftsegment pivot and rightsegment
    // if head is null or there is only one element
    // then that element will become our head as well as tail
    // this will return an array ListNode[] which contains head and tail
    // left seg 1 2 3    right seg  6 7 8
    // pivot 5
    // after merge it'll look like 1 2 3 5 6 7 8
    // and it'll return 1 as head and 8 as tail
    public static ListNode[] mergeseg(ListNode[] leftseg, ListNode pivot, ListNode[] rightseg) {
        ListNode head = null, tail = null;

        // if leftseg is not null then leftseg[0] will be the head and leftseg[1] will be the tail
        // same rightseg[0] head and rightseg[1] tail
        // now connect tail of left seg(leftseg[1]) with pivot
        // pivot with head of right seg(rightseg[0])
        // our head become rightseg[0] and tail leftseg[1]
        if(leftseg[0] != null && rightseg[0] != null){
            leftseg[1].next = pivot;
            pivot.next = rightseg[0];
            head = leftseg[0];
            tail = rightseg[1];
        }
        else if(leftseg[0] != null){
            // leftseg is not null but right seg is null
            // so connect tail of leftseg(leftseg[1]) with pivot
            // head will be leftseg[0] and pivot will be our tail
            leftseg[1].next = pivot;
            head = leftseg[0];
            tail = pivot;
        }
        else if(rightseg[0] != null){
            // if leftseg is null but right seg is not null so
            // pivot become head and pivot wil connet to head of rightseg (righseg[0])
            // so tail will be righseg[1]
            head = pivot;
            pivot.next = rightseg[0];
            tail = rightseg[1];
        }
        else{
            // if both leftseg and rightseg is null then pivot will be our head and tail
            head = tail = pivot;
        }
        // now return head and tail as an array element
        return new ListNode[]{head, tail};
    }

    // this is the function which return head and tail after calculating
    // pivot, leftseg, rightseg and after merging all three
    public static ListNode[] quickSort_(ListNode head) {
        // if head is null or only head is present in list then that head will 
        // be our head as well as tail
        if(head == null || head.next == null){
            return new ListNode[]{head, head};
        }
        // calculate len using length(head) function
        int len = length(head);
        // pivot will be the mid of head
        int pivot = len / 2;

        // now call segregate(head,pivot) function for mid elemnet as pivot
        // it will return a ListNode[] which contain three elements
        // ListNode[0] = head of small list
        // ListNode[1] = pivot node
        // ListNode[2] = head of large list
        ListNode[] segreagate = segregateNode(head, pivot);
        // now we want head as well as tell so we use recursion and call itself for small
        // and large head and tail
        ListNode[] leftseg = quickSort_(segreagate[0]);
        ListNode[] rightseg = quickSort_(segreagate[2]);


        return mergeseg(leftseg, segreagate[1], rightseg);
    }

    public static ListNode quickSort(ListNode head) {
        // but we want to return only head so here we pass as index 0
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