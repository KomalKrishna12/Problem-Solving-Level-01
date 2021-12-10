import java.util.PriorityQueue;
import java.util.Scanner;

public class Q8_Sort_K_Sorted_Array {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i <= k; i++) {
            pq.add(arr[i]);
        }

        for (int i = k + 1; i < n; i++) {
            System.out.print(pq.remove() + " ");
            pq.add(arr[i]);
        }

        while(pq.size() > 0){
            System.out.print(pq.remove() + " ");
        }
        scn.close();
    }
}
