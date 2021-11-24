import java.util.Scanner;
import java.util.Stack;

public class Q9_Infix_Converstion {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String exp = scn.nextLine();
        scn.close();
        Stack<String> post = new Stack<>();
        Stack<String> pre = new Stack<>();
        Stack<Character> opr = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (ch == '(') {
                opr.push(ch);
            } else if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                post.push(ch + "");
                pre.push(ch + "");
            } else if (ch == ')') {
                while (opr.size() > 0 && opr.peek() != '(') {
                    char chr = opr.pop();

                    String postv2 = post.pop();
                    String postv1 = post.pop();
                    String postV = postv1 + postv2 + chr;
                    post.push(postV);

                    String prev2 = pre.pop();
                    String prev1 = pre.pop();
                    String preV = chr + prev1 + prev2;
                    pre.push(preV);
                }
                opr.pop();
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (opr.size() > 0 && opr.peek() != '(' && pre(ch) <= pre(opr.peek())) {

                    char chr = opr.pop();

                    String postv2 = post.pop();
                    String postv1 = post.pop();
                    String postV = postv1 + postv2 + chr;
                    post.push(postV);

                    String prev2 = pre.pop();
                    String prev1 = pre.pop();
                    String preV = chr + prev1 + prev2;
                    pre.push(preV);
                }
                opr.push(ch);
            }
        }

        while (opr.size() > 0) {
            char chr = opr.pop();

            String postv2 = post.pop();
            String postv1 = post.pop();
            String postV = postv1 + postv2 + chr;
            post.push(postV);

            String prev2 = pre.pop();
            String prev1 = pre.pop();
            String preV = chr + prev1 + prev2;
            pre.push(preV);
        }
        System.out.println(post.pop());
        System.out.println(pre.pop());

    }

    public static int pre(char ch) {
        if (ch == '+' || ch == '-') {
            return 1;
        } else if (ch == '*' || ch == '/') {
            return 2;
        } else {
            return 0;
        }
    }
}
