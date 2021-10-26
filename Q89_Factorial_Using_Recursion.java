import java.util.Scanner;

public class Q89_Factorial_Using_Recursion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(factorial(n));
        scanner.close();
    }
    public static int factorial(int n) {
        if(n==1){
            return 1;
        }
        return n * factorial(n - 1);
    }
}
