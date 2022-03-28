import java.util.Scanner;
// we have given n coins these n no of coins are infinite we can use them any no of times
// we have given a amount we have to count all the combinationa to collect target amount
// so we create a dp array with length amt + 1 each index contains total no of combination
// which can be made using n coins
// so in outside place coins arr so we fill dp array for 1st coin then 2nd and all so we get
// combinations not permuations
// inside it start loop from arr[i] suppose we have coin 5 so we can make target from 5 to end
// we cannot make 4 or less then 5 amount
// now check if we add coin 5 so is their any possibility that we hvae j - 5
// if yes then add that into dp 
// suppose j is 7 coin is 5
// so we are using coin 5 so check 2 is able to make any combination or not
// if yes then add that combination into dp[7] 
// steps :
//to apply dp three steps required
//1->storage and meaning
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
