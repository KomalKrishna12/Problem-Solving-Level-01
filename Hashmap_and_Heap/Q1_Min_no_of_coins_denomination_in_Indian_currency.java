import java.util.Collections;
import java.util.PriorityQueue;

public class Q1_Min_no_of_coins_denomination_in_Indian_currency {
    public static int minCoins(int[] arr, int x){
        int coin = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : arr) {
            pq.add(i);
        }
        while(x != 0){
            if(pq.peek() > x){
                pq.remove();
            }
            else{
                int amt = pq.peek();
                x = x - amt;
                coin++;
            }
        }
        return coin;
    }
    public static void main(String[] args) {
        // int[] arr = {1, 2, 5, 10, 20, 50, 100, 200, 500, 1000};
        int[] arr = {25, 10, 5};
        System.out.println(minCoins(arr, 30));
    }
}
