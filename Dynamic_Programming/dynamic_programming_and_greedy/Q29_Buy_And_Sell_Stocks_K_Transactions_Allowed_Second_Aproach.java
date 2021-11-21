import java.util.Scanner;
//this is the second approach to calculate max profit for k transaction
//in last approach we used three for loops so time complexity will become n^3 that is not good code
//so in this qpproach we calculate max profit in two for loops
//we craete a max variable intialize it with Integer.MIN_VALUE then calculate dp[t-1][d-1] - arr[d-1]
//compare this with max if this is greater than update max so using this max we can caluculate
//max value till t-1 and d-1 which we did using third loop in last approach so now we simply add arr[d]
//into max and compare it with dp[t][d-1] if greater than set dp[t][d] with max + arr[d] otherwise set 
//last index value that is dp[t][d-1] 
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
