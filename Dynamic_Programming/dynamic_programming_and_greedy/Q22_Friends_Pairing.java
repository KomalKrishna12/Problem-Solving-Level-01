import java.util.Scanner;
//in the question it is given that we have n no of friends, we have to pair them up like then can stay single
//or pair up
//if n = 1 so their will be one way only so dp[1] = 1
//if n = 2 so their can be two way suppose 12 it can be pair up as 1-2 or 12 so dp[2] = 2
//for n = 3 we can calculate it as stay 1 as single and then pair with n-1 
//for single n becomes 2 so for n = 2 we have two ways
//and for pair up it can pair as 12 and 13 so again 12 and 13 have 2 ways to stay single or pair up
//at end we add them
//so for paring istead of counting for all pair we can just calculate ways for one pair and
//multple n-1 with the count because n can be pair with rest al that will be n-1
//so formula will be f(n) = f(n-1) + [f(n-2)]*(n-1)
public class Q22_Friends_Pairing {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i-1] + (i-1)*dp[i-2];
        }
        System.out.println(dp[n]);

        scn.close();
    }
}
