import java.io.*;
import java.util.*;;
public class Q11_Linerize_Generic_Tree {
    private static class Node {
        int data;
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
    
      public static void traversals(Node node) {
        System.out.println("Node Pre " + node.data);
    
        for (Node child : node.children) {
          System.out.println("Edge Pre " + node.data + "--" + child.data);
          traversals(child);
          System.out.println("Edge Post " + node.data + "--" + child.data);
        }
    
        System.out.println("Node Post " + node.data);
      }
    
      public static void levelOrderLinewiseZZ(Node node) {
        Stack<Node> stack = new Stack<>();
        stack.add(node);
    
        Stack<Node> cstack = new Stack<>();
        int level = 0;
    
        while (stack.size() > 0) {
          node = stack.pop();
          System.out.print(node.data + " ");
    
          if (level % 2 == 0) {
            for (int i = 0; i < node.children.size(); i++) {
              Node child = node.children.get(i);
              cstack.push(child);
            }
          } else {
            for (int i = node.children.size() - 1; i >= 0; i--) {
              Node child = node.children.get(i);
              cstack.push(child);
            }
          }
    
          if (stack.size() == 0) {
            stack = cstack;
            cstack = new Stack<>();
            level++;
            System.out.println();
          }
        }
      }
    
      public static void mirror(Node node) {
        for (Node child : node.children) {
          mirror(child);
        }
        Collections.reverse(node.children);
      }
    
      public static void removeLeaves(Node node) {
        for (int i = node.children.size() - 1; i >= 0; i--) {
          Node child = node.children.get(i);
          if (child.children.size() == 0) {
            node.children.remove(i);
          }
        }
    
        for(Node child: node.children){
          removeLeaves(child);
        }
      }
    
      public static void linearize(Node node){
          // we want to linearinze our tree using recusrsion
          // we assume that node.children is linearized and we just need to linear node with its 
          // children suppose node is 10 its child are 20 30 40 which linearize so 20-50-60 30-70 40-80-90

          for (Node child : node.children) {
              linearize(child);
          }
          while(node.children.size() > 1){
              Node lastNode = node.children.remove(node.children.size() - 1);
              Node secondLast = node.children.get(node.children.size() - 1);
              Node secondLastTail = getTail(secondLast);
              secondLastTail.children.add(lastNode);
          }
          // while children size is greater than 1 remove its last node and try to make it as child of
          // second last node(30)
          // after removing last node our second last node will be the last node(20)
          // now find out its tail so tail of 20 is 60 using gettail we got tail
          // now tail.children point to last node do this till all children will be linearize
      }

      // so we know in linear we have one children only
      // so using while loop go to its tail tail is havng 0 children so remove that node
      private static Node getTail(Node node){
          while(node.children.size() == 1){
              node = node.children.get(0);
          }
          return node;
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
        linearize(root);
        display(root);
      }
}
