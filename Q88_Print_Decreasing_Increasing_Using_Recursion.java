import java.util.Scanner;

public class Q88_Print_Decreasing_Increasing_Using_Recursion {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printDecreasingIncreasing(n);
        scn.close();
    }
    public static void printDecreasingIncreasing(int n) {
        if(n == 0){
            return;
        }
        System.out.println(n);
        printDecreasingIncreasing(n - 1);
        System.out.println(n);
    }
}
