import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
// in this question we create two priority queue left and right
// left is max type priority queue so it gives priority to max elements
public class Q9_Median_Priority_Queue {
    public static class MedianPriorityQueue {
        PriorityQueue<Integer> left;
        PriorityQueue<Integer> right;
    
        public MedianPriorityQueue() {
          left = new PriorityQueue<>(Collections.reverseOrder());
          right = new PriorityQueue<>();
        }
    
        // if right pq size is greater then 0 and right pq peek is less than val then add the val in
        // right pq otherwise add in left pq
        // after that check the difference between size so that we can get median
        public void add(int val) {
          if (right.size() > 0 && val > right.peek()) right.add(val);
          else left.add(val);
          if (left.size() - right.size() == 2) right.add(left.remove());
          else if (right.size() - left.size() == 2) left.add(right.remove());
        }
    
        // is size is 0 then print "Underflow" and return -1
        // if left pq size is greater or both pq equal then return left peek else right peek
        public int remove() {
          if (this.size() == 0) {
            System.out.println("Underflow");
            return -1;
          }
          else if (left.size() >= right.size()) return left.remove();
          else return right.remove();
        }
    
        public int peek() {
          if (this.size() == 0) {
            System.out.println("Underflow");
            return -1;
          }
          else if (left.size() >= right.size()) return left.peek();
          else return right.peek();
        }
    
        public int size() {
          return left.size() + right.size();
        }
      }
    
      public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MedianPriorityQueue qu = new MedianPriorityQueue();
    
        String str = br.readLine();
        while (str.equals("quit") == false) {
          if (str.startsWith("add")) {
            int val = Integer.parseInt(str.split(" ")[1]);
            qu.add(val);
          } else if (str.startsWith("remove")) {
            int val = qu.remove();
            if (val != -1) {
              System.out.println(val);
            }
          } else if (str.startsWith("peek")) {
            int val = qu.peek();
            if (val != -1) {
              System.out.println(val);
            }
          } else if (str.startsWith("size")) {
            System.out.println(qu.size());
          }
          str = br.readLine();
        }
      }
}
