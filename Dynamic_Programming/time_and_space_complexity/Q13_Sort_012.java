import java.util.Scanner;
//for sort 0's, 1's and 2's we use partition of an array concept but here we use three pointers
//i, j and k
//i and j will initially point to 0th index and k will point to last index
public class Q13_Sort_012 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        sort(arr);
        print(arr);
        scn.close();
    }
    //i = 0, j = 0, k = arr.length - 1;
    //i to k - unknown
    //j to (i - 1) - 1's
    //0 to (j - 1) - 0's
    //(k + 1) to end - 2's
    //when arr[i] == 1 increament i with 1
    //when arr[i] == 0 swap i and j and increament i and j with 1
    //when arr[i] == 2 swap i and k and decreament k with 1 because we have to check for i again 
    public static void sort(int[] arr) {
        int i = 0, j = 0, k = arr.length - 1;
        while(i <= k){
            if(arr[i] == 1){
                i++;
            }
            else if(arr[i] == 0){
                swap(arr, i, j);
                i++;
                j++;
            }
            else{
                swap(arr, i, k);
                k--;
            }
        }
    }
    public static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping index " + i + " and index " + j);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
