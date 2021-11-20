import java.util.Scanner;
//In this question n is no of days
//arr[n] denotes prices of stock in n days
//fee is the transaction fees which will charge when we sell the stock
//infinite transactions are allowed
//obsp - old buy state point
//ossp - old sell state point
//nbsp - new buy state point
//nssp - new sell state point
//at first onsp will be -arr[0] bcoz we are purschasing a stock with arr[0] price
//at first ossp will be zero
//inside loop we create nbsp and nssp to calculate bsp and nsp for arr[i]
//if ossp-arr[i] that means we are purchasing stock using profit of last day so if that is greater than obsp
//then nbsp = ossp-arr[i] otherwise nbsp=obsp
//if obsp+arr[i]-fee that means we we are selling the stock today then obsp is buy stock price add today price
//reduce transaction fee if that is greater than last profit that is ossp then nssp = obsp+arr[i]-fee
//otherwise it'll same as ossp
public class Q26_Buy_And_Sell_Stocks_With_Transaction_Fees_Infinite_Transaction_Allowed {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int fee = scn.nextInt();

        int obsp = -arr[0];
        int ossp = 0;

        for (int i = 1; i < arr.length; i++) {
            int nbsp = 0;
            int nssp = 0;

            if((ossp - arr[i]) > obsp){
                nbsp = ossp - arr[i];
            }
            else{
                nbsp = obsp;
            }

            if(obsp + arr[i] - fee > ossp){
                nssp = obsp + arr[i] - fee;
            }
            else{
                nssp = ossp;
            }

            obsp = nbsp;
            ossp = nssp;
        }

        System.out.println(ossp);
        //at end we display ossp that means after closing all transactions that max profit

        scn.close();
    }
}
