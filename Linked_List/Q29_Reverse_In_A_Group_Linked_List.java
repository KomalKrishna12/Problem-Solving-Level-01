import java.util.Scanner;
// i/p : 8 8 14 1 10 12 
// n   : 3
// m   : 5
// o/p : 8 8 10 1 14 12 
// we want to rverse from 3rd node to 5th node
public class Q29_Reverse_In_A_Group_Linked_List {
    public static Scanner scn = new Scanner(System.in);

  public static class ListNode {
    int val = 0;
    ListNode next = null;

    ListNode(int val) {
      this.val = val;
    }
  }

  public static ListNode th = null;
  public static ListNode tl = null;

  public static void addFirst(ListNode node) {
      if(th == null){
          th = tl = node;
      }
      else{
          node.next = th;
          th = node;
      }
  }

  public static ListNode reverseInRange(ListNode head, int n, int m) {
      if(head == null || head.next == null || n == m) return head;

      ListNode curr = head;
      ListNode prev = null; // it will use to link with reverse ground
      int idx = 1; // for count

      while(idx < m){
          // when idx in the [n,m]
          while(idx >= n && idx <= m){
              ListNode forw = curr.next; // backup
              curr.next = null;

              addFirst(curr); // reverse the group list using addFirst()
              curr = forw;
              idx++;
          }

          // when idx is after the m means after the reverse group node
          if(idx > n){
              // now link the reverse group with the actual list
              tl.next = curr;
              if(prev != null){
                  // linking previous nodes which is before revrse group
                  prev.next = th;
                  return head;
              }
              // if prev is null that means there is no elmenets before n that means n = 1
              return th;
          }

          // this is the condition where idx is less than n means before the reverse group
          // we simply traverse the node
          prev = curr;
          curr = curr.next;
          idx++;
      }

      return head;
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
    int sz = scn.nextInt();
    ListNode h1 = createList(sz);

    int m = scn.nextInt();
    int n = scn.nextInt();

    h1 = reverseInRange(h1, m, n);
    printList(h1);
  }
}
