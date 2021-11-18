import java.util.Scanner;

public class Q23_Partition_Into_Subsets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        long result = getPartitionSubsets(n, k);
        System.out.println(result);
        sc.close();
    }

    public static long getPartitionSubsets(int n, int k) {
        long[][] dp = new long[k+1][n+1];

        if(n == 0 || k == 0 || n < k){
            return 0;
        }

        for (int team = 1; team < dp.length; team++) {
            for (int player = 1; player < dp[0].length; player++) {
                if(team == player){
                    dp[team][player] = 1;
                }
                else{
                    dp[team][player] = dp[team-1][player-1] + dp[team][player-1] * team;
                }
            }
        }

        return dp[k][n];
    }

}
