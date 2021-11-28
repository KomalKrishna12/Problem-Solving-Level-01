import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q15_Merge_Two_Sorted_Linked_List {
    public static class Node {
        int data;
        Node next;
        Node(int val){
            this.data = val;
        }
        Node(){

        }
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        void addLast(int val) {
            Node temp = new Node();
            temp.data = val;
            temp.next = null;

            if (size == 0) {
                head = tail = temp;
            } else {
                tail.next = temp;
                tail = temp;
            }

            size++;
        }

        public int size() {
            return size;
        }

        public void display() {
            for (Node temp = head; temp != null; temp = temp.next) {
                System.out.print(temp.data + " ");
            }
            System.out.println();
        }

        public void removeFirst() {
            if (size == 0) {
                System.out.println("List is empty");
            } else if (size == 1) {
                head = tail = null;
                size = 0;
            } else {
                head = head.next;
                size--;
            }
        }

        public int getFirst() {
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            } else {
                return head.data;
            }
        }

        public int getLast() {
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            } else {
                return tail.data;
            }
        }

        public int getAt(int idx) {
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            } else if (idx < 0 || idx >= size) {
                System.out.println("Invalid arguments");
                return -1;
            } else {
                Node temp = head;
                for (int i = 0; i < idx; i++) {
                    temp = temp.next;
                }
                return temp.data;
            }
        }

        public void addFirst(int val) {
            Node temp = new Node();
            temp.data = val;
            temp.next = head;
            head = temp;

            if (size == 0) {
                tail = temp;
            }

            size++;
        }

        public void addAt(int idx, int val) {
            if (idx < 0 || idx > size) {
                System.out.println("Invalid arguments");
            } else if (idx == 0) {
                addFirst(val);
            } else if (idx == size) {
                addLast(val);
            } else {
                Node node = new Node();
                node.data = val;

                Node temp = head;
                for (int i = 0; i < idx - 1; i++) {
                    temp = temp.next;
                }
                node.next = temp.next;

                temp.next = node;
                size++;
            }
        }

        public void removeLast() {
            if (size == 0) {
                System.out.println("List is empty");
            } else if (size == 1) {
                head = tail = null;
                size = 0;
            } else {
                Node temp = head;
                for (int i = 0; i < size - 2; i++) {
                    temp = temp.next;
                }

                tail = temp;
                tail.next = null;
                size--;
            }
        }

        public void removeAt(int idx) {
            if (idx < 0 || idx >= size) {
                System.out.println("Invalid arguments");
            } else if (idx == 0) {
                removeFirst();
            } else if (idx == size - 1) {
                removeLast();
            } else {
                Node temp = head;
                for (int i = 0; i < idx - 1; i++) {
                    temp = temp.next;
                }

                temp.next = temp.next.next;
                size--;
            }
        }

        private Node getNodeAt(int idx) {
            Node temp = head;
            for (int i = 0; i < idx; i++) {
                temp = temp.next;
            }
            return temp;
        }

        public void reverseDI() {
            int li = 0;
            int ri = size - 1;
            while (li < ri) {
                Node left = getNodeAt(li);
                Node right = getNodeAt(ri);

                int temp = left.data;
                left.data = right.data;
                right.data = temp;

                li++;
                ri--;
            }
        }

        public void reversePI() {
            if (size <= 1) {
                return;
            }

            Node prev = null;
            Node curr = head;
            while (curr != null) {
                Node next = curr.next;

                curr.next = prev;
                prev = curr;
                curr = next;
            }

            Node temp = head;
            head = tail;
            tail = temp;
        }

        public int kthFromLast(int k) {
            Node slow = head;
            Node fast = head;
            for (int i = 0; i < k; i++) {
                fast = fast.next;
            }

            while (fast != tail) {
                slow = slow.next;
                fast = fast.next;
            }

            return slow.data;
        }

        public int mid() {
            Node f = head;
            Node s = head;

            while (f.next != null && f.next.next != null) {
                f = f.next.next;
                s = s.next;
            }

            return s.data;
        }
        public static Node mergeTwoLL(Node head1, Node head2){
            //if any one of these node head is null that means we have single linked list
            //which is sorted so return that linked list
            if(head1 == null || head2 == null){
                return head1 != null ? head1 : head2;
            }
            //now create a dummy linked list with node val = -1 that means it is empty
            //prev is also pointing to dummy
            //now store head1 into c1 and head2 into c2
            //now run loop for both c1 and c2 not null
            //if c1.data <= c2.data then prev.next will be c1
            //and then c1 point to next and prev point to next
            //if c2 is lesser then same with prev.next = c2
            //now any one of the list is still contain some element which is sorted
            //so simply check which is not empty and prev.next will point to that
            //linked list only
            Node dummy = new Node(-1);
            Node prev = dummy;
            Node c1 = head1;
            Node c2 = head2;
            while(c1 != null && c2 != null){
                if(c1.data <= c2.data){
                    prev.next = c1;
                    c1 = c1.next;
                }
                else{
                    prev.next = c2;
                    c2 = c2.next;
                }
                prev = prev.next;
            }
            prev.next = c1 != null ? c1 : c2;
            return dummy.next;
        }

        public static LinkedList mergeTwoSortedLists(LinkedList l1, LinkedList l2) {
            //this code is bad becoz addLast having o(n) complexity
            //while(n1 != null && n2 != null) having o(n+m)
            //and again both while will have o(n) ad o(m) coplexity
            //so their is other approach which we tri in mergeTwoLL(ListNode l1, ListNode l2)
            Node n1 = l1.head;
            Node n2 = l2.head;
            LinkedList res = new LinkedList();
            while(n1 != null && n2 != null){
                if(n1.data <= n2.data){
                    res.addLast(n1.data);
                    n1 = n1.next;
                }
                else{
                    res.addLast(n2.data);
                    n2 = n2.next;
                }
            }
            while(n1 != null){
                res.addLast(n1.data);
                n1 = n1.next;
            }
            while(n2 != null){
                res.addLast(n2.data);
                n2 = n2.next;
            }
            return res;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n1 = Integer.parseInt(br.readLine());
        LinkedList l1 = new LinkedList();
        String[] values1 = br.readLine().split(" ");
        for (int i = 0; i < n1; i++) {
            int d = Integer.parseInt(values1[i]);
            l1.addLast(d);
        }

        int n2 = Integer.parseInt(br.readLine());
        LinkedList l2 = new LinkedList();
        String[] values2 = br.readLine().split(" ");
        for (int i = 0; i < n2; i++) {
            int d = Integer.parseInt(values2[i]);
            l2.addLast(d);
        }

        LinkedList merged = LinkedList.mergeTwoSortedLists(l1, l2);
        merged.display();
        l1.display();
        l2.display();
    }
}
