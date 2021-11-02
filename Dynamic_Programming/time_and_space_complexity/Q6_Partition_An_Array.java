import java.util.Scanner;

public class Q6_Partition_An_Array{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int pivot = scn.nextInt();
        partition(arr, pivot);
        scn.close();
        print(arr);
    }
    public static void partition(int[] arr, int pivot) {
        //three regions
        //first i to end  -> unknown region
        //second 0 to j-1 -> <= pivot
        //third j to i-1  -> > pivot
        int i = 0;
        int j = 0;
        while(i < arr.length){
            if(arr[i] > pivot){
                i++;
            }
            else{
                swap(arr,i,j);
                i++;j++;
            }
        }
    }
    public static void swap(int[] arr, int i, int j) {
        System.out.println("Swaping " + arr[i] + " and " +arr[j]);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}