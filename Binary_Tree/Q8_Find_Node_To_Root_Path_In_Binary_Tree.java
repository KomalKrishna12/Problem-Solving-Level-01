import java.util.*;
import java.io.*;

public class Q8_Find_Node_To_Root_Path_In_Binary_Tree {
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

    public static boolean find(Node node, int data) {
        // this includes 5 step
        // step 1 : if node is null then return false
        // step 2 : if node.data == data then return true
        // step 3 : call find using recursion for node.left if that return true then return true
        // step 4 : repeat step 3 for node.right
        // step 5 : return false because node is not at node or left or right child
        if (node == null)
            return false;
        if (node.data == data) {
            return true;
        }
        boolean findinleftchild = find(node.left, data);
        if (findinleftchild == true) {
            return true;
        }
        boolean findinrightchild = find(node.right, data);
        if (findinrightchild == true) {
            return true;
        }
        return false;
    }

    public static ArrayList<Integer> nodeToRootPath(Node node, int data) {
        if(node == null) return new ArrayList<>();

        if(node.data == data){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(node.data);
            return list;
        }

        ArrayList<Integer> leftlist = nodeToRootPath(node.left, data);
        if(leftlist.size() > 0){
            leftlist.add(node.data);
            return leftlist;
        }

        ArrayList<Integer> rightlist = nodeToRootPath(node.right, data);
        if(rightlist.size() > 0){
            rightlist.add(node.data);
            return rightlist;
        }

        return new ArrayList<>();
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
        boolean found = find(root, data);
        System.out.println(found);

        ArrayList<Integer> path = nodeToRootPath(root, data);
        System.out.println(path);
    }
}
