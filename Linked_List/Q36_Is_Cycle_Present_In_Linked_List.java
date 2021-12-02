import java.util.Scanner;

public class Q36_Is_Cycle_Present_In_Linked_List {
    public static Scanner scn = new Scanner(System.in);

  public static class ListNode {
    int val = 0;
    ListNode next = null;

    ListNode(int val) {
      this.val = val;
    }
  }

  public static boolean isCyclePresentInLL(ListNode head) {

    return false;
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
    System.out.println(isCyclePresentInLL(head));
  }
}
