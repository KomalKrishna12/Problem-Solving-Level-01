import java.util.Scanner;

public class Q29_Buy_And_Sell_Stocks_K_Transactions_Allowed {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        int[][] dp = new int[k+1][n];

        for (int t = 1; t <= k; t++) {
            for (int d = 1; d < n; d++) {
                int max = dp[t][d-1];
                for (int i = 0; i < d; i++) {
                    int profitTilltm1 = arr[d] - arr[i];
                    if(profitTilltm1 + dp[t-1][i] > max){
                        max = profitTilltm1 + dp[t-1][i];
                    }
                }
                dp[t][d] = max;
            }
        }
        System.out.println(dp[k][n-1]);

        scn.close();
    }
}
