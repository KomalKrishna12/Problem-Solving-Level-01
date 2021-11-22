import java.util.Scanner;
import java.util.Stack;

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