import java.util.Scanner;
// in this question we are required to find out min no of jumps to reach n
// for every jump their is 1 move only(1 jump, 2 jump or 3 jump)
// if we are at nth stair then no noeed to move so 0 move
// store dp[n] = 0
// create dp as Integer type so by default it contains null for all
// if arr[i] > 0 then create a min variable and store the min value from its jump
public class Q4_Climb_Stairs_With_Minimum_Moves {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        
        scn.close();
        System.out.println(solve(n, arr));
    }

    public static int solve(int n, int[] arr){
        Integer[] dp = new Integer[n + 1];
        dp[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            // if arr[i] == 0 that means no jumps can be possible
            if(arr[i] > 0){
                // min variable is used to store the min moves among all the moves
                // at end if min is changes that add min by adding 1 into it which is the one move to reach the min move
                int min = Integer.MAX_VALUE;
                for (int j = 1 ; j <= arr[i] && i + j < dp.length ; j++) {
                    if(dp[i+j] != null){
                        min = Math.min(min, dp[i+j]);
                    }
                }
                if(min != Integer.MAX_VALUE){
                    dp[i] = min + 1;
                }
            }
        }
        return dp[0];
    }
}
