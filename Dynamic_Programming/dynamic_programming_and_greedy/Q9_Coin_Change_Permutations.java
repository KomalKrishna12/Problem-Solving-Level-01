import java.util.Scanner;
// this is similar question like coin change combination but here we can print arrangements also
// so in outer loop we place dp and in inner we place coins arr so for ith row
// we try to calculate total arrangement which is possible to make i coins
public class Q9_Coin_Change_Permutations {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int amt = scn.nextInt();
        int[] dp = new int[amt+1];
        dp[0] = 1;
        for(int i = 1; i < dp.length; i++){
            for (int j = 0; j < arr.length; j++) {
                // if jth coin is less than equal to target i then only we can use coin of j
                // if i = 7 and coin is 8 so we cannot make tagrget 7 using coin 8
                if(arr[j] <= i){
                    dp[i] += dp[i - arr[j]];
                }
            }
        }
        // for (int i = 0; i < dp.length; i++) {
        //     for (int coin : arr) {
        //         if(coin <= i){
        //             int remCoin = i - coin;
        //             dp[i] += dp[remCoin];
        //         }
        //     }
        // }

        System.out.println(dp[amt]);
        scn.close();
    }
}
