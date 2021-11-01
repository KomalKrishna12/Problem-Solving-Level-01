import java.util.*;
public class Q1_Bubble_Sort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //n is the size of 1D array
        int n = scanner.nextInt();
        //here we are creating an array arr with size n
        int[] arr = new int[n];
        //here we are taking elements for the arr
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        //calling bubbleSort(arr) function
        bubbleSort(arr);
        //after calling bubble sort we'll display the elements of array to check that it is sorted or not
        display(arr);
        scanner.close();
    }

    //in bubble sort, it is go with level if array size is 5 then their will be 4 levels
    public static void bubbleSort(int[] arr) {
        //level start from 1 to n-1
        //iteration inside level start from 0 to array length - level no
        //in first level largest element store at last index 
        //in second level second largest element store at last index - 1 postion for that
        //we take arr.length - i in the cond of second loop
        for (int i = 1; i <= arr.length - 1; i++) {
            for(int j = 0; j < arr.length - i; j++){
                if(isSmall(arr,j+1,j)){
                    swap(arr,j+1,j);
                }
            }
        }
    }
    //this is function to swap value of arr[i] and arr[j]
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    //this is the function to check the smallest element by comparing both arr[i] and arr[j]
    public static boolean isSmall(int[] arr, int i, int j){
        if(arr[i] < arr[j]){
            return true;
        }
        else{
            return false;
        }
    }
    //this function is used to display array element
    public static void display(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
