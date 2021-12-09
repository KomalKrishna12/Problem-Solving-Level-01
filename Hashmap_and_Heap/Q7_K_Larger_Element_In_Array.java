import java.util.PriorityQueue;
import java.util.Scanner;

public class Q7_K_Larger_Element_In_Array {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        scn.close();
        for (int i : arr) {
            pq.add(i);
        }
        int r = n - k;
        while(r-- > 0){
            pq.remove();
        }
       
        while(pq.size() > 0){
            System.out.print(pq.peek() + " ");
            pq.remove();
        }
    }
}
