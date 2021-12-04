import java.util.Scanner;

public class Q41_Segregate_Linked_List_Over_Pivot_Index {
    public static Scanner scn = new Scanner(System.in);

  public static class ListNode {
    int val = 0;
    ListNode next = null;

    ListNode(int val) {
      this.val = val;
    }
  }

  public static ListNode segregate(ListNode head, int pivotIdx) {
      if(head == null || head.next == null) return head;
      // create two int variable idx for comparing with pivotIdx and data will contain the
      // val at pivot index
      // we move till that node where our idx == pivotIdx
      int idx = 0, data = 0;
      ListNode curr = head;
      while(curr != null){
          if(idx == pivotIdx){
              // when idx and pivotIdx becomes equal then store value of that curr node in data and
              // break the loop
              data = curr.val;
              break;
          }
          // increase idx by 1 and move curr forward
          idx++;
          curr = curr.next;
      }
      // again set idx as 0 and curr as head
      // create a node pivot which contain our pivot index node
      idx = 0;
      curr = head;
      ListNode pivot = null;
      // node s will point to all nodes which is less than or equal to data
      // node l will point to all nodes which is greater than or equal to data
      // increase idx everytime and curr
      ListNode s = new ListNode(-1);
      ListNode l = new ListNode(-1);
      ListNode sp = s, lp = l;
      while(curr != null){
          // when idx == pivotidx then point pivot node to that curr node
          if(idx == pivotIdx){
              pivot = curr;
          }
          else if(curr.val <= data){
              sp.next= curr;
              sp = sp.next;
          }
          else{
              lp.next = curr;
              lp = lp.next;
          }
          curr = curr.next;
          idx++;
      }
      // now smaller pointer next will point to pivot
      // pivot point to larger pointer head
      // larger pointer will point to null
      sp.next = pivot;
      pivot.next = l.next;
      lp.next = null;
    return s.next;
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
    int idx = scn.nextInt();
    h1 = segregate(h1, idx);
    printList(h1);
  }
}
