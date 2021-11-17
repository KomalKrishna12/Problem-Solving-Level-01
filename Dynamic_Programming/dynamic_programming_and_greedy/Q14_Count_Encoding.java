import java.util.Scanner;

public class Q14_Count_Encoding{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int[] dp = new int[str.length()];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            if(str.charAt(i-1) == '0' && str.charAt(i) == '0'){
                dp[i] = 0;
            }
            else if(str.charAt(i-1) == '0' && str.charAt(i) != '0'){
                dp[i] = dp[i-1];
            }
            else if(str.charAt(i-1) != '0' && str.charAt(i) == '0'){
                if(str.charAt(i-1) <= 2){
                    dp[i] = dp[i-2];
                }
                else{
                    dp[i] = 0;
                }
            }
            else{
                if(str.charAt(i-1) <= 2){
                    dp[i] = dp[i-1] + dp[i-2];
                }
                else{
                    dp[i] = dp[i-1];
                }
            }
        }
        System.out.println(dp[str.length()-1]);
        scn.close();
    }
}