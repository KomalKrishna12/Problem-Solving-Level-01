import java.util.Scanner;
import java.util.Stack;

public class Q10_Postfix_Evaluation_And_Conversion {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String exp = scn.nextLine();
        scn.close();

        Stack<Integer> value = new Stack<>();
        Stack<String> infix = new Stack<>();
        Stack<String> prefix = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if(Character.isDigit(ch)){
                value.push(ch - '0');
                infix.push(ch + "");
                prefix.push(ch + "");
            }
            else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                int v2 = value.pop();
                int v1 = value.pop();
                int val = operation(v1, v2, ch);
                value.push(val);

                String infv2 = infix.pop();
                String infv1 = infix.pop();
                String infv = "(" + infv1 + ch + infv2 +")";
                infix.push(infv);

                String prev2 = prefix.pop();
                String prev1 = prefix.pop();
                String prev = ch + prev1 + prev2;
                prefix.push(prev);
            }
        }
        System.out.println(value.pop());
        System.out.println(infix.pop());
        System.out.println(prefix.pop());
    }

    public static int operation(int v1, int v2, char ch) {
        if (ch == '+')
            return v1 + v2;
        else if (ch == '-')
            return v1 - v2;
        else if (ch == '*')
            return v1 * v2;
        else
            return v1 / v2;
    }
}
