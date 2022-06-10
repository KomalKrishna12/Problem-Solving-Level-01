import java.io.*;
import java.util.*;
// this is Dijkstra Algorithm
// similar like BFS
// in BFS we use Queueu and here we use Priority Queue
// in this ques we have tio find shortest path in terms of weight
// so we create pair class and using comparable interface compare weight and find out path
public class Q15_Shortest_Path_in_Weights {
    static class Edge {
        int src;
        int nbr;
        int wt;
  
        Edge(int src, int nbr, int wt) {
           this.src = src;
           this.nbr = nbr;
           this.wt = wt;
        }
     }
  
     static class Pair implements Comparable<Pair>{
         int v;
         String psf;
         int wt;
         Pair(int v, String psf, int wt){
             this.v = v;
             this.psf = psf;
             this.wt = wt;
         }
         // we want to comapare weight of path so we return for weights
        @Override
        public int compareTo(Q15_Shortest_Path_in_Weights.Pair o) {
            return this.wt - o.wt;
        }
     }
     public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  
        int vtces = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < vtces; i++) {
           graph.add(new ArrayList<>());
        }
  
        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
           String[] parts = br.readLine().split(" ");
           int v1 = Integer.parseInt(parts[0]);
           int v2 = Integer.parseInt(parts[1]);
           int wt = Integer.parseInt(parts[2]);
           graph.get(v1).add(new Edge(v1, v2, wt));
           graph.get(v2).add(new Edge(v2, v1, wt));
        }
  
        int src = Integer.parseInt(br.readLine());
        
        boolean[] visited = new boolean[vtces];
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        queue.add(new Pair(src, src + "", 0));

        while(queue.size() > 0){
            // remove
            Pair remPair = queue.remove(); // this is will remove high priority pair which is shortest weight
            
            if(visited[remPair.v] == true) continue;

            // mark visited if not
            visited[remPair.v] = true;

            // write
            System.out.println(remPair.v + " via " + remPair.psf + " @ " + remPair.wt);

            // add if there exists any nabour
            for(Edge e : graph.get(remPair.v)){
                if(visited[e.nbr] == false){
                    queue.add(new Pair(e.nbr, remPair.psf + e.nbr, remPair.wt + e.wt));
                }
            }

        }
        
     }
     public static void shortestPathWithUnitDistance(ArrayList<ArrayList<Integer>> graph, int V, int src){
         // craete a distance array which will store min distance from src to each vertex
         int[] dis = new int[V];
         Arrays.fill(dis, Integer.MAX_VALUE);
         // fill max value so after comparison we get min value
         // now create a queue and add src into queue
         // add dis[src] = 0
         // now run while loop till queuq become empty
         // firstly remove head vertex
         // now check it's neibours
         // if their dis[] value is greater than dis[rem] + 1 then replace it with dis[rem] + 1
         // and add the nabour into queue
         
         ArrayDeque<Integer> queue = new ArrayDeque<>();
         queue.add(src);
         dis[src] = 0;

         while(queue.size() > 0){
             Integer rem = queue.removeFirst();

             for(Integer i : graph.get(rem)){
                 if(dis[i] > dis[rem] + 1){
                     dis[i] = dis[rem] + 1;
                     queue.add(i);
                 }
             }
         }

         // now our dis array is filled
         // now we can get min distance from src to any vertex using this array
     }
}
