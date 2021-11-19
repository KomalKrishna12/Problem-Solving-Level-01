import java.util.Scanner;
//In this question only one transaction is allowed
//n is no of days
//and prices array contains prices for n days
//we create one var which count least price from previous days so that to calculate profit we can 
//subtract that least from the price of that particular day which we store in other var profitifsoldtoday
//one other variable is overallprofit which will be the ans
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