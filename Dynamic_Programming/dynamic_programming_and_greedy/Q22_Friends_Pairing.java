import java.util.Scanner;

public class Q22_Friends_Pairing {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i-1] + (n-1)*dp[i-2];
        }
        System.out.println(dp[n]);

        scn.close();
    }
}
