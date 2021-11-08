import java.util.Scanner;

public class Q1_Fibonacci_dp{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        // int fibn = fib(n);
        // System.out.println(fibn);
        int fibn = fibmemoized(n, new int[n + 1]);
        System.out.println(fibn);
        scn.close();
    }
    public static int fib(int n) {
        if(n == 0 || n == 1){
            return n;
        }
        int fnm1 = fib(n-1);
        int fnm2 = fib(n-2);
        int fn = fnm1 + fnm2;
        return fn;
    }
    //in this function we store the fibonacci value of a particular n into question bank
    public static int fibmemoized(int n, int[] qb) {
        //0,1,1,2,3,5,8,13,21,34,55........
        //if n == 0 or n == 1 then return n beacause for 0th and 1st element of fibonacci series is 0, 1
        if(n == 0 || n == 1){
            return n;
        }
        //here we check is the fibonacci of particular n is available on the question bank or not
        if(qb[n] != 0){
            return qb[n];
        }
        //here first we calculate fibonacci of (n-1) using recursion then calculate for (n-2) and then add
        //both values, store that value in question bank array for the particular n
        //and return that value
        int fbnm1 = fibmemoized(n - 1, qb);
        int fbnm2 = fibmemoized(n - 2, qb);
        int fbn = fbnm1 + fbnm2;
        qb[n] = fbn;
        return fbn;
    }
}