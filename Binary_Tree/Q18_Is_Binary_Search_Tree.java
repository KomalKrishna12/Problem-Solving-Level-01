import java.io.*;
import java.util.*;
// Binary Search Tree is having a property that each node is greater than max of its left node
// and less that min of right node
public class Q18_Is_Binary_Search_Tree {
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

      public static class BSTree{
          boolean isBST;
          int max;
          int min;
      }

      public static BSTree isBST(Node node){
          if(node == null){
              BSTree base = new BSTree();
              base.max = Integer.MIN_VALUE;
              base.min = Integer.MAX_VALUE;
              base.isBST = true;
              return base;
          }

          BSTree lt = isBST(node.left);
          BSTree rt = isBST(node.right);

          BSTree bp = new BSTree();
          bp.isBST = lt.isBST && rt.isBST && (node.data >= lt.max && node.data <= rt.min);
          bp.max = Math.max(node.data, Math.max(lt.max, rt.max));
          bp.min = Math.min(node.data, Math.min(lt.min, rt.min));

          return bp;
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
    
      public static int height(Node node) {
        if (node == null) {
          return -1;
        }
    
        int lh = height(node.left);
        int rh = height(node.right);
    
        int th = Math.max(lh, rh) + 1;
        return th;
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
        BSTree bst = isBST(root);
        System.out.println(bst.isBST);
      }
}
