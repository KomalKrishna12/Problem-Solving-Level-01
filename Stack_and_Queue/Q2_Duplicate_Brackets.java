import java.util.Scanner;
import java.util.Stack;
//in this question we have to check wheather the given exprression is true or not in terms of duplicasy 
//and extra brackets
//for eg :- 
// ((a+b)+(c+d)) - false becoz no duplicasy
//   a+b+((c+d)) - true becoz there is duplicasy (c+d) is fine but ((c+d)) contains extra brackets
//so we use stack to solve this
//firstly check all charcters from string using charAt(i) function
//if ch == ')' that means we want to check duplicasy so if peek() is '(' that means this is extra bracket
//so print "true" and return
//if peek() != '(' than we pop stack until we get '(' at last pop again to remove last bracket
//if ch != ')' then push charcters into the stack
//at end print "false" that means no duplicasy
public class Q2_Duplicate_Brackets{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        scn.close();

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == ')'){
                if(stack.peek() == '('){
                    System.out.println(true);
                    return;
                }
                else{
                    while(stack.peek() != '('){
                        stack.pop();
                    }
                    stack.pop();
                }
            }
            else{
                stack.push(ch);
            }
        }
        System.out.println(false);
        
    }
}