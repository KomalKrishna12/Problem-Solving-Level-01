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
        //firstly calculate the length using length function
        int len = length(head);
        //create curr listnode to point head
        //forw for storing curr.next for backhup and forward movement
        //orghead and orgtail is our list which is reversed
        ListNode curr = head;
        ListNode forw = null;
        ListNode orgHead = null;
        ListNode orgTail = null;
        //if len >= k then stor k in length and run inner loop till length > 0
        while(len >= k){
            int length = k;
            while(length-- > 0){
                //store curr.next in forw
                //now point curr.next to null so store curr in addFirst()
                //now set curr at forw
                forw = curr.next;
                curr.next = null;
                addFirstNode(curr);

                curr = forw;
            }
            //if orghead is null then temphead become orghead and temptail become orgtail
            //else orgtail.next = temphead and orgtail become temptail
            if(orgHead == null){
                orgHead = tempHead;
                orgTail = tempTail;
            }
            else{
                orgTail.next = tempHead;
                orgTail = tempTail;
            }
            //set temphead and temptail to null for next k group
            //subract k from len
            tempHead = null;
            tempTail = null;
            len = len - k;
        }
        //if less than k element present than connect orgtail to curr and return orghead
        orgTail.next = curr;
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
