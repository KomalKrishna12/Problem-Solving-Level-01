import java.util.Scanner;

public class Q96_First_index {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int x = scanner.nextInt();//data for which we want to print first index
        System.out.println(firstIndex(arr, 0, x));
        scanner.close();
    }
    public static int firstIndex(int[] arr, int index, int x) {
        if(index == arr.length){
            return -1;
        }
        if(arr[index] == x){
            return index;
        }
        else{
            int firstIndexInSmallArray = firstIndex(arr, index + 1, x);
            return firstIndexInSmallArray;
        }
    }
}
