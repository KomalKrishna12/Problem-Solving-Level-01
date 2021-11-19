import java.util.Scanner;

public class Q24_Buy_And_Sell_Stocks_One_Transaction_Allowed{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] prices = new int[n];
        for (int i = 0; i < prices.length; i++) {
            prices[i] = scn.nextInt();
        }

        int leastInAllPrevDays = Integer.MAX_VALUE;
        int overallProfit = 0;
        int profitIfSoldToday = 0;

        for (int i = 0; i < prices.length; i++) {
            if(leastInAllPrevDays > prices[i]){
                leastInAllPrevDays = prices[i];
            }
            profitIfSoldToday = prices[i] - leastInAllPrevDays;
            if(overallProfit < profitIfSoldToday){
                overallProfit = profitIfSoldToday;
            }
        }

        System.out.println(overallProfit);

        scn.close();
    }
}