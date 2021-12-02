import java.util.Scanner;

public class Q35_Copy_Linked_List_With_Random_Pointer {
    public static class ListNode {
        int val = 0;
        ListNode next = null;
        ListNode random = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    // this will copy same node in right side of curr val with same val
    public static void copyList(ListNode head) {
        ListNode curr = head;
        while(curr != null){
            ListNode forw = curr.next;
            ListNode node = new ListNode(curr.val);
            curr.next = node;
            node.next = forw;

            curr = forw;
        }
    }

    // it'll will point to that copy node with their random pointer
    public static void copyRandomPtr(ListNode head) {
        ListNode curr = head;
        while(curr != null){
            ListNode ran = curr.random;
            if(ran != null)
            curr.next.random = ran.next;

            curr = curr.next.next;
        }
    }

    // it'll extract copy node from prev node
    public static ListNode extract(ListNode head){
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy, curr = head;
        while(curr != null){
            prev.next = curr.next;
            curr.next = curr.next.next;

            prev = prev.next;
            curr = curr.next;
        }
        return dummy.next;
    }

    public static ListNode copyRandomList(ListNode head) {
        // firstly create copy list
        copyList(head);
        // assign all random pointer
        copyRandomPtr(head);
        // extract from prev nodes and return it
        return extract(head);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        ListNode[] arr = new ListNode[n];
        ListNode prev = null;

        for (int i = 0; i < n; i++) {
            arr[i] = new ListNode(0);
            if (prev != null)
                prev.next = arr[i];
            prev = arr[i];
        }

        for (int i = 0; i < n; i++) {
            int val = scn.nextInt();
            int idx = scn.nextInt();

            arr[i].val = val;
            if(idx != -1) arr[i].random = arr[idx];
        }
        scn.close();

        ListNode head = copyRandomList(arr[0]);
        while (head != null) {
            System.out.print("(" + head.val + ", " + (head.random != null ? head.random.val : -1) + ") ");
            head = head.next;
        }
    }
}
