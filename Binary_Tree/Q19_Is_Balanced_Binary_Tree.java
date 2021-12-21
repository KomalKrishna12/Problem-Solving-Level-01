import java.io.*;
import java.util.*;

public class Q19_Is_Balanced_Binary_Tree {
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

    // Balanced Tree property : absolute of (height of left tree - height of right tree) <= 1
    // if gap is less then equal to 1 
    // if all nodes of tree is following this then that tree will be balanced
    // we can solve this using two method
    // 1 : travel and calculate method
    // in this method we return height and calculate isBal
    // 2 : using pair class
    // in this we create a pair class having two data isbal(boolena) and height(int)
    // for each node calculate its height and isbal
    // if left node is true and right node is true and gap of both height is less then equal to 1 then it'll
    // be a balanced tree 

    // travel and calculate approach
    public static boolean isBal = true;

    public static int isBalanced(Node node) {
        if (node == null)
            return 0;
        int lh = isBalanced(node.left);
        int rh = isBalanced(node.right);
        int gap = Math.abs(lh - rh);
        if (gap > 1)
            isBal = false;
        int th = Math.max(lh, rh) + 1;
        return th;
    }

    // class pair approach
    static class IsBal{
        boolean isBal;
        int height;
    }

    public static IsBal isBalanc(Node node) {
        if(node == null){
            IsBal bp = new IsBal();
            bp.height = 0;
            bp.isBal = true;
            return bp;
        }
        IsBal lh = isBalanc(node.left);
        IsBal rh = isBalanc(node.right);
        IsBal mp = new IsBal();
        mp.height = Math.max(lh.height, rh.height) + 1;
        mp.isBal = Math.abs(lh.height - rh.height) <= 1 && lh.isBal && rh.isBal;
        return mp;
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
        // travel and solve
        // isBalanced(root);
        // System.out.println(isBal);

        // class pair method
        IsBal bal = isBalanc(root);
        System.out.println(bal.isBal);
    }
}
