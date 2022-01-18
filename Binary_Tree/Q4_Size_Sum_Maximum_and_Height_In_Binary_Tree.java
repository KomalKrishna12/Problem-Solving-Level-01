import java.util.*;
import java.io.*;

public class Q4_Size_Sum_Maximum_and_Height_In_Binary_Tree {
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

  // if root is null return 0 that means their is 0 nodes in binary tree
  // if root is leaf node then return 1
  // now use recursion and store size of left and right tree and at end return sum
  // of left and right and
  // add 1 to it
  public static int size(Node node) {
    if (node == null)
      return 0;
    if (node.left == null && node.right == null)
      return 1;
    int leftsize = size(node.left);
    int rightsize = size(node.right);
    int totalsize = leftsize + rightsize + 1;
    return totalsize;
  }

  public static int sum(Node node) {
    if (node == null)
      return 0;
    int leftsum = sum(node.left);
    int rightsum = sum(node.right);
    int totalsum = leftsum + rightsum + node.data;
    return totalsum;
  }

  // in this we're required to check that the tree is sum tree or not
  // sum tree means root.data == sum of left + sum of right
  // and this condition is for every tree node
  // if function return 1 that means tree is sumTree else not a sumTree
  // so we're using sum function for checking the sum of nodes
  // if sum of left and right == root.data and left node and right node is sumTree then return 1
  public static int sumTree(Node root) {
    if (root == null || (root.left == null && root.right == null))
      return 1;
    int ls = sum(root.left);
    int rs = sum(root.right);
    if (ls + rs == root.data && sumTree(root.left) != 0
        && sumTree(root.right) != 0)
      return 1;
    return 0;
  }

  public static int max(Node node) {
    if (node == null)
      return Integer.MIN_VALUE;
    int leftmax = max(node.left);
    int rightmax = max(node.right);
    int max = Math.max(node.data, Math.max(leftmax, rightmax));
    return max;
  }

  public static int height(Node node) {
    if (node == null)
      return -1;
    int leftheight = height(node.left);
    int rightheight = height(node.right);
    int height = Math.max(leftheight, rightheight) + 1;
    return height;
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

    int size = size(root);
    int sum = sum(root);
    int max = max(root);
    int ht = height(root);
    System.out.println(size);
    System.out.println(sum);
    System.out.println(max);
    System.out.println(ht);
  }
}