// ceil is greater than data and floor is smaller than data.
// arr = {10,20,30,40,50,60,70,80,90,100}
//data = 33
//ceil = 40
//floor = 30
import java.util.Scanner;

public class Q58_Ceil_And_Floor {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[] arr = new int[scn.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int data = scn.nextInt();
        int ceil = 0;   
        int floor = 0;
        int low = 0;
        int high = arr.length - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(data > arr[mid]){
                low = mid + 1;
                floor = arr[mid];
            }
            else if(data < arr[mid]){
                high = mid - 1;
                ceil = arr[mid];
            }
            else{
                ceil = arr[mid];
                floor = arr[mid];
            }
        }
        System.out.println("ceil : " + ceil);
        System.out.println("floor : " + floor);

        scn.close();
    }
}
