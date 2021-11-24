import java.util.Scanner;
import java.util.Stack;
//In this question we have given an infix expression
//we have to convert into into postfix expression and prefix expression
//for eg :
// infix : a + b
// postfix : ab+ (v1)(v2)(opr)
// prefix : +ab (opr)(v1)(v2)
//so to convert this we use infix evaluation
//create post and pre two string stack
//one opr integer stack
//when ch == '(' push ch into opr stack
//when ch == ['0','9'] || ['a','z'] || ['A','Z'] push into both post and pre stack
//when ch == ')' calculate postfix and prefix untill opr.size()>0 && opr.peek()!='('
//when ch == '+' || '-' || '*' || '/' calculate postfix and prefix till opr.size()>0 && opr.peek()!='('
//&& pre(ch) <= pre(opr.peek())
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
