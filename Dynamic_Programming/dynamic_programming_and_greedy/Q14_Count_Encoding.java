import java.util.Scanner;

public class Q14_Count_Encoding{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int[] dp = new int[str.length()];
        //when length is one that means only one str can be encoded
        
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            if(str.charAt(i-1) == '0' && str.charAt(i) == '0'){
                //when i-1 and i both are 0 that means dp[i] = 0
                dp[i] = 0;
            }
            else if(str.charAt(i-1) == '0' && str.charAt(i) != '0'){
                //suppose 2301 so there can be 230 - 1 this is possible so dp[i] = dp[i-1]
                // or 23 -- 01 this is not possible
                dp[i] = dp[i-1];
            }
            else if(str.charAt(i-1) != '0' && str.charAt(i) == '0'){
                //2310-- 231 - 0 this is not possible
                //23 - 10 this is possible so dp[i] = dp[i-2]
                if(str.charAt(i-1) <= 2){
                    dp[i] = (i>=2?dp[i-2]:1);
                }
                else{
                    dp[i] = 0;
                }
            }
            else{
                //2311
                //231-1 dp[i-1]
                //23-11 dp[i-2]
                //dp[i] = dp[i-1] + dp[i-2]
                //this substr will check that the substring is less than equal to 26
                if(Integer.parseInt(str.substring(i-1, i+1))<=26){
                    dp[i] = dp[i-1] + (i>=2?dp[i-2]:1);
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