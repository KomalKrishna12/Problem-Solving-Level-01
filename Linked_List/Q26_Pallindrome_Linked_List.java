import java.util.Scanner;
// 1->2->3->4->3->2->1->null : true
// 1->2->3->4->2->1->null    : false
// we have to check wheather the given list is pallindrome or not if yes then return true 
public class Q26_Pallindrome_Linked_List {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    
    // it will reverse mid of list
    // if odd list then mid
    // if even then first mid 
    public static ListNode mid(ListNode node){
        if(node == null || node.next == null) return node;
        ListNode slow = node, fast = node;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    // this is reverse the list
    public static ListNode reverse(ListNode node){
        if(node == null || node.next == null) return node;
        ListNode prev = null, curr = node, forw = null;
        while(curr != null){
            forw = curr.next; //backup
            curr.next = prev; //link
            prev = curr;
            curr = forw;
        }
        return prev;
    }

    // now we want to check about pallindrome
    // create a boolean var res initialize it with true
    public static boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        boolean res = true;
        
        // now get mid node of list
        // store mid.next in nhead 
        // reverse nhead
        // now we have two list one from head to mid
        // one from mid.next to end
        // reverse the list so that we can travese towards right
        ListNode mid = mid(head);
        ListNode nhead = mid.next;
        mid.next = null;
        
        nhead = reverse(nhead);
        ListNode c1 = head;
        ListNode c2 = nhead;

        // now we can put cond as c1 != null && c2 != null but c2 list is smaller in case of even
        // and c2 is same in case of odd so we 
        // can use c2 != null cond only 
        while(c2 != null){

            // if val of c1 and c2 is not equal then store res = false and break the loop bcoz
            // first and last element is not same so it can't be a pallindrome
            if(c1.val != c2.val){
                res = false;
                break;
            }
            // else move both pointer
            c1 = c1.next;
            c2 = c2.next;
        }

        // now we did so much changes in original list so we simply retrive the changes and 
        // make it as before
        nhead = reverse(nhead);
        // reverse the new list
        // and connect both list
        mid.next = nhead;
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
        scn.close();
        System.out.println(isPalindrome(dummy.next));
    }
}
