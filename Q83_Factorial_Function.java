import java.util.Scanner;

public class Q83_Factorial_Function {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println("Factorial of " + n + " : " + fact(n));
        scn.close();
    }
    public static int fact(int n) {
        int val = 1;
        for (int i = 2; i <= n; i++) {
            val *= i;
        }
        return val;
    }
}
