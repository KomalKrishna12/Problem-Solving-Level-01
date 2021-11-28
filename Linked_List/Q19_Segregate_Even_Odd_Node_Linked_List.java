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

    public static int size(ListNode hNode) {
        int c = 0;
        ListNode temp = hNode;
        while(temp != null){
            c++;
            temp = temp.next;
        }
        return c;
    }

    public static ListNode removeKthElement(ListNode head, int k) {
        //suppose k = 2 so we want to remove 2nd element from end
        //eg : 1 -> 2 -> 3, k = 2
        //op : 1 -> 3
        //if size of list and k is same then simply set head = head.next
        //eg : 1 -> 2, k = 2
        //op : 2
        //create two pointer slow and fast both point to head;
        //create a var c = 0
        //while(c < k) set fast = fast.next and c++
        //that will create a gap of k between slow ptr and fast ptr
        //now create a listnode pre so that when we get kth node that prev will point to
        //next of kth node
        //while(fast != null) set prev = slow, slow = slow.next and fast = fast.next
        if(head == null) return head;
        int count = size(head);
        if(count == k){
            head = head.next;
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        int c = 0;
        while(c < k){
            c++;
            fast = fast.next;
        }
        ListNode prev = null;
        while(fast != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        //at end slow is at kth index and prev is before slow so prev.next point to slow.next so that
        //kth element will remove from the list
        prev.next = slow.next;
        return head;
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
        int k = scn.nextInt();

        ListNode head = segregateEvenOdd(dummy.next);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();

        ListNode nhead = removeKthElement(dummy.next,k);
        while(nhead != null){
            System.out.print(nhead.val + " ");
            nhead = nhead.next;
        }
        scn.close();
    }
}
