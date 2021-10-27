import java.util.Scanner;

public class Q95_Max_Of_An_Array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(maxElement(arr,0));
        scanner.close();
    }
    public static int maxElement(int[] arr, int index) {
        if(index == arr.length - 1){
            return arr[index];
        }
        int maxOfSmallestArr = maxElement(arr, index + 1);
        int max = arr[index];
        if(max > maxOfSmallestArr)
        return max;
        else
        return maxOfSmallestArr;
    }
}
