import java.util.Scanner;
//In this ques we have n days
//k transactions
//we create a dp with row equal to k+1 and column equal to n
//loop will start with t = 1 that means we can calculate max profit for atleast one transaction
//and d = 1 beacause at d=0 only one stock is there so we buy ans sell same day so profit will become zero
//to caluclate max profit 
//create variable max store value at dp[t][d-1] that means profit where transaction completed in prev day
//now compare that max with each dp[t-1][pd] pd-(0,d) and add particular share price
//and replace max with these values
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
