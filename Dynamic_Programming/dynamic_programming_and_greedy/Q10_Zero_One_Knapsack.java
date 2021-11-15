import java.util.Scanner;

public class Q10_Zero_One_Knapsack {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] val = new int[n];
        int[] weight = new int[n];
        for (int i = 0; i < val.length; i++) {
            val[i] = scn.nextInt();
        }
        for (int i = 0; i < weight.length; i++) {
            weight[i] = scn.nextInt();
        }
        int capacity = scn.nextInt();
        int[][] dp = new int[n+1][capacity+1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if(j >= weight[i-1]){
                    int rem = j - weight[i - 1];
                    if(dp[i-1][rem] + val[i-1] > dp[i-1][j]){
                        dp[i][j] = dp[i-1][rem] + val[i-1];
                    }
                    else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[n][capacity]);
        scn.close();
    }
}
