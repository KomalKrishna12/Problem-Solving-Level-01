import java.util.Scanner;

public class Q5_Min_Cost_In_Maze_Traversal{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        //dp is 2d array which store min cost to reach destination
        int[][] dp = new int[n][m];
        for (int i = n - 1; i >= 0; i--) {
            for(int j = m - 1; j >= 0; j--){
                //when i == n-1 && j ==m-1 that means we are at destination we simply store arr[i][j] value
                //which is the cost 
                //when i == n - 1 that means we are at last row so we can traverse in horizontal direction
                //only so we simply add dp[i][j+1] to arr[i][j]
                //when j == m-1 that means we are at last column so we add dp[i+1][j] to arr[i][j]
                //when other case that means we can traverse horizontally or vertically based on min cost
                //so we use min function of Math class and add arr[i][j] into it that will be the min cost
                //to reach destination
                if(i == n-1 && j == m-1){
                    dp[i][j] = arr[i][j];
                }
                else if(i == n - 1){
                    dp[i][j] = arr[i][j] + dp[i][j+1];
                }
                else if(j == m - 1){
                    dp[i][j] = arr[i][j] + dp[i+1][j];
                }
                else{
                    dp[i][j] = arr[i][j] + Math.min(dp[i][j+1], dp[i+1][j]);
                }
            }
        }
        //at end print dp[0][0] that is the min cost to reach destination from source index
        System.out.println(dp[0][0]);
        scn.close();
    }
}