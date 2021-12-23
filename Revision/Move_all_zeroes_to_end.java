import java.util.Scanner;

public class Move_all_zeroes_to_end {
    public static void display(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void swap(int i, int j){
        int temp = i;
        i = j;
        j = temp;
    }
    public static void moveZeroes(int[] arr) {
        // j will point to 0th element and i will point to non zero element
        // when arr[i] != 0 and arr[j] == 0 swap there values
        // when arr[j] != 0 j++ 
        int j = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != 0 && arr[j] == 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            if(arr[j] != 0) j++;
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scn.nextInt();
        }
        moveZeroes(arr);
        display(arr);
        scn.close();
    }
}
