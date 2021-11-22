import java.util.Scanner;
import java.util.Stack;
//in this question we have given a expression contains brackets like - '(', '{', '['
//we have to check wheather the expression is in the right manner or not
//that means we have to check wheather the expression contains extra brackets or not
//for eg -:
//[(a + b) + {(c + d) * (e / f)}] = true bcoz all brackets closed no extra opening or closing brackets
//[(a + b) + {(c + d) * (e / f)]} = false becoz at end ']}' these are in wrong order correct order is '}]'
//to solve this we use stack
//we check character of string one by one
//if ch == '(' or ch == "{" or ch == '[' then push the char into stack
//else check the closing bracket
//if ch == ')' then we have to check wheather the peek of stack contain '(' or not
//if yes then pop the ch 
//if there is any other closing bracket like '{' or  '[' then return false becoz order is wrong
//if stack is empty then also return false bcoz that means expression contains extra closing brackets
//do this for all closing brackets
//at end check size of stack if stack is empty then return true otherwise false may be it contain extra
//opening brackets
public class Q3_Balanced_Brackets{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        scn.close();
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            }
            else if(ch == ')'){
                boolean val = handleOpenChar(st, '(');
                if(val == false){
                    System.out.println(val);
                    return;
                }
            }
            else if(ch == '}'){
                boolean val = handleOpenChar(st, '{');
                if(val == false){
                    System.out.println(val);
                    return;
                }
            }
            else if(ch == ']'){
                boolean val = handleOpenChar(st, '[');
                if(val == false){
                    System.out.println(val);
                    return;
                }
            }
        }
        if(st.size() != 0){
            System.out.println(false);
        }
        else{
            System.out.println(true);
        }
    }
    public static boolean handleOpenChar(Stack<Character> st, char ch) {
        if(st.size() == 0){
            return false;
        }
        else if(st.peek() != ch){
            return false;
        }
        else{
            st.pop();
            return true;
        }
    }
}