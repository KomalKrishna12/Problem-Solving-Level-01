import java.util.ArrayList;
import java.util.Stack;

public class Q1_Generic_Tree_Constructor{

    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }
    public static void display(Node node) {
        // firstly it'll display root with children
        // then using recursion display children
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
    public static void main(String[] args) {
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1,
                     40, 100, -1, -1, -1};
        Node root = null;
        Stack<Node> st = new Stack<>();
        // if arr[i] is -1 then pop the stack
        // else create a node set its data as arr[i]
        // now check the size of stack
        // if stack is empty that means we're inserting first node so mark it as node and insert into stack
        // is stack is not empty that the newly created node will be the child of peek() node of stack
        // and add into stack
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == -1){
                st.pop();
            }
            else{
                Node t = new Node();
                t.data = arr[i];
                if(st.size() > 0){
                    st.peek().children.add(t);
                }
                else{
                    root = t;
                }
                st.push(t);
            }
        }
        display(root);
    }
}