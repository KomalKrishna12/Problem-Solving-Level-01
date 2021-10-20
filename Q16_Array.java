import java.util.Scanner;

public class Q16_Array {
    
    public static void main(String[] args) {
        
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter size of array : ");
        int n = scn.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            System.out.print("Enter element for index " + i + " : ");
            arr[i] = scn.nextInt();
        }

        System.out.println("Elements of array are : ");

        for(int val : arr){
            System.out.print(val + " ");
        }
        scn.close();

    }

}
