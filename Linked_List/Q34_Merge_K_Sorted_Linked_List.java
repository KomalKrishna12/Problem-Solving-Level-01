import java.util.Scanner;

public class Q34_Merge_K_Sorted_Linked_List {
    public static Scanner scn = new Scanner(System.in);

  public static class ListNode {
    int val = 0;
    ListNode next = null;

    ListNode(int val) {
      this.val = val;
    }
  }

  // function to merge two linked list
  public static ListNode mergeLL(ListNode l1, ListNode l2) {

    // if l1 is null then return l2 else if l2 is null then return l1
    if (l1 == null || l2 == null) {
      return l1 != null ? l1 : l2;
    }

    // c1 point to l1 and c2 point to l2
    ListNode c1 = l1, c2 = l2;

    // dummy node will point to merge list
    ListNode dummy = new ListNode(-1);

    // itr will point to its next node
    ListNode itr = dummy;
    while (c1 != null && c2 != null) {

        // if c1 value is less then itr.next will point to c1 and c1 will move forward
        // else itr.next will point to c2 and c2 will move forward
      if (c1.val < c2.val) {
        itr.next = c1;
        c1 = c1.next;
      }
      else {
        itr.next = c2;
        c2 = c2.next;
      }
      itr = itr.next;
    }

    // there is a chance that c1 or c2 is still containing some data so itr.next will point to that node
    itr.next = c1 != null ? c1 : c2;
    return dummy.next;
  }

  // si (start index) and li (last index)
  // if si and li is same then simply return that list
  // basically we're dividing our list using mid
  // and applying recursion 
  public static ListNode mergeKLists(ListNode[] lists, int si, int li) {
    if (si == li) return lists[si];
    if (si > li) return null;
    int mid = (si + li) / 2;
    ListNode l1 = mergeKLists(lists, si, mid);
    ListNode l2 = mergeKLists(lists, mid + 1, li);

    // l1 and l2 will be our list
    // now merge l1 and l2 and return
    return mergeLL(l1, l2);
  }

  public static ListNode mergeKLists(ListNode[] lists) {
    if (lists.length == 0) return null;
    return mergeKLists(lists, 0, lists.length - 1);
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
    ListNode[] list = new ListNode[n];
    for (int i = 0; i < n; i++) {
      int m = scn.nextInt();
      list[i] = createList(m);
    }

    ListNode head = mergeKLists(list);
    printList(head);
  }
}
