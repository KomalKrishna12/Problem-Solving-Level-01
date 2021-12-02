import java.util.Scanner;

public class Q37_Cycle_Node_In_Linked_List {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode CycleNode(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast) break;
        }
        //if slow != fast that means there is no loop so list is linear
        if(slow != fast) return null;

        // if slow == fast then while loop breaks and come here
        // assihn head to slow
        // fast is inside loop
        // now both fast and slow move one step towards its next node and when they meet
        // that will be the cycle node of the loop
        slow = head;
        //fast = fast;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        // return slow or fast both are pointing to same node
        return slow;
    }

    public static ListNode takeInput() {
        int n = scn.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }
        int idx = scn.nextInt();
        if (idx >= 0) {
            ListNode curr = dummy.next;
            while (idx-- > 0) {
                curr = curr.next;
            }
            prev.next = curr;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = takeInput();
        ListNode ans = CycleNode(head);
        System.out.println(ans!=null?ans.val:-1);
    }
}
