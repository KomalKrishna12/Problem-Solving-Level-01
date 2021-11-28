import java.util.Scanner;
// i/o : 1->7->2->6->3->5->4->null
// o/p : 2->6->4->1->7->3->5->null
//here we want to set even nodes before then odd in same order 
public class Q19_Segregate_Even_Odd_Node_Linked_List {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregateEvenOdd(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummyEven = new ListNode(-1);
        ListNode dummyOdd = new ListNode(-1);
        ListNode eTail = dummyEven, oTail = dummyOdd, curr = head;
        while(curr != null){
            int value = curr.val;
            if(value % 2 == 0){
                eTail.next = curr;
                eTail = eTail.next;
            }
            else{
                oTail.next = curr;
                oTail = oTail.next;
            }
            curr = curr.next;
        }
        eTail.next = dummyOdd.next;
        oTail.next = null;
        return dummyEven.next;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        ListNode head = segregateEvenOdd(dummy.next);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        scn.close();
    }
}
