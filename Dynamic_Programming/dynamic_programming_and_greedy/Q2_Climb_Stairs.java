import java.util.Scanner;

public class Q2_Climb_Stairs {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(climbStairs(n, new int[n+1]));
        scn.close();
    }
    public static int climbStairs(int n, int[] qb) {
        if(n == 0){
            return 1;
        }
        if(n < 0){
            return 0;
        }
        if(qb[n] != 0){
            return qb[n];
        }
        int nm1 = climbStairs(n-1,qb);
        int nm2 = climbStairs(n-2,qb);
        int nm3 = climbStairs(n-3,qb);
        int cp = nm1 + nm2 + nm3;
        qb[n] = cp;
        return cp;
    }
}
