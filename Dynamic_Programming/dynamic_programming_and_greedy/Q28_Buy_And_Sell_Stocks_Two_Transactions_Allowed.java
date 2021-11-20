import java.util.Scanner;

public class Q28_Buy_And_Sell_Stocks_Two_Transactions_Allowed {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }

        int least = arr[0];
        int maxProfitIfSoldToday = 0;
        int[] dpLeft = new int[n];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] < least){
                least = arr[i];
            }
            maxProfitIfSoldToday = arr[i] - least;
            if(maxProfitIfSoldToday > dpLeft[i-1]){
                dpLeft[i] = maxProfitIfSoldToday;
            }
            else{
                dpLeft[i] = dpLeft[i-1];
            }
        }

        int max = arr[arr.length-1];
        int maxProfitIfBuyToday = 0;
        int[] dpRight = new int[n];
        for (int i = arr.length-2; i >= 0; i--) {
            if(arr[i] > max){
                max = arr[i];
            }
            maxProfitIfBuyToday = max - arr[i];
            if(maxProfitIfBuyToday > dpRight[i+1]){
                dpRight[i] = maxProfitIfBuyToday;
            }
            else{
                dpRight[i] = dpRight[i+1];
            }
        }

        int overallProfit = dpLeft[0] + dpRight[0];
        for (int i = 1; i < dpRight.length; i++) {
            if(dpLeft[i] + dpRight[i] > overallProfit){
                overallProfit = dpLeft[i] + dpRight[i];
            }
        }

        System.out.println(overallProfit);

        scn.close();
    }
}
