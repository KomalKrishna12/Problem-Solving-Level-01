import java.util.Scanner;

public class Q86_Print_Decreasing_Using_Recursion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        printDecreasing(n);
        scanner.close();
    }
    public static void printDecreasing(int n) {
        if(n==0){
            return;
        }
        System.out.println(n);
        printDecreasing(n-1);
    }
}
