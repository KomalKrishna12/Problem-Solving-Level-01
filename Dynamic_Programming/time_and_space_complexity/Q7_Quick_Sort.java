import java.util.Scanner;

public class Q7_Quick_Sort {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        quickSort(arr,0,arr.length-1);
        print(arr);
        scn.close();
    }
    //in quick sort we use partition of an array approach, but here we're passing last element of an array 
    //in pivot and then sort the array with index 0 to pivot - 1 and pivot + 1 to high using
    //quick sort function by passing high value as pivot - 1 and in second low value as pivot + 1

    public static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping " + arr[i] + " and " + arr[j]);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int partition(int[] arr, int pivot, int low, int high) {
        int i = low;
        int j = low;
        while (i <= high) {
            if (arr[i] <= pivot) {
                swap(arr, i, j);
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j - 1;
    }

    public static void quickSort(int[] arr, int low, int high) {
        if(low >= high){
            return;
        }
        int pivot = partition(arr, arr[high], low, high);
        quickSort(arr, low, pivot - 1);
        quickSort(arr, pivot + 1, high);
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
        System.out.println();
    }
}
