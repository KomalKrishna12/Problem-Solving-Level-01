import java.util.Scanner;
//In this approach we find least and second list value from last row
//if we are calculating cost for same column in which least found then we add second list with price
//which is store is arr[i][j]
//if we the least is from other column then we add least with cost
//this is doing because we don't want to paint two sequenced house with same colour
//and in this approach we are not using third array so time complexity will become n^2
public class Q18_Paint_House_Many_Colors_Secpnd_Aproach {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        int[][] arr = new int[n][k];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        int[][] dp = new int[n][k];
        int least = Integer.MAX_VALUE;
        int sleast = Integer.MAX_VALUE;
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = arr[0][j];
            if (arr[0][j] < least) {
                sleast = least;
                least = arr[0][j];
            } else if (arr[0][j] < sleast) {
                sleast = arr[0][j];
            }
        }

        for (int i = 1; i < dp.length; i++) {
            int nleast = Integer.MAX_VALUE;
            int nsleast = Integer.MAX_VALUE;
            for (int j = 0; j < dp[0].length; j++) {
                if (dp[i - 1][j] == least) {
                    dp[i][j] = arr[i][j] + sleast;
                } else {
                    dp[i][j] = arr[i][j] + least;
                }
                if (dp[i][j] < nleast) {
                    nsleast = nleast;
                    nleast = dp[i][j];
                } else if (dp[i][j] < nsleast) {
                    nsleast = dp[i][j];
                }
            }
            least = nleast;
            sleast = nsleast;
        }
        //at last least cost of last column will be the final ans
        System.out.println(least);
        scn.close();
    }
}
