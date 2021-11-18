import java.util.Scanner;

public class Q21_Tiling_With_M_by_1_Tiles {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        int[] dp = new int[n+1];

        for (int i = 1; i <= n; i++) {
            if(i < m){
                dp[i] = 1;
            }
            else if(i == m){
                dp[i] = 2;
            }
            else{
                dp[i] = dp[i-1] + dp[i-m];
            }
        }

        System.out.println(dp[n]);
        scn.close();
    }
}
