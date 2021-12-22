import java.io.*;
import java.util.*;
public class Q20_Largest_BST_Subtree {
    public static class Node {
        int data;
        Node left;
        Node right;
    
        Node(int data, Node left, Node right) {
          this.data = data;
          this.left = left;
          this.right = right;
        }
      }
    
      public static class Pair {
        Node node;
        int state;
    
        Pair(Node node, int state) {
          this.node = node;
          this.state = state;
        }
      }
    
      public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);
    
        Stack<Pair> st = new Stack<>();
        st.push(rtp);
    
        int idx = 0;
        while (st.size() > 0) {
          Pair top = st.peek();
          if (top.state == 1) {
            idx++;
            if (arr[idx] != null) {
              top.node.left = new Node(arr[idx], null, null);
              Pair lp = new Pair(top.node.left, 1);
              st.push(lp);
            } else {
              top.node.left = null;
            }
    
            top.state++;
          } else if (top.state == 2) {
            idx++;
            if (arr[idx] != null) {
              top.node.right = new Node(arr[idx], null, null);
              Pair rp = new Pair(top.node.right, 1);
              st.push(rp);
            } else {
              top.node.right = null;
            }
    
            top.state++;
          } else {
            st.pop();
          }
        }
    
        return root;
      }
    
      public static void display(Node node) {
        if (node == null) {
          return;
        }
    
        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);
    
        display(node.left);
        display(node.right);
      }

      public static class BST{
          int min, max;
          boolean isBST;
          int size;
          Node root;
      }

      public static BST largestBST(Node node){
          if(node == null){
              BST bst = new BST();
              bst.min = Integer.MAX_VALUE;
              bst.max = Integer.MIN_VALUE;
              bst.isBST = true;
              bst.size = 0;
              bst.root = null;
              return bst;
          }

          BST lb = largestBST(node.left);
          BST rb = largestBST(node.right);
          BST mb = new BST();
          mb.isBST = lb.isBST && rb.isBST && (node.data >= lb.max) && (node.data <= rb.min);
          mb.max = Math.max(node.data, Math.max(lb.max, rb.max));
          mb.min = Math.min(node.data, Math.min(lb.min, rb.min));

          if(mb.isBST){
              mb.root = node;
              mb.size = lb.size + rb.size + 1;
          }
          else if(lb.size > rb.size){
              mb.root = lb.root;
              mb.size = lb.size;
          }
          else{
              mb.root = rb.root;
              mb.size = rb.size;
          }

          return mb;
      }
      
      public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
          if (values[i].equals("n") == false) {
            arr[i] = Integer.parseInt(values[i]);
          } else {
            arr[i] = null;
          }
        }
    
        Node root = construct(arr);
        BST bst = largestBST(root);
        System.out.println(bst.root.data + "@" + bst.size);
        
        // write your code here
      }
    
}
