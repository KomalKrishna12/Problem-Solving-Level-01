import java.util.Scanner;
// we have given an integer n and given n numbers
// we have given an integer value target
// we're reuired to check is there any subset is available for the arr of size n which can sum 
// their elements and equals to target

// create a 2d array which contain n+1 rows from 1 to n it contains all arr elements
// at 0th index it contain not used like any no is not used then check it
/// column will be target + 1 so we can find out subset for target

// so our arr start from idx 1 so whenever we want to get arr value call using i - 1
// now for i = 0 and j = 0, to make 0 sum we have one option so mark it true
// now for i = 0 now their is no option to make target sum j bcoz at i = 0 we are using for not
// adding any element for empty subset
// for j = 0 now we want to check for creating 0 target so yes in every j = 0 every element can make 0 target
// so mark it true 
// so handle these cases inside the loop
// now for dp[i][j] we have two options
// first : check that if we are not using arr[i-1] then is the previous row is able to make jth sum
// if yes then mark it true no need to check second option
// second : now we want to use arr[i-1] element so we can use from value less than equal to j
// suppose value is 3 and j = 2 so we cannot make target 2 using element 3
// so use this condition if(arr[i-1] <= j) then check dp[i-1][j-val] means in prev row 
// is the jth subset is creating or not if yes then mark it yes
// at end return dp[n][tar] which means using these n elements subset we can make tar or not
// if that box is true then true else false
public class Q7_Target_Sum_Subset_DP{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int tar = scn.nextInt();
        boolean[][] dp = new boolean[n+1][tar+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if(i==0 && j==0){
                    dp[i][j] = true;
                }
                else if(i==0){
                    dp[i][j] = false;
                }
                else if(j==0){
                    dp[i][j] = true;
                }
                else{
                    if(dp[i-1][j] == true){
                        dp[i][j] = true;
                    }
                    else{
                        int val = arr[i-1];
                        if(j>=val){
                            if(dp[i-1][j-val]==true){
                                dp[i][j] = true;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(dp[arr.length][tar]);
        scn.close();
    }
}