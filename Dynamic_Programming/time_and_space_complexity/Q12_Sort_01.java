import java.util.Scanner;
//To Sort 0's and 1's we use concept of partioning.
public class Q12_Sort_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        sort(arr);
        print(arr);
        scanner.close();
    }
    public static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping " + i + " and " + j);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    //this is partioning an array using pivot but here we use 0's and 1's instead of pivot because
    //array is filled with 0's and 1's. firstly we place both i and j pointer to 0th index
    //when arr[i] == 1 we simply increament the value of i with 1
    //when arr[i] == 0 firstly we swap value of i and j then increament both i and j with 1
    public static void sort(int[] arr) {
        int i = 0;
        int j = 0;
        while(i < arr.length){
            if(arr[i] == 1){
                i++;
            }
            else{
                swap(arr, i, j);
                i++;
                j++;
            }
        }
    }
    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
