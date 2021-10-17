import java.util.Scanner;

public class fibonacci {
        public static int fib(int n){
            if( n <= 1){
                return n;
            }
                return fib(n-1) + fib(n-2);
        }
    
    public static void main(String[] args) {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        for(int i = 0; i<n; i++){
            System.out.println(fib(i));
        }
        scn.close();
        }
}
