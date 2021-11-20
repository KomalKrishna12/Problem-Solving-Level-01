import java.util.Scanner;

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

        scn.close();
    }
}
