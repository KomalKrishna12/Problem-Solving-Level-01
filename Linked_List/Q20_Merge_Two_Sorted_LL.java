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
      //firsly check that both list is not null if one is null then return second
    if (l1 == null || l2 == null)
      return l1 != null ? l1 : l2;
      //now create a dummy list and set ptr = dummy
      //create two listnode c1 and c2 that will point to l1 and l2 which is head of linked list

    ListNode dummy = new ListNode(-1);
    ListNode ptr = dummy;
    ListNode c1 = l1;
    ListNode c2 = l2;
    //if both is not null then check data of c1 and c2
    //is c1 is lesser than ptr.next will point to c1 else point to c2
    //set ptr to ptr.next
    //now there is chance that both list is of diff size so check which is not null and set ptr.next 
    //to that list
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
