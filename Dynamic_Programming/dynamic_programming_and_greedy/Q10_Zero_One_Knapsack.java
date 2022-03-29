import java.util.Scanner;
// we have given a number n
// we have an array of values and weight
// we have given a capacity
// we have to fill a bag with cap given so it can make its value max
// so create a 2d array in row we have total n+1 rows first is non selecting weight
// from 0 to n all weight items
// in col we have total cap+1 column so (cap+1)th column will contain the max value which can possible
// by adding cap into bag from weight array
// for 0 capacity every row will be 0
// for 0th row we have 0 bcoz not selecting any item make max as 0
// now loop will start from 0th idx to end
// so if j is greater than equal to wt[i-1] w use i-1 bcoz in 2d dp array all array values at 1 to n
// if yes then calculate remaining cap 
// remcap = j - wt[i-1]
// now check if prev row with remcap col + value of curr weight (i-1) is greater than prev row value
// then store it into dp for i and j
// else store prev row value
public class Q10_Zero_One_Knapsack {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] val = new int[n];
        int[] weight = new int[n];
        for (int i = 0; i < val.length; i++) {
            val[i] = scn.nextInt();
        }
        for (int i = 0; i < weight.length; i++) {
            weight[i] = scn.nextInt();
        }
        int capacity = scn.nextInt();
        int[][] dp = new int[n+1][capacity+1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if(j >= weight[i-1]){
                    int rem = j - weight[i - 1];
                    if(dp[i-1][rem] + val[i-1] > dp[i-1][j]){
                        dp[i][j] = dp[i-1][rem] + val[i-1];
                    }
                    else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[n][capacity]);
        scn.close();
    }
}
