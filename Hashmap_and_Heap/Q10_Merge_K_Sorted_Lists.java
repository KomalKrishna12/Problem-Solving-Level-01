import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
// in this question we create a class Pair which is having three int li(list index), di(data index)
// and val
// using constructor we're initializing our class
// this class implements Comparable so we have to give body to compareTo(Pair o) function
// we're using this for priority queue 

// approach
// add first element of all lists using Pair class
// now pq peek is having the least value so craete a while loop
// run this loop till pq.size() > 0
// so add peek val of pq and that val's data index will be increamented by 1
// and now update that pair value and check all element in pq it'll go till end and it'll add
// small elements one by one in array list

public class Q10_Merge_K_Sorted_Lists {
    public static class Pair implements Comparable<Pair>{
        int listIndex;
        int dataIndex;
        int val;
        Pair(int listIndex, int dataIndex, int val){
            this.listIndex = listIndex;
            this.dataIndex = dataIndex;
            this.val = val;
        }

        @Override
        public int compareTo(Q10_Merge_K_Sorted_Lists.Pair o) {
            return this.val - o.val;
        }
    }
    public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists){
        ArrayList<Integer> rv = new ArrayList<>();
  
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < lists.size(); i++) {
            Pair p = new Pair(i, 0, lists.get(i).get(0));
            pq.add(p);
        }

        while(pq.size() > 0){
            Pair p = pq.remove();
            rv.add(p.val);
            p.dataIndex++;

            if(p.dataIndex < lists.get(p.listIndex).size()){
                p.val = lists.get(p.listIndex).get(p.dataIndex);
                pq.add(p);
            }
        }

        return rv;
     }
  
     public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for(int i = 0; i < k; i++){
           ArrayList<Integer> list = new ArrayList<>();
  
           int n = Integer.parseInt(br.readLine());
           String[] elements = br.readLine().split(" ");
           for(int j = 0; j < n; j++){
              list.add(Integer.parseInt(elements[j]));
           }
  
           lists.add(list);
        }
  
        ArrayList<Integer> mlist = mergeKSortedLists(lists);
        for(int val: mlist){
           System.out.print(val + " ");
        }
        System.out.println();
     }
}
