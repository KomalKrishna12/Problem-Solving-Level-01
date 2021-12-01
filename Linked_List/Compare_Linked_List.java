import java.util.Scanner;

public class Compare_Linked_List {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void display(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static int size(ListNode node) {
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
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

    public static ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode curr = node;
        ListNode forw = null;
        while (curr != null) {
            forw = curr.next;
            curr.next = prev;

            prev = curr;
            curr = forw;
        }
        return prev;
    }

    public static ListNode diff(ListNode l1, ListNode l2) {
        
        l1 = reverse(l1);
        l2 = reverse(l2);
        
        ListNode c1 = l1, c2 = l2;

        int borrow = 0;
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        int diff = 0;
        while (c1 != null) {
            diff = borrow + c1.val - (c2 != null ? c2.val : 0);
            if (diff < 0) {
                borrow = -1;
                diff += 10;
            }
            else{
                borrow = 0;
            }
            tail.next = new ListNode(diff);
            tail = tail.next;
            c1 = c1.next;
            if (c2 != null)
                c2 = c2.next;
        }
        ListNode res = reverse(dummy.next);
        res = sZeroes(res);
        if(size(res) == 0){
            return new ListNode(0);
        }
        
        return res;
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
        int n2 = scn.nextInt();
        ListNode dummy2 = new ListNode(-1);
        ListNode prev2 = dummy2;
        while (n2-- > 0) {
            prev2.next = new ListNode(scn.nextInt());
            prev2 = prev2.next;
        }

        ListNode head1 = dummy.next;
        ListNode head2 = dummy2.next;
        head1 = sZeroes(head1);
        head2 = sZeroes(head2);
        display(head1);
        display(head2);
        int s1 = size(head1);
        int s2 = size(head2);
        System.out.println("Size of first List  : " + s1);
        System.out.println("Size of Second List : " + s2);
        ListNode temp1 = head1;
        ListNode temp2 = head2;
        ListNode f1 = null, f2 = null;
        if (s1 == s2) {
            
            while (temp1 != null) {
                if (temp1.val == temp2.val) {
                    temp1 = temp1.next;
                    temp2 = temp2.next;
                } else if (temp1.val > temp2.val) {
                    f1 = head1;
                    f2 = head2;
                    break;
                } else {
                    f1 = head2;
                    f2 = head1;
                    break;
                }
            }
            
        }
        else if (s1 > s2) {
            f1 = head1;
            f2 = head2;
        }
        else{
            f1 = head2;
            f2 = head1;
        }
        head1 = f1;
        head2 = f2;

        display(head1);
        display(head2);
        scn.close();

        ListNode difference = diff(head1, head2);
        display(difference);

    }
}
