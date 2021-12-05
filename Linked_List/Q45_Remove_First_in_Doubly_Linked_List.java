import java.util.Scanner;

public class Q45_Remove_First_in_Doubly_Linked_List {
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
    
        // Exceptions========================================
    
        private boolean ListIsEmptyException() {
          if (this.size == 0) {
            System.out.print("ListIsEmpty: " );
            return true;
          }
          return false;
        }
    
        // AddFunctions======================================
    
        private void addFirstNode(Node node) {
          if (this.size == 0)
            this.head = this.tail = node;
          else {
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
          }
          this.size++;
        }
    
        public void addFirst(int val) {
          Node node = new Node(val);
          addFirstNode(node);
        }
    
        private void addLastNode(Node node) {
          if (this.size == 0)
            this.head = this.tail = node;
          else {
            this.tail.next = node;
            node.prev = this.tail;
            this.tail = node;
          }
          this.size++;
        }
    
        public void addLast(int val) {
          Node node = new Node(val);
          addLastNode(node);
        }
    
        // RemoveFunctions======================================
        // this will remove the first node
        public Node removeFirstNode(){
            // we store the head in node
            Node node = this.head;
            // if size is 1 and we want to remove first node then head and tail become null
            if(this.size == 1){
                this.head = this.tail = null;
            }
            else{
                // store node.next in forw
                // this.head.next will point to null bcoz we want to remove that node
                // forw.prev will point to next
                // and forw will become our head
                Node forw = node.next;
                this.head.next = null;
                forw.prev = null;
                this.head = forw;
            }
            // at end decrese the size of list and return the node
            this.size--;
            return node;
        }
        public int removeFirst() {
            // if list is empty then listisemptyexception will run
            if(ListIsEmptyException()){
                return -1;
            }
            // this will return data of first node
            return removeFirstNode().data;
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
          else if (s[0].equals("addLast"))
            dll.addLast(Integer.parseInt(s[1]));
          else if (s[0].equals("removeFirst"))
            System.out.println(dll.removeFirst());
    
          str = scn.nextLine();
        }
        scn.close();
    
        System.out.println(dll);
    }
}
