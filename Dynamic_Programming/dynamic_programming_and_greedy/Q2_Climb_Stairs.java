import java.util.Scanner;

public class Q2_Climb_Stairs {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        // System.out.println(climbStairs(n, new int[n+1]));
        int cp = countPathTab(n);
        System.out.println(cp);
        scn.close();
    }
    //this is the method of dynamic proramming
    //this is memoization method in which we store values in array of that particular index and before using
    //recursion firstly we check that index in array is that greater than 0 or not if yes than return value
    public static int climbStairs(int n, int[] qb) {
        if(n == 0){
            return 1;
        }
        if(n < 0){
            return 0;
        }
        if(qb[n] != 0){
            return qb[n];
        }
        int nm1 = climbStairs(n-1,qb);
        int nm2 = climbStairs(n-2,qb);
        int nm3 = climbStairs(n-3,qb);
        int cp = nm1 + nm2 + nm3;
        qb[n] = cp;
        return cp;
    }
    // tabulation approach steps :
    // step 1 : storage and meaning
    // create an array of size (n+1)
    // so arr[n] store ans for n
    // every nth index store the no of ways to climb from n to 0
    // step 2 : check the flow of problem
    // check where is small problem and where is large problem
    // so at arr[0] we have 1 way and at arr[n] = arr[n-1] + arr[n-2] + arr[n-3] so at n larger problem
    // direction if left to right
    // step 3 : fill the array
    // for arr[0] only 1 ways so store it
    // for arr[1] there is only arr[0] ways and for arr[2] = arr[1] + arr[0]
    // so in loop i will be from 3 to n(including)
    // so arr[n] = arr[n-1] + arr[n-2] + arr[n-3]
    //second method of dynamic programming is tabulation in which we use array without using recursion
    public static int countPathTab(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            if(i == 1){
                dp[i] = dp[i-1];
            }
            else if(i == 2){
                dp[i] = dp[i-1] + dp[i-2];
            }
            else{
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
            }
        }
        return dp[n];
    }
}
