import java.util.Scanner;

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
