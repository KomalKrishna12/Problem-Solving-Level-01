import java.io.*;
import java.util.*;
public class Q8_Target_sum_pair_second_approach_using_arraylist {
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
      public static boolean find(Node node, int data){
          if(node == null) return false;
          if(node.data > data) return find(node.left, data);
          else if(node.data < data) return find(node.right, data);
          else return true;
      }
      // we want to find sum pair whose sum equal to tar
      // and we want to print in that way so small value come before greater
      // so we want it in sortec manner so do this in inorder
      // call for left
      // then calculate rest and search if rest is available or not
      // call for right
      public static void target(Node root, Node node, int tar){
          if(node == null) return;
          target(root, node.left, tar);
          int resttar = tar - node.data;
          if(node.data < resttar){
              if(find(root, resttar) == true)
              System.out.println(node.data + " " + resttar);
          }
          target(root, node.right, tar);
      }
    
      // second approach using array list
      // firstly using inorder traversal add all node in array list and rest operation on that list
      // it'll take n space and n time complexity
      public static void target2(Node node, ArrayList<Integer> list){
          if(node == null) return;
          target2(node.left, list);
          list.add(node.data);
          target2(node.right, list);
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
    
        int data = Integer.parseInt(br.readLine());
    
        Node root = construct(arr);
        // write your code here
        target(root, root, data);
        ArrayList<Integer> list = new ArrayList<>();
        target2(root, list);
        // now list conatins all nodes into tree in sorted order
        // create two index li and ri
        // li will be 0 ri will be list.size()-1
        // while li < ri
        // get li and ri from list into left and right
        // now add left and right if the sum is greater than data then increase ri
        // if sum is less than data then increase li
        // else both are same so print the pair and increase li and decrease by ri
        int li = 0;
        int ri = list.size() - 1;
        while(li < ri){
            int left = list.get(li);
            int right = list.get(ri);
            if(left + right > data) ri--;
            else if(left + right < data) li++;
            else{
                System.out.println(left + " " + right);
                li++;
                ri--;
            }
        }
      }
}

