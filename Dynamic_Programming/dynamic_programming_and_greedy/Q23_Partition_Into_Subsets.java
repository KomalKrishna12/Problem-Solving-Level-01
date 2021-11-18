import java.util.Scanner;

public class Q23_Partition_Into_Subsets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        long result = getPartitionSubsets(n, k);
        System.out.println(result);
        //we are using long because may be we can take long type constraints
        sc.close();
    }

    public static long getPartitionSubsets(int n, int k) {
        long[][] dp = new long[k+1][n+1];

        //if players are zero then there will be zero ways
        //if teams are zero then also there will be zero ways
        //if team is more than player then also it is not possible so we return zero
        if(n == 0 || k == 0 || n < k){
            return 0;
        }

        //we start loop for dp in which row denotes teams and column denotes players
        //when no of player and teams are equal then there will be one way only
        //for eq n is 3(124) and k = 3 both n 7 k are samw so one only way will be 1-2-4
        //when team is less than player then we use concept of recursion
        //firstly we calculate ways for same team and player-1 there are same team so we have 
        //ways of player-1 into teams then we calculate for player-1 and team-1 then to
        //create team we simply add 1 so ways equal to ways of player-1
        //suppose n=3(123) and k =2
        //firstly calculate for n=2(12) and k=2 here we are taking for same team
        //so ways are 1-2 only here n and k are same so ways will be 1 and for k=2 
        //ways become 13-2 and 1-23 which is 2*1=2
        //secondly we take n=2(12) and k=1 here we simply add 3 in ways of 12 beacuse
        //1 team is created we want to create second so simply put it
        //total will be 2+1=3
        //(123,2) = (12,2)*2 + (12,1) = 1*2 + 1 = 2 + 1 = 3
        for (int team = 1; team < dp.length; team++) {
            for (int player = 1; player < dp[0].length; player++) {
                if(team == player){
                    dp[team][player] = 1;
                }
                else{
                    dp[team][player] = dp[team-1][player-1] + dp[team][player-1] * team;
                }
            }
        }

        return dp[k][n];
    }

}
