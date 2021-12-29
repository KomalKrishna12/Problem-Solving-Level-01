public class Q1_BST_Construct{
    public static class Node{
        int data;
        Node left, right;
        Node(int data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    public static Node construct(int[] arr, int low, int high){
        if(low > high) return null;
        int mid = (low + high)/2;
        int data = arr[mid];
        Node leftchild = construct(arr, low, mid - 1);
        Node rightchild = construct(arr, mid + 1, high);
        Node node = new Node(data, leftchild, rightchild);
        return node;
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
    public static void main(String[] args) {
        int[] arr = {12, 25, 37, 50, 62, 75, 87};
        Node root = construct(arr, 0, arr.length - 1);
        display(root);
    }
}