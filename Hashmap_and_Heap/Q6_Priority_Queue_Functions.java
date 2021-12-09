import java.net.Inet4Address;
import java.util.*;

public class Q6_Priority_Queue_Functions {
    public static void main(String[] args) {
        // by default priority queue given priority to small elements
        // so in peek small element will be there
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] arr = {10, 3, 5, 88, 55};
        
        for (int i : arr) {
            pq.add(i);
        }
        System.out.println(pq);

        while(pq.size() > 0){
            System.out.print(pq.peek() + " ");
            pq.remove();
        }
        System.out.println();

        // to set max element as priority we write Collections.reverseOrder in PriorityQueue construction
        // while creating its object
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder);
        for (int i : arr) {
            pq2.add(i);
        }
        System.out.println(pq2);
        while(pq2.size() > 0){
            System.out.print(pq2.peek() + " ");
            pq2.remove();
        }
        System.out.println();

    }
}
