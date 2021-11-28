import java.util.*;
public class Q20_Merge_Two_Sorted_LL {
    public static Scanner scn = new Scanner(System.in);

  public static class ListNode {
    int val = 0;
    ListNode next = null;

    ListNode(int val) {
      this.val = val;
    }
  }

  public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null || l2 == null)
      return l1 != null ? l1 : l2;
    ListNode dummy = new ListNode(-1);
    ListNode ptr = dummy;
    ListNode c1 = l1;
    ListNode c2 = l2;
    while(c1 != null && c2 != null){
        if(c1.val <= c2.val){
            ptr.next = c1;
            c1 = c1.next;
        }
        else{
            ptr.next = c2;
            c2 = c2.next;
        }
        ptr = ptr.next;
    }
    ptr.next = c1 != null ? c1 : c2;
    return dummy.next;
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
    int m = scn.nextInt();
    ListNode h2 = createList(m);


    ListNode head = mergeTwoLists(h1, h2);
    printList(head);
  }
}
