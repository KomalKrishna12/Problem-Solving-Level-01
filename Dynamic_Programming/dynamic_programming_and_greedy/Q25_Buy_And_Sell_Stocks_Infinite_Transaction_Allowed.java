import java.util.Scanner;
//In this question we have n no of days 
//In each days there is price of stocks
//infinite no of transaction is allowed
public class Q25_Buy_And_Sell_Stocks_Infinite_Transaction_Allowed {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        //at start set bp(buy point) and sp(sell point) at 0th index
        //at start profit will be zero
        //when next point price is greater than last then increse sell point
        //when next point price is less than last that time calculate profit and set sp and bp at i
        //for last we have to calculate sp again beacuse there is no further down
        int bp = 0;
        int sp = 0;
        int profit = 0;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > arr[i-1]){
                sp++;
            }
            else{
                profit += arr[sp] - arr[bp];
                sp = bp = i;
            }
        }
        profit += arr[sp] - arr[bp];
        System.out.println(profit);
        scn.close();
    }
}
