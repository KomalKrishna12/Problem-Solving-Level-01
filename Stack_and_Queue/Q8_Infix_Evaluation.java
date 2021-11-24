import java.util.Scanner;
import java.util.Stack;

public class Q8_Infix_Evaluation {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String exp = scn.next();
        scn.close();
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if(ch == '('){
                operators.push(ch);
            }
            else if(Character.isDigit(ch)){
                operands.push(ch - '0');
            }
            else if(ch == ')'){
                while(operators.peek() != '('){
                    int v2 = operands.peek();
                    int v1 = operands.peek();
                    char chr = operators.peek();
                    int val = operation(v1, v2, chr);
                    operands.push(val);
                }
                operators.pop();
            }
            else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                while(operators.size() > 0 && operators.peek() != '(' && 
                precedence(ch) <= precedence(operators.peek())){
                    int v2 = operands.peek();
                    int v1 = operands.peek();
                    char chr = operators.peek();
                    int val = operation(v1, v2, chr);
                    operands.push(val);
                }
                operators.push(ch);
            }
        }
        while(operators.size() > 0){
            int v2 = operands.peek();
            int v1 = operands.peek();
            char chr = operators.peek();
            int val = operation(v1, v2, chr);
            operands.push(val);
        }
        System.out.println(operands.peek());
    }

    public static int precedence(char ch) {
        if (ch == '+') {
            return 1;
        } else if (ch == '-') {
            return 1;
        } else if (ch == '*') {
            return 2;
        } else {
            return 2;
        }
    }

    public static int operation(int v1, int v2, char ch) {
        if (ch == '+') {
            return v1 + v2;
        } else if (ch == '-') {
            return v1 - v2;
        } else if (ch == '*') {
            return v1 * v2;
        } else {
            return v1 / v2;
        }
    }
}
