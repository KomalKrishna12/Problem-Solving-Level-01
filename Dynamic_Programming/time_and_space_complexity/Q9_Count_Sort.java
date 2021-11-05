import java.util.Scanner;

public class Q9_Count_Sort {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        //max will store min value in integer so that we can compare it with array element and replace with
        //max value of array
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        countSort(arr,min,max);
        print(arr);
        scn.close();
    }
    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    //first of all we find range and create a frequency array with the size range then we increase the value
    //from zero to arr[i] - min
    public static void countSort(int[] arr, int min, int max) {
        int range = max - min + 1;
        int farr[] = new int[range];
        for (int i = 0; i < arr.length; i++) {
            farr[arr[i] - min]++;
        }
        //then we replace its value with prefix summation so we can get occurance count
        for (int i = 1; i < farr.length; i++) {
            farr[i] = farr[i] + farr[i - 1];
        }
        //ans array having same length as arr
        int[] ans = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int val = arr[i];
            int pos = farr[val - min] - 1;
            ans[pos] = val;
            farr[val - min]--;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ans[i];
        }
    }
}
