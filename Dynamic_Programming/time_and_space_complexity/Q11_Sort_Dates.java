import java.util.Scanner;
//in this we use of concept of count sort
public class Q11_Sort_Dates {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.next();
        }
        sortDates(arr);
        print(arr);
        scn.close();
    }
    public static void sortDates(String[] arr) {
        //call count sort for dates range will be 32 so that index will be 0 to 31
        countSort(arr, 1000000, 100, 32);
        //call count sort for months range will be 13 so that index will be 0 to 12
        countSort(arr, 10000, 100, 13);
        //call count sort for yearss range will be 2501 so that index will be 0 to 2500
        //in question it is mentioned to take years upto 2500
        countSort(arr, 1, 10000, 2501);
    }
    public static void countSort(String[] arr, int div, int mod, int range) {
        String[] ans = new String[arr.length];
        int[] farr = new int[range];
        //make frequency array
        for (int i = 0; i < arr.length; i++) {
            farr[Integer.parseInt(arr[i],10)/div % mod]++;
        }
        //convert it into prefix array
        for (int i = 1; i < farr.length; i++) {
            farr[i] += farr[i - 1];
        }
        //stable sorting(filling ans array)
        for (int i = arr.length - 1; i >= 0; i--) {
            int pos = farr[Integer.parseInt(arr[i],10)/div % mod] - 1;
            ans[pos] = arr[i];
            farr[Integer.parseInt(arr[i],10)/div % mod]--;
        }
        //filling original array with the help of ans array
        for (int i = 0; i < ans.length; i++) {
            arr[i] = ans[i];
        }
    }
    public static void print(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
