import java.util.Scanner;

public class Q8_Quick_Select {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        System.out.println(quickSelect(arr, 0, arr.length - 1, k-1));
        display(arr);
        scn.close();
    }
    public static int quickSelect(int[] arr, int low, int high, int k) {
        int pivot = arr[high];
        int pi = partition(arr, pivot, low, high);
        if(pi > k){
            return quickSelect(arr, low, pivot - 1, k);
        }
        else if(pi < k){
            return quickSelect(arr, pivot + 1, high, k);
        }
        else{
            return pivot;
        }
    }
    public static int partition(int[] arr, int pivot, int low, int high) {
        System.out.println("Pivot : " + pivot);
        int i = low, j = low;
        while (i <= high) {
            if (arr[i] > pivot) {
                i++;
            } else {
                swap(arr, i, j);
                i++;
                j++;
            }
        }
        System.out.println("Pivot index : " + (j - 1));
        return j - 1;
    }

    public static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping " + arr[i] + " and " + arr[j]);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void display(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}