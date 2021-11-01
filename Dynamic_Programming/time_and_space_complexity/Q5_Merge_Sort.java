import java.util.Scanner;

public class Q5_Merge_Sort {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        //n is size of array
        int n = scn.nextInt();
        //create array a of size n
        int[] a = new int[n];
        //get elements of array a
        for (int i = 0; i < a.length; i++) {
            a[i] = scn.nextInt();
        }
        //sort the array using merge sort
        int[] res = mergeSort(a, 0, a.length-1);
        print(res);
        scn.close();
    }   

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    //in merge sort we divide the array into two part using mid index
    //then sort that two divided array
    //merge these two sorted array using mergeTwoSortedArr function
    public static int[] mergeSort(int[] arr, int low, int high){
        if(low == high){
            int[] baseCase = new int[1];
            baseCase[0] = arr[low];
            return baseCase;
        }
        int mid = (low + high)/2;
        int[] first = mergeSort(arr, low, mid);
        int[] second = mergeSort(arr, mid + 1, high);
        int[] res = mergeTwoSortedArr(first,second);
        return res;
    }
    public static int[] mergeTwoSortedArr(int[] a, int[] b) {
        int res[] = new int[a.length + b.length];
        int i =0, j=0, k=0;
        while(i < a.length && j < b.length){
            if(a[i] < b[j]){
                res[k] = a[i];
                i++;
                k++;
            }
            else{
                res[k] = b[j];
                j++;
                k++;
            }
        }
        while(i < a.length){
            res[k] = a[i];
            i++;
            k++;
        }
        while(j < b.length){
            res[k] = b[j];
            j++;
            k++;
        }
        return res;
    }
}
