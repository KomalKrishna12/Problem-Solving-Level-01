import java.util.Scanner;
// we have given n*m goldmine in which two walls one at col 0 and other at last col
// we have to stat from left(0th) and go to right(last) with collecting maximum gold
// so direction of small problem is at last bcoz from last col we reach destination wall easily
// so we traverse from last
// so we put column in outside for loop from end
// bcoz we want to put values row wise
// if we are at last col then simply put last arr[i][j] bcoz we are at destination wall
// if we are at 0th row then we have to option we can traverse at (i,j+1) and (i+1,j+1)
// if we are at last row we have options (i, j+1) ans (i-1, j+1)
// ans in rest rows we have three options (i-1,j+1), (i,j+1) and (i+1,j+1)
// compare all and go to max gold and add current gold 
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
        
        // now each box contains it's max gold collection to reach at last column
        // so traverse a loop on first col and check for every row and store max gold collection at first col
        int max = dp[0][0];
        for(int i = 1; i < n; i++){
            if(dp[i][0]>max){
                max=dp[i][0];
            }
        }
        System.out.println(max);
        scanner.close();
    }
}
