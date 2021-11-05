//quick select also use concept of partition an array. In this algo we have to find kth smallest element
//of an array. So we do partitioning by assuming last element as pivot. suppose user want to know 3rd smallest
//element that means we've to find 2nd index because indexing start from 0 to (arr.length - 1).
//so assume k is the index for which we want to find kth smallest element so first we partition array using
//last index value then we compare the pivot index with the k if k > pivotIndex that means value is 
//greater than pivot so we pass pivot + 1 in place of low and high will be pass at high
//if k < pivotIndex so we have to pass pivot - 1 in place of high and low will be pass at low.
//if k == pivotIndex, we simply return pivot.
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
        //in quickSelect function we pass k - 1 because indexing of array start from 0.
        System.out.println(quickSelect(arr, 0, arr.length - 1, k-1));
        display(arr);
        scn.close();
    }
    //firstly we store arr[high] value in pivot then find pivot index using partition function
    //if pivotIndex > k pass pivot - 1 in place of high
    //if pivotIndex < k pass pivot + 1 in place of low
    //if pivotIndex == k return pivot that is the required kth smallest element of an array
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
    //for partition firstly we point both pointer on low index then start the loop, if arr[i] > pivot
    //increse i if arr[i] <= pivot then swap the value of i and j and increament both the value
    //return j -1 which is basically the pivot index.
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