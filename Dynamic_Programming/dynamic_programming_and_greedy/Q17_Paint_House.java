import java.util.Scanner;

public class Q17_Paint_House {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] arr = new int[n][3];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        int[][] dp = new int[n][3];
        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][0];
            dp[i][1] = Math.min(dp[i-1][2], dp[i-1][0]) + arr[i][1];
            dp[i][2] = Math.min(dp[i-1][1], dp[i-1][0]) + arr[i][2];
        }
        int ans = Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2]));
        System.out.println(ans);
        scn.close();
    }
}
