import java.util.Scanner;

public class Q59_First_And_Last_Index {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[] arr = new int[scn.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int data = scn.nextInt();
        int low = 0;
        int high = arr.length - 1;
        int first = -1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(data > arr[mid]){
                low = mid + 1;
            }
            else if(data < arr[mid]){
                high = high - 1;
            }
            else{
                first = mid;
                high = mid - 1;
            }
        }
        System.out.println("first index : " + first);
        low = 0;
        high = arr.length - 1;
        int last = -1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(data > arr[mid]){
                low = mid + 1;
            }
            else if(data < arr[mid]){
                high = high - 1;
            }
            else{
                last = mid;
                low = mid + 1;
            }
        }
        System.out.println("last index : " + last);
        scn.close();
    }
}
