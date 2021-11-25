import java.util.Scanner;
import java.util.Stack;

public class Q11_Prefix_Evaluation_And_Conversion {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String exp = scn.nextLine();
        scn.close();

        Stack<Integer> value = new Stack<>();
        Stack<String> infix = new Stack<>();
        Stack<String> postfix = new Stack<>();

        for (int i = exp.length()-1; i >= 0; i--) {
            char ch = exp.charAt(i);
            if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                int v1 = value.pop();
                int v2 = value.pop();
                int v = operation(v1, v2, ch);
                value.push(v);

                String iv1 = infix.pop();
                String iv2 = infix.pop();
                String iv = "(" + iv1 + ch + iv2 +")";
                infix.push(iv);

                String pv1 = postfix.pop();
                String pv2 = postfix.pop();
                String pv = pv1 + pv2 + ch;
                postfix.push(pv);
            }
            else{
                value.push(ch-'0');
                infix.push(ch+"");
                postfix.push(ch+"");
            }
        }

        System.out.println(value.pop());
        System.out.println(infix.pop());
        System.out.println(postfix.pop());
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
