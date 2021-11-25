import java.util.Scanner;
import java.util.Stack;
//in this question we have given a prefix expression
//we have to solve the expression
//and print its into infix expression and postfix expression
//for eg : 
//prefix exp  : +ab
//infix exp   : (a+b)
//postfix exp : ab+
//so we create three stack one Integer stack to store value of expression
//and rest two for infix and postfix expression
//start loop from i = exp.length()-1 to 0
//because in prefix exp opr are presend at first space so we evalaute from end and here pop v1 first
//because we are reading string from end 
//for eg exp : -ab so we push b then a so when we pop we get a that is our first value so we consider it as v1
//if ch == any digit then simply push it into all three array
//if ch == '+' || '-' || '*' || '/' then calculate v1 and v2 and then val and then push into corresponding 
//stack.
//at end dislay all 
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
                //calculate value using operation function
                int v1 = value.pop();
                int v2 = value.pop();
                int v = operation(v1, v2, ch);
                value.push(v);

                //calculate string using infix concept : val1 opr val2
                String iv1 = infix.pop();
                String iv2 = infix.pop();
                String iv = "(" + iv1 + ch + iv2 +")";
                infix.push(iv);

                //calculate string using postfix concept : val1 val2 opr
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
