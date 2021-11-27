import java.io.*;

public class Q3_Remove_First_Linked_List {
    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        public LinkedList() {
            head = null;
            tail = null;
            size = 0;
        }

        public void addLast(int val) {
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
            // we create a node temp assign it with head and run the loop till temp beacome
            // run
            // and print temp.data and assign temp to its next value
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }

        public void removeFirst() {
            if(size == 0)
            System.out.println("List is empty");
            else if(size == 1){
                head = tail = null;
                size = 0;
            }
            else{
                head = head.next;
                size--;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList list = new LinkedList();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("addLast")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                list.addLast(val);
            } else if (str.startsWith("size")) {
                System.out.println(list.size());
            } else if (str.startsWith("display")) {
                list.display();
            }
            str = br.readLine();
        }
    }
}
