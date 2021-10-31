import java.util.Scanner;

public class Q2_Target_Subset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
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
        targetSubset(arr, index + 1, set + arr[index] + ", ", sos + arr[index], target);
        targetSubset(arr, index + 1, set, sos, target);
    }
}
