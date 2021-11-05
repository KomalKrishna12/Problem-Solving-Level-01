import java.util.Scanner;
//In radix sort the array using count sort
public class Q10_Radix_Sort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        radixSort(arr);
        print(arr);
        scanner.close();
    }
    //firstly we'll find the max element using MIN_VALUE variable of Integer then we compare that max
    //variable with every element of an array if any element is greater than max then we'll transfer 
    //that variable's value into max
    //declare one exp var by initializing with 1 after calling count multiply exp with 10
    public static void radixSort(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int val : arr) {
            if(val > max){
                max = val;
            }
        }
        int exp = 1;
        while(exp <= max){
            count(arr, exp);
            exp *= 10;
        }
    }
    //this is the same count sort
    //declare frequency array which will count occurance of evry element 0 to 9
    public static void count(int[] arr, int exp) {
        int[] farr = new int[10];
        //farr array will contain 0 in all places so we increament the size based on digit
        for (int i = 0; i < arr.length; i++) {
            farr[arr[i]/exp % 10]++;
        }
        //here we'll add prefix of farr array
        for (int i = 1; i < farr.length; i++) {
            farr[i] = farr[i] + farr[i - 1];
        }
        //res is the resultant array which will store the particular value at the particular pos
        int[] res = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int pos = farr[arr[i]/exp % 10] - 1;
            res[pos] = arr[i];
            farr[arr[i]/exp % 10]--;
        }
        for (int i = 0; i < res.length; i++) {
            arr[i] = res[i];
        }
    }
    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
