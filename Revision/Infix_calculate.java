import java.util.Scanner;
import java.util.Stack;

public class Infix_calculate {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int val = calculate(str);
        System.out.println(val);
        scn.close();
    }

    public static int calculate(String s) {
        Stack<Integer>
    }

    public static int precedence(char ch) {
        if(ch == '+' || ch == '-') return 1;
        else return 2;
    }

    public static int val(int v1, int v2, char ch) {
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
