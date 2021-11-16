import java.util.Scanner;
//when we can use a particular time multiple time then use single dimension array for dp
public class Q11_Unbounded_Knapsack {
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
        int cap = scn.nextInt();
        int[] dp = new int[cap+1];
        dp[0] = 0;
        //max of 0th item will always zero
        //firstly create an outside array from 1 to capacity
        //declare max with 0
        //inside loop will be for weight array
        //firstly check that eement of weight array is less then or equal to bag capacity so we
        //perform three statements
        //suppose bagC = 5
        //i = 0 is 2
        //weight[i] <= 5 --> 2 <= 5
        //remC = 5 - 2 = 3
        //remB = dp[3]  //assume that it is 30
        //value = 30 + val[i]   //assume value of weight 5 is 15
        //value = 30 + 15 = 45
        //45 > max so max will become 45
        //i = 1 is 3
        //weight[i] <= 5 --> 3 <=5
        //remC = 5 - 3 = 2
        //remB = dp[2] //assume is is 20
        //value = 20 + 10
        //30 < max so at last max value will store at dp[bagC] = max
        for (int bagC = 1; bagC < dp.length; bagC++) {
            int max = 0;
            for(int i = 0; i < weight.length; i++){
                if(weight[i] <= bagC){
                    int remC = bagC - weight[i];
                    int remB = dp[remC];
                    int value = remB + val[i];
                    if(value > max){
                        max = value;
                    }
                }
            }
            dp[bagC] = max;
        }
        System.out.println(dp[cap]);
        scn.close();
    }
}
