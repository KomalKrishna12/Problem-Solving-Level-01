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
                //when we are last col that means we are at final destination so we copy arr[i][j] into dp
                if(j == m-1){
                    dp[i][j] = arr[i][j];
                }
                //when we are at first row add arr[i][j] into max value of same row,j+1 and row+1,j+1
                else if(i == 0){
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j+1], dp[i+1][j+1]);
                }
                else if(i == n-1){
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j+1], dp[i-1][j+1]);
                }
                else{
                    //here we are comparing three value (i-1,j+1) (i,j+1) (i+1,j+1) and add max value 
                    //with arr[i][j]
                    dp[i][j] = arr[i][j] + Math.max(dp[i+1][j+1], Math.max(dp[i][j+1], dp[i-1][j+1]));
                }
            }
        }
        //set max at first row and col 0 then compare from second row when any greater elemet found set
        //max to that element
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
