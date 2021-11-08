import java.util.Scanner;

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
