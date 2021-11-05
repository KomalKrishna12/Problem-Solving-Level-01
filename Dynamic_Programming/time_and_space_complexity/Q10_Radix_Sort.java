import java.util.Scanner;

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
    public static void count(int[] arr, int exp) {
        int[] farr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            farr[arr[i]/exp % 10]++;
        }
        for (int i = 1; i < farr.length; i++) {
            farr[i] = farr[i] + farr[i - 1];
        }
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
