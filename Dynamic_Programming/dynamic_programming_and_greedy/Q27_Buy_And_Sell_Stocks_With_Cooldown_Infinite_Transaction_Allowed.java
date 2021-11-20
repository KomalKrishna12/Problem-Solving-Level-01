import java.util.Scanner;
//this question is same like Q26
//but in this ques no transaction fee at time of selling
//but there is cooldown
//that means after selling there has to be a cooldown
//created three variable
//obsp-old buy stock profit
//ossp-old sell stock profit
//ocsp-old cool stock profit
//at first obsp will -arr[0] becoz we are buying a stock first time 
//rest ossp and ocsp will be zero
//inside loop create nbsp, nssp, ncsp
//when ncsp-arr[i] is greater than obsp then set nbsp with ocsp-arr[i]
//beacuse before buy a stock there has to be cooldown else nbsp will be obsp when no profit from creating 
//new stock on ith day
//when nbsp+arr[i]is greater than ossp then set nssp with nbsp+arr[i]
//because when we want to sell stock we check that if we sell today then we get graeter profit or not
//if not then set nssp as ossp
//for cooldown check wheather the ossp is greater than ocsp then set ncsp as ossp otherwise
//ncsp will become ocsp
public class Q27_Buy_And_Sell_Stocks_With_Cooldown_Infinite_Transaction_Allowed {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int obsp = -arr[0];
        int ossp = 0;
        int ocsp = 0;
        for (int i = 1; i < arr.length; i++) {
            int nbsp = 0;
            int nssp = 0;
            int ncsp = 0;
            if(ocsp-arr[i] > obsp){
                nbsp=ocsp-arr[i];
            }
            else{
                nbsp=obsp;
            }

            if(obsp+arr[i]>ossp){
                nssp=obsp+arr[i];
            }
            else{
                nssp=ossp;
            }

            if(ossp>ocsp){
                ncsp=ossp;
            }
            else{
                ncsp=ocsp;
            }
            obsp = nbsp;
            ossp = nssp;
            ocsp = ncsp;
        }
        System.out.println(ossp);
        //at end we display ossp beacuse here we sell all stocks so we have max profits
        //in obsp we have one stock left
        //in ocsp we haven't check for last day 
        scn.close();
    }
}
