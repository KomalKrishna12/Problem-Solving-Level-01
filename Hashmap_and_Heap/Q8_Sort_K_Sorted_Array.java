import java.util.PriorityQueue;
import java.util.Scanner;
// In this question we have given a k sorted array like partially sorted array
// we're required to sort the array
// n = 9
// arr[] : 3 2 4 1 6 5 7 9 8 
// k = 3
// so we create a for loop for [0 to k] and add all in pq (priority queue object)
// now again create a loop for [k + 1 to n)
// print peek and add arr[k+1]
// after loop create a while loop and print all element
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
