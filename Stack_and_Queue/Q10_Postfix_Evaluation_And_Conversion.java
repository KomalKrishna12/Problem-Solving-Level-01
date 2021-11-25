import java.util.Scanner;
import java.util.Stack;
//in this question we have given a postfix expression
//we have to solve the expression
//and print its into infix expression and prefix expression
//for eg : 
//postfix exp  : ab+
//infix exp   : (a+b)
//prefix exp : +ab
//so we create three stack one Integer stack to store value of expression
//and rest two for infix and postfix expression
//start loop from i = 0 to exp.length()
//if ch == any digit then simply push it into all three array
//if ch == '+' || '-' || '*' || '/' then calculate v1 and v2 and then val and then push into corresponding 
//stack.
//at end dislay all 
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
                value.push(ch - '0'); //converting char to int
                infix.push(ch + "");  //converting char to String
                prefix.push(ch + ""); //converting char to String
            }
            else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                //calculate value using operation function
                int v2 = value.pop();
                int v1 = value.pop();
                int val = operation(v1, v2, ch);
                value.push(val);

                //calculate string using infix concept : val1 opr val2
                String infv2 = infix.pop();
                String infv1 = infix.pop();
                String infv = "(" + infv1 + ch + infv2 +")";
                infix.push(infv);

                //calculate string using prefix concept : opr val1 val2 
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
