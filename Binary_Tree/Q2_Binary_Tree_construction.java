import java.util.Stack;
// In bInary Tree 0 or 1 or 2 children can be present
public class Q2_Binary_Tree_construction {
    public static class Node {
        int data;
        Node left, right;

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

    public static void construct(Integer[] arr) {
        // if state is 1 then create left node and insert
        // if state is 2 then create right node and insert
        // if state is 3 then pop from stack that means 2 childrens are completed
        Node root = new Node(arr[0], null, null);
        Pair rootPair = new Pair(root, 1);

        Stack<Pair> st = new Stack<>();
        st.push(rootPair);
        int idx = 0;

        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                idx++;
                if (arr[idx] != null) {
                    top.node.left = new Node(arr[idx], null, null);
                    st.push(new Pair(top.node.left, 1));
                } else {
                    top.node.left = null;
                }
                top.state++;
            } else if (top.state == 2) {
                idx++;
                if (arr[idx] != null) {
                    top.node.right = new Node(arr[idx], null, null);
                    st.push(new Pair(top.node.right, 1));
                } else {
                    top.node.right = null;
                }
                top.state++;
            } else {
                st.pop();
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87,
                null, null };
        construct(arr);
    }
}
