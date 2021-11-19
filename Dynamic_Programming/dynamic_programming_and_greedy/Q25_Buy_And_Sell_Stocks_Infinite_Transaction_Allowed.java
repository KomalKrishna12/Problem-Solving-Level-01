import java.util.Scanner;

public class Q25_Buy_And_Sell_Stocks_Infinite_Transaction_Allowed {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
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
