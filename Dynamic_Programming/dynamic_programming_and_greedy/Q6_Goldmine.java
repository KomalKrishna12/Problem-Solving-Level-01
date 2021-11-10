import java.util.Scanner;

public class Q6_Goldmine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        int[][] dp = new int[n][m];
        for (int j = m-1; j >= 0; j--) {
            for (int i = n-1; i >= 0; i--) {
                if(j == m-1){
                    dp[i][j] = arr[i][j];
                }
                else if(i == 0){
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j+1], dp[i+1][j+1]);
                }
                else if(i == n-1){
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j+1], dp[i-1][j+1]);
                }
                else{
                    dp[i][j] = arr[i][j] + Math.max(dp[i+1][j+1], Math.max(dp[i][j+1], dp[i-1][j+1]));
                }
            }
        }
        int max = dp[0][0];
        for(int i = 1; i < n-1; i++){
            if(dp[i][0]>max){
                max=dp[i][0];
            }
        }
        System.out.println(max);
        scanner.close();
    }
}
