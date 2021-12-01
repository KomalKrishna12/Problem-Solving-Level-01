import java.util.Scanner;

public class Q32_Subtraction_Of_Linked_List {
    public static Scanner scn = new Scanner(System.in);

  public static class ListNode {
    int val = 0;
    ListNode next = null;

    ListNode(int val) {
      this.val = val;
    }
  }

  public static int size(ListNode head) {
    int l = 0;
    ListNode temp = head;
    while (temp != null) {
      temp = temp.next;
      l++;
    }
    return l;
  }

  public static ListNode reverseList(ListNode node) {
    ListNode pre = null;
    ListNode curr = node;
    ListNode f = null;
    while (curr != null) {
      f = curr.next;
      curr.next = pre;
      pre = curr;
      curr = f;
    }
    return pre;
  }
  public static ListNode sZeroes(ListNode node) {
        while (node != null) {
            if (node.val == 0) {
                node = node.next;
            } else {
                return node;
            }
        }
        return node;
    }


  public static ListNode subtractTwoNumbers(ListNode l1, ListNode l2) {
    if (l2 == null)
      return l1;
      
    l1 = sZeroes(l1);
    l2 = sZeroes(l2);
    int s1 = size(l1);
    int s2 = size(l2);
    
    ListNode temp1 = l1;
    ListNode temp2 = l2;
    ListNode f1 = null, f2 = null;
    if(s1 == s2){
        while(temp1 != null){
            if(temp1.val == temp2.val){
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
            else if(temp1.val > temp2.val){
                f1 = l1;
                f2 = l2;
                break;
            }
            else{
                f1 = l2;
                f2 = l1;
                break;
            }
        }
    }
    else if(s1 > s2){
        f1 = l1;
        f2 = l2;
    }
    else{
        f1 = l2;
        f2 = l1;
    }
    l1 = f1;
    l2 = f2;
    

    l1 = reverseList(l1);
    l2 = reverseList(l2);

    ListNode dummy = new ListNode(-1), prev = dummy, c1 = l1, c2 = l2;
    int sub;

    int borrow = 0;
    while (c1 != null) {
      sub = borrow + c1.val - (c2 != null ? c2.val : 0);
      if (sub < 0) {
        borrow = -1;
        sub += 10;
      } else
        borrow = 0;

      prev.next = new ListNode(sub);
      prev = prev.next;

      c1 = c1.next;
      if (c2 != null)
        c2 = c2.next;
    }
    ListNode res = reverseList(dummy.next);
    res = sZeroes(res);
    if(size(res) == 0){
        return new ListNode(0);
    }
    return res;
  }

  // InFput_code===================================================

  public static void printList(ListNode node) {
    while (node != null) {
      System.out.print(node.val + " ");
      node = node.next;
    }
  }

  public static ListNode makeList(int n) {
    ListNode dummy = new ListNode(-1);
    ListNode prev = dummy;
    while (n-- > 0) {
      prev.next = new ListNode(scn.nextInt());
      prev = prev.next;
    }

    return dummy.next;
  }

  public static void main(String[] args) {
    ListNode head1 = makeList(scn.nextInt());
    ListNode head2 = makeList(scn.nextInt());

    ListNode ans = subtractTwoNumbers(head1, head2);
    printList(ans);
  }
}
