import java.util.Scanner;
//In this question we have n*m size floor and m*1 infinite tiles
//till i less than m we can arrange the m*1 tile in one way that it horizontal
//when i and m equal we can arrange the m*1 tile in two ways one horizonatlly or vertically
//else we can arrange using recursion we arrange first tile in vertical then rest will be calculate
//from dp[i-1] and if we arrange first tile horizontally then we can arrange in dp[n-m]
//at end add both
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
