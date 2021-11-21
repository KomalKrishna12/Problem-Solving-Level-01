import java.util.Scanner;

public class Q29_Buy_And_Sell_Stocks_K_Transactions_Allowed_Second_Aproach {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        int[][] dp = new int[k+1][n];
        for (int t = 1; t < dp.length; t++) {
            int max = Integer.MIN_VALUE;
            for (int d = 1; d < dp.length; d++) {
                if(dp[t-1][d-1] - arr[d-1] > max){
                    max = dp[t-1][d-1] - arr[d-1];
                }
                if(max + arr[d] > dp[t][d-1]){
                    dp[t][d] = max + arr[d];
                }
                else{
                    dp[t][d] = dp[t][d-1];
                }
            }
        }
        System.out.println(dp[k][n-1]);
        scn.close();
    }   
}
