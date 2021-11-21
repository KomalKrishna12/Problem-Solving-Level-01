import java.util.Stack;

public class Q1_Stack_Basic_Functions{
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        System.out.println(stack + " -> " + stack.peek() + " -> " + stack.size());
        stack.push(20);
        System.out.println(stack + " -> " + stack.peek() + " -> " + stack.size());
        stack.push(30);
        System.out.println(stack + " -> " + stack.peek() + " -> " + stack.size());
        stack.pop();
        System.out.println(stack + " -> " + stack.peek() + " -> " + stack.size());
    }
}