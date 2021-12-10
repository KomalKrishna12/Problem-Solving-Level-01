import java.io.*;
import java.util.ArrayList;
// assume array list is linear form of heap
// it follows two condition
// 1. HOP (parent val will be lesser than li and ri)
// 2. CBT (Common Binary Tree that measn one preveious level will be completely filled and elements
//     will be set from left to right)

public class Q11_Write_Priority_Queue_Using_Heap {
    public static class PriorityQueue {
        ArrayList<Integer> data;

        // it'll swap ith vale with jth value
        private void swap(int i, int j){
            int ith = data.get(i);
            int jth = data.get(j);
            data.set(i, jth);
            data.set(j, ith);
        }

        // downheapify is having parent index because in remove function we swap 0th with last index
        // bcoz in array list removing last index is having 0(1) complexity
        // so our root node swap at last index
        // after removing root our HOP will differ
        // so we do downheapify so arrange nodes in proper format so that parent value will be lesser
        // then left and right
        /* 
        approach : store pi into mini
        now calculate left index(li) that will be 2 * pi + 1
        now check that this left index is existing or not 
        if value at li is lesser than value at pi then store li into mini
        same with ri
        now check that mini and pi is equal or not
        if equal that means no need to change
        else swap mini and pi now pi is at correct position so again call downfy with mini 
        */ 
        private void downHeapify(int pi){
            int mini = pi;
            int li = 2 * pi + 1;
            if(li < data.size() && data.get(li) < data.get(mini)){
                mini = li;
            }
            int ri = 2 * pi + 2;
            if(ri < data.size() && data.get(ri) < data.get(mini)){
                mini = ri;
            }
            if(mini != pi){
                swap(mini, pi);
                downHeapify(mini);
            }
        }

        // in add() we add data at end becoz it is having complexity of o(1)
        // now we have to check that the data which is added is lesser than parent index or not
        // so call upheapify with data.size()-1 index
        // we are going from end to up
        /*
        approach : if i == 0 that means we're at root this is our base condition 
        calculate parent index using (child index - 1)/2 formula
        now check the value at position pi and i
        if i is less than pi then swap the values
        and call upheapify with pi becoz we want to chech for upper 
        */
        private void upHeapify(int i){
            if(i == 0) return;
            int pi = (i - 1)/2;
            if(data.get(pi) > data.get(i)){
                swap(i, pi);
                upHeapify(pi);
            }
        }
    
        public PriorityQueue() {
          data = new ArrayList<>();
        }
    
        public void add(int val) {
            data.add(val);
            upHeapify(data.size() - 1);
        }
    
        public int remove() {
            if(data.size() == 0){
                System.out.println("Underflow");
                return -1;
            }
            swap(0, data.size() - 1);
            int val = data.remove(data.size() - 1);
            downHeapify(0);
            return val;
        }
    
        public int peek() {
            if(data.size() == 0){
                System.out.println("Underflow");
                return -1;
            }
            return data.get(0);
        }
    
        public int size() {
            return data.size();
        }
      }
    
      public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue qu = new PriorityQueue();
    
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
