import java.util.Scanner;

public class Q2_Target_Subset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        //n is the size of array which we take from scanner and create an array of size n
        //then using for loop take values for the array
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        //target is the value for which we want to print the substring
        int target = scanner.nextInt();
        targetSubset(arr, 0, "", 0, target);
        scanner.close();
    }
    public static void targetSubset(int[] arr, int index, String set, int sos, int target) {
        if(index == arr.length){
            if(sos == target){
                System.out.println(set + ".");
            }
            return;
        }

        //we have two option first is that we can take the element or ignore the element
        //these are the two method we call for two options
        targetSubset(arr, index + 1, set + arr[index] + ", ", sos + arr[index], target);
        targetSubset(arr, index + 1, set, sos, target);
    }
}
