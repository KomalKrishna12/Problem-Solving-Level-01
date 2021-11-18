import java.util.Scanner;

public class Q18_Paint_House_Many_Colrs{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        int[][] arr = new int[n][k];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        int[][] dp = new int[n][k];
        //firstly we place cost for first row which will same as arr[0][j]
        for (int i = 0; i < k; i++) {
            dp[0][i] = arr[0][i];
        }
        //in second loop we craeted a variable min which we compare if every element of last row
        //if any mininum value find then we store that in min variable
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                int min = Integer.MAX_VALUE;
                for (int l = 0; l < dp[0].length; l++) {
                    if(j != l){
                        if(dp[i-1][l] < min){
                            min = dp[i-1][l];
                        }
                    }
                }
                dp[i][j] = arr[i][j] + min;
            }
        }
        //again here we are using same approach to find min in last column that will become our ans
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < dp[0].length; i++) {
            if(dp[n-1][i] < min){
                min = dp[n-1][i];
            }
        }
        System.out.println(min);
        scn.close();
        //in this approach we are using for - for - for that means complexity will become n^3 which is not 
        //good so in next approach will try to solve this problem by having n^2 time complexity
    }
}