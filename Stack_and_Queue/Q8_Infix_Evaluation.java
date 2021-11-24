import java.util.Scanner;
import java.util.Stack;
//infix expression is a wxpression which human can understand
//we have given an expression we have to solve them
//we can use 4 operator only : '+', '-', '*', '/'
//we have given single digit no
//'*' and '/' having same precedence
//'+' and '-' having same precedence
//suppose '*' and '/' are together then solve from left to right
//for eg : 2 + 6 * 4 / 8 - 3
//   sol : 2 + 24 / 8 - 3
//       : 2 + 3 - 3
//       : 5 - 3
//       : 2
//so we use stack to solve this expression
//create two array operator and operand
//operand will store Integer like digit
//operator will store charcters like operator
//start loop from i -> 0 to exp.length()
//get char by char using exp.charAt(i)
//if char is '(' push in operator stack
//if char is digit push in operand stack
//if char is ')' then solve it till we get ')' at peek of operator stack
//to solve first pop v2 from operand array then v1 becoz v1 push before v2 
//then pop operator then calculate and store value into operand stack and at end pop '('
//if char == '+' || '-' || '*' || '/'
//solve then operand and operator array if operator stack contain any higher precedence operator or equal
//precedence operator also
//after loop ended there is chance of having some data in stack so solve stack till operator stack 
//become empty and at end display operand stack that contain the ans of expressin 
public class Q8_Infix_Evaluation {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String exp = scn.nextLine();
        scn.close();
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if(ch == '('){
                operators.push(ch);
            }
            else if(Character.isDigit(ch)){
                operands.push(ch - '0');//converting char into int ascii of '0' is 43 suppose ch = '5'
                //its ascii is 48 so digit will be 48 - 43 = 5
            }
            else if(ch == ')'){
                while(operators.size() > 0 && operators.peek() != '('){
                    int v2 = operands.pop();
                    int v1 = operands.pop();
                    char chr = operators.pop();
                    int val = operation(v1, v2, chr);
                    operands.push(val);
                }
                operators.pop();
            }
            else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                while(operators.size() > 0 && operators.peek() != '(' && 
                precedence(ch) <= precedence(operators.peek())){
                    int v2 = operands.pop();
                    int v1 = operands.pop();
                    char chr = operators.pop();
                    int val = operation(v1, v2, chr);
                    operands.push(val);
                }
                operators.push(ch);
            }
        }
        while(operators.size() > 0){
            int v2 = operands.pop();
            int v1 = operands.pop();
            char chr = operators.pop();
            int val = operation(v1, v2, chr);
            operands.push(val);
        }
        System.out.println(operands.pop());
    }

    //here we can check the precedence of operator
    //'+' and '-' having same precedence but having less precedence than '*' and '/'
    //'*' and '/' having same precedence
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

    //here we can calculate the expression for v1, v2 and operator and return the calculated value
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
