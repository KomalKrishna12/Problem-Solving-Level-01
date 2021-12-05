import java.util.Scanner;

public class Q43_Add_First_In_Doubly_Linked_List {
    public static class DoublyLinkedList {
        private class Node {
          int data = 0;
          Node prev = null;
          Node next = null;
    
          Node(int data) {
            this.data = data;
          }
    
        }
    
        private Node head = null;
        private Node tail = null;
        private int size = 0;
    
        public String toString() {
          StringBuilder sb = new StringBuilder();
          Node curr = this.head;
          sb.append("[");
          while (curr != null) {
            sb.append(curr.data);
            if (curr.next != null)
              sb.append(", ");
            curr = curr.next;
          }
          sb.append("]");
    
          return sb.toString();
        }
        
        // if size is 0 then that node is the only one node of list
        // so head and tail both point to that node
        public void addFirstNode(Node node){
            if(this.size == 0){
                this.head = node;
                this.tail = node;
            }
            else{
                // if size is not zero that node.next will point to head
                // head.prev point to node
                // and that new node becomes our head
                node.next = this.head;
                this.head.prev = node;
                this.head = node;
            }
            // increase size because we're adding a node in list
            this.size++;
        }
    
        // we create a node wihich contain val as data
        // and call addFirstNode(node) 
        public void addFirst(int val) {
            Node node = new Node(val);
            addFirstNode(node);
        }
    
      }
    
      public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        DoublyLinkedList dll = new DoublyLinkedList();
    
        String str = scn.nextLine();
        while (!str.equals("stop")) {
          String[] s = str.split(" ");
          if (s[0].equals("addFirst"))
            dll.addFirst(Integer.parseInt(s[1]));
    
          str = scn.nextLine();
        }
        scn.close();
        System.out.println(dll);
    }
}
