import java.util.Scanner;
//we have 2*n size floor and we have unlimited 2*1 tiles
//we want to set these 2*1 tiles in 2*n floor
//here we are using concept of recursion
//if we have 2*1 size floor than only 1 tile can be set so we store dp[1] = 1
//if we have 2*2 size floor than we have 2 ways either we can place both files horizontally or
//vertically so we store dp[2] = 2
//for n = 3 if we set first horizonatlly then rest will 2 size file for which 2 ways
//if we set first vertically then for next only one way left that is place second file vertically only 
//and rest tiles size 2 for which ways are 2 so total will be 2*1
//by both the ways total become = 2 + 2 that is the way we can 
//take a loop and using dp[1] and dp[2] we can solve for n size floor 
public class Q20_Tiling_With_2_by_1_Tiles {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println(dp[n]);

        scn.close();
    }
}
