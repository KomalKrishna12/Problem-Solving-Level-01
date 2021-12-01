import java.util.Scanner;

// in this question we have given two linked list l1 and and l2 we have to subtract them
// if l2 is null then ans will be l1
// we have to find which linked list is greater
// store larger list into l1 and smaller into l2
public class Q32_Subtraction_Of_Linked_List {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    // calculate size of list
    public static int size(ListNode head) {
        int l = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            l++;
        }
        return l;
    }

    // reverse the list
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

    // suppress the leading zeroes
    // like eg : 0 0 1 2 will be return as 1 2
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
        // if l2 is null then return l1
        if (l2 == null)
            return l1;

        // now supress leading zeroes for both
        l1 = sZeroes(l1);
        l2 = sZeroes(l2);

        // now calculate size of both list
        int s1 = size(l1);
        int s2 = size(l2);

        // create two temp node temp1 and temp2 for letting us know which is greater
        ListNode temp1 = l1;
        ListNode temp2 = l2;

        // f1 & f2 is for backup purpose
        ListNode f1 = null, f2 = null;
        if (s1 == s2) {
            // size is equal then check the elements
            // like l1 - > 1 2 3 4 5
            //      l2 - > 1 2 3 4 0
            // here size is equal so traverse through the nodes of list
            while (temp1 != null) {
                if (temp1.val == temp2.val) {
                    temp1 = temp1.next;
                    temp2 = temp2.next;
                } else if (temp1.val > temp2.val) {
                    f1 = l1;
                    f2 = l2;
                    break;
                } else {
                    f1 = l2;
                    f2 = l1;
                    break;
                }
            }
        } else if (s1 > s2) {
            f1 = l1;
            f2 = l2;
        } else {
            f1 = l2;
            f2 = l1;
        }
        l1 = f1;
        l2 = f2;

        // now reverse both list because subtraction starts from last digit and if we traverse 
        // to it last then complexity becomes more
        l1 = reverseList(l1);
        l2 = reverseList(l2);

        // dummy is the new node which will store subtraction result
        // c1 and c2 we use as pointer for l1 and l2
        ListNode dummy = new ListNode(-1), prev = dummy, c1 = l1, c2 = l2;

        // this will store diff of two digits
        int sub;

        // borow will stored for next digit calculation
        int borrow = 0;

        // size of l1 is greater so in loop we can give one condition for l1 that'll be enough
        while (c1 != null) {
            // if c2 is null then use 0
            sub = borrow + c1.val - (c2 != null ? c2.val : 0);

            // if sub is less then zero then take 1 from previous digit and add 10
            // and set -1 in borrow for next digit
            if (sub < 0) {
                borrow = -1;
                sub += 10;
            } else
                borrow = 0;

            // now create a node pre.next which store sub
            // and move prev to its next    
            prev.next = new ListNode(sub);
            prev = prev.next;

            // move c1 forward
            // if c2 is not null then move c2 also
            c1 = c1.next;
            if (c2 != null)
                c2 = c2.next;
        }

        // now res node will be our result it is reversed using reverse function
        // because for easy calculation we reversed both the list
        ListNode res = reverseList(dummy.next);

        // now suppres leading zeroes like if res - > 0 0 8 8 then it'll become 8 8
        res = sZeroes(res);

        // if res size is zero that means we have given l1 and l2 same and because of suppressing
        // it suppress all zeroes so simply create a node set value as 0 and return
        if (size(res) == 0) {
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
