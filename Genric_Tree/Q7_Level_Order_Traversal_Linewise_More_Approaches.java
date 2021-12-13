import java.io.*;
import java.util.*;
public class Q7_Level_Order_Traversal_Linewise_More_Approaches{
    private static class Node {
        int data;
        Node(int data){
            this.data = data;
        }
        Node(){}
        ArrayList<Node> children = new ArrayList<>();
      }
    
      public static void display(Node node) {
        String str = node.data + " -> ";
        for (Node child : node.children) {
          str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);
    
        for (Node child : node.children) {
          display(child);
        }
      }
    
      public static Node construct(int[] arr) {
        Node root = null;
    
        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
          if (arr[i] == -1) {
            st.pop();
          } else {
            Node t = new Node();
            t.data = arr[i];
    
            if (st.size() > 0) {
              st.peek().children.add(t);
            } else {
              root = t;
            }
    
            st.push(t);
          }
        }
    
        return root;
      }
    
      public static int size(Node node) {
        int s = 0;
    
        for (Node child : node.children) {
          s += size(child);
        }
        s += 1;
    
        return s;
      }
    
      public static int max(Node node) {
        int m = Integer.MIN_VALUE;
    
        for (Node child : node.children) {
          int cm = max(child);
          m = Math.max(m, cm);
        }
        m = Math.max(m, node.data);
    
        return m;
      }
    
      public static int height(Node node) {
        int h = -1;
    
        for (Node child : node.children) {
          int ch = height(child);
          h = Math.max(h, ch);
        }
        h += 1;
    
        return h;
      }
    
      public static void traversals(Node node){
        System.out.println("Node Pre " + node.data);
    
        for(Node child: node.children){
          System.out.println("Edge Pre " + node.data + "--" + child.data);
          traversals(child);
          System.out.println("Edge Post " + node.data + "--" + child.data);
        }
    
        System.out.println("Node Post " + node.data);
      }
    
      public static void levelOrderLinewise(Node node){
          Queue<Node> mainQueue = new ArrayDeque<>();
          mainQueue.add(node);

          Queue<Node> childQueue = new ArrayDeque<>();
          while(mainQueue.size() > 0){
              node = mainQueue.remove();
              System.out.print(node.data + " ");
              for(Node child : node.children){
                  childQueue.add(child);
              }
              if(mainQueue.size() == 0){
                  mainQueue = childQueue;
                  childQueue = new ArrayDeque<>();
                  System.out.println();
              }
          }
      }

      public static void levelOrderLinewise2(Node node){
          // in this approach we are using a single queue
          // firstly add node and then a node with -1 data 
          // now create a while loop run till mq.size() > 0
          // if node.data is not -1 then remove print and add its children
          // else if mq.size is greater than 0 then add -1 data node and enter space
        Queue<Node> mainQueue = new ArrayDeque<>();
        mainQueue.add(node);
        mainQueue.add(new Node(-1));

        while(mainQueue.size() > 0){
            node = mainQueue.remove();
            if(node.data != -1){
                System.out.print(node.data + " ");
                for (Node child : node.children) {
                    mainQueue.add(child);
                }
            }
            else{
                if(mainQueue.size() > 0){
                    mainQueue.add(new Node(-1));
                    System.out.println();
                }
            }
        }
    }
    
      public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
          arr[i] = Integer.parseInt(values[i]);
        }
    
        Node root = construct(arr);
        levelOrderLinewise2(root);
      }
}