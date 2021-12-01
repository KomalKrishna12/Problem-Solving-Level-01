import java.util.Scanner;

public class Q31_Multiplication_Of_Linked_List {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode reverse(ListNode node) {
        ListNode prev = null, forw = null;
        ListNode curr = node;
        while(curr != null){
            forw = curr.next;
            curr.next = prev;

            prev = curr;
            curr = forw;
        }
        return prev;
    }

    // we have given a linked list and a digit we have to multiply them
    // dummy is a node which is created to store multiplication result;
    public static ListNode multiplyLLwithDigit(ListNode head, int dig) {
        ListNode dummy = new ListNode(-1);

        // ac (ans curr) will point to next nodes
        ListNode ac = dummy;

        // curr will point to head
        ListNode curr = head;

        // at first carry is 0
        int carry = 0;

        // while loop will run till carry != 0 or curr != null
        while(curr != null || carry != 0){

            // ans will store multiplication of curr.val and digit and add carry to it
            int ans = carry + (curr != null ? curr.val : 0) * dig;

            // digit we get using modulas
            int digit = ans % 10;

            // carry will be ans / 10
            carry = ans / 10;

            // ac.next will created as new node and it stored the digit as value
            ac.next = new ListNode(digit);

            // then ac point to its next node
            ac = ac.next;

            // if curr is not null then curr point to its next null
            if(curr != null) curr = curr.next;
        }
        return dummy.next;
    }

    // this is the code to add two linked list
    public static void addTwoLL(ListNode l1, ListNode ansItr) {

        // c1 will point to l1 and c2 will point to ansItr
        ListNode c1 = l1;
        ListNode c2 = ansItr;

        // at first carry is 0
        int carry = 0;

        // loop will run till c1 is not null or carry is not 0
        while(c1 != null || carry != 0){

            // if c1 is not null then add c1.val otherwise zero to sum
            // if c2.next is not null then c2.next.val otherwise zero
            // add these values with carry
            int sum = carry + (c1 != null ? c1.val : 0) + (c2.next != null ? c2.next.val : 0);

            // digit will be modulas of sum with 10
            int digit = sum % 10;

            // carry will be division of sum with 10
            carry = sum / 10;

            // if c2.next is not null then store c2.next.val as digit
            // else create a new node and assign digit as value
            // for the first time l2 will be null and for next it will not null
            //  23
            // *23
            // addition of 23*3 +23*2
            // but as 69(23*3)
            //       46-(23*2)
            //      =519
            if(c2.next != null) c2.next.val = digit;
            else c2.next = new ListNode(digit);
            if(c1 != null) c1 = c1.next;
            c2 = c2.next;
        }
    }

    // so two multpliy two list
    // l1 - > 2 3  l2 - > 4 5
    // multiply l1 with 5 then l1 with 4
    public static ListNode multiplyTwoLL(ListNode l1, ListNode l2) {

        // reverse both l1 and l2 becozto do any arithmetic operation we start from end digit
        l1 = reverse(l1);
        l2 = reverse(l2);

        // l2_itr is use to traverse in l2 to get value and multiply with l1
        ListNode l2_itr = l2;
        ListNode dummy = new ListNode(-1);
        ListNode itr = dummy;
        while(l2_itr != null){

            // prod will store single digit multiplication is node
            ListNode prod = multiplyLLwithDigit(l1, l2_itr.val);
            
            // move forward in l2
            l2_itr = l2_itr.next;

            // add prod list and itr
            addTwoLL(prod, itr);

            // shift itr to its next because when we multiply we traverse one step towards left
            //   2 3 4
            // 3 4 5 -
            // 4 5 - -
            // like this
            itr = itr.next;
        }
        return reverse(dummy.next);
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

        ListNode ans = multiplyTwoLL(head1, head2);
        printList(ans);
    }
}
