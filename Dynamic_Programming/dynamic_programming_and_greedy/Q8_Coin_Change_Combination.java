import java.util.Scanner;
//to apply dp three steps required
//1->storage and management
//2->direction identify
//3->solve the problem by full filling the array
public class Q8_Coin_Change_Combination {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int amt = scn.nextInt();
        int[] dp = new int[amt+1];
        //there is always a way to pay 0 that is 1 like we get 2^0 is 1
        dp[0] = 1;
        for(int i = 0; i < arr.length; i++){
            //first loop is for arr array because we want combination
            for(int j = arr[i]; j < dp.length; j++){
                //second loop is for dp
                dp[j] += dp[j - arr[i]];
                //here we will add dp[j-arr[i]] in dp[j] because we already have a way in dp[j-arr[i]]
            }
        }
        System.out.println(dp[amt]);
        //at end we display combination of the particular amount
        scn.close();
   }
}
