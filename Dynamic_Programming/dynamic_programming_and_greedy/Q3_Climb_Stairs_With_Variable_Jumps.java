import java.util.Scanner;
// we have given n stairs, we are at 0th stair 
// for all stairs their is some jumps which stored in arr
// so that particular stair can jump that much
// so our dp arr will be of n + 1 and direction of problem is right to left
// from nth stair to go to nth stair we have only 1 jump so store 1 at dp[n]
// now create a for loop from n-1 to 0
// create a inner for loop from 1 to arr[i] if i+j is less then dp.length then add dp[i+j] into dp[i]
// at end print dp[0] that is our total no of paths to climb n
public class Q3_Climb_Stairs_With_Variable_Jumps {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }

        int[] dp = new int[n+1];
        dp[n] = 1;

        for (int i = n-1; i >= 0; i--) {
            for (int j = 1; j <= arr[i] && i + j < dp.length; j++) {
                dp[i] += dp[i+j];
            }
        }

        System.out.println(dp[0]);
        scn.close();

    }   
}
