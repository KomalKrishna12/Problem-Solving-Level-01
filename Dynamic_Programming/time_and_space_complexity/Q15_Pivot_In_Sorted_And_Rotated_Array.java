import java.util.Scanner;
//In this question we've given a sorted and rotated array we have to find pivot of the array
//pivot is the smallest element of an array
public class Q15_Pivot_In_Sorted_And_Rotated_Array {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(findPivot(arr));
        scn.close();
    }
    //In this we use binary search
    //when arr[mid] < arr[high] that means from mid to high value is increasing that means pivot exist on
    //left side so we simply set high = mid
    //when arr[mid] >= arr[high] that means from mid to high value is decreasing that means pivot
    //exist on right side so we set low = mid + 1
    //at the end we return any value arr[low] or arr[mid] or arr[high] because there is only one element
    //left in the array
    public static int findPivot(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while(low < high){
            int mid = (low + high)/2;
            if(arr[mid] < arr[high]){
                high = mid;
            }
            else{
                low = mid + 1;
            }
        }
        return arr[low];
    }
}
