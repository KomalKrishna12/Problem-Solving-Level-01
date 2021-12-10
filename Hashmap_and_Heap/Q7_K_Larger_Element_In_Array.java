import java.util.PriorityQueue;
import java.util.Scanner;
// In this question we have given an array and k we have to find out k largest elements of array
// we can solve this using priority queue
// first of all create a for loop from 0 to arr.length
// add first k elements in priority queue
// now from next ith element check if the arr[i] > pq.peek() that means next element is greater than peek
// so remove peek and add arr[i]
// this will add k largest element in pq
// now display using while loop
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

        for (int i = 0; i < arr.length; i++) {
            if(i < k){
                pq.add(arr[i]);
            }
            else{
                if(pq.peek() < arr[i]){
                    pq.remove();
                    pq.add(arr[i]);
                }
            }
        }

        while(pq.size() > 0){
            System.out.print(pq.remove() + " ");
        }

    }
}
