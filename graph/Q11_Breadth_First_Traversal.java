import java.util.*;
import java.io.*;
// in BFS we use Queue
// so add first vertex into the queue
// remove that vertex and mark it as visited
// add it's naibour and so on
public class Q11_Breadth_First_Traversal {
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }
   static class Pair{
      int v;
      String psf;
      Pair(int v, String psf){
         this.v = v;
         this.psf = psf;
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
         graph.get(v1).add(new Edge(v1, v2));
         graph.get(v2).add(new Edge(v2, v1));
      }

      int src = Integer.parseInt(br.readLine());

      // solution :
      boolean[] visited = new boolean[vtces];

      ArrayDeque<Pair> queue = new ArrayDeque<>();
      queue.add(new Pair(src, src + ""));

      while(queue.size() > 0){
         // r m* w a* : remove mark_visited write add
         Pair remPair = queue.removeFirst(); // remove

         if(visited[remPair.v] == true) continue;
         visited[remPair.v] = true; // mark as visited
         System.out.println(remPair.v + "@" + remPair.psf); // wrte the path with its vertex

         // add all the nabours of remPair vertex
         for(Edge e : graph.get(remPair.v)){
            if(visited[e.nbr] == false){
               queue.add(new Pair(e.nbr, remPair.psf + e.nbr));
            }
         }
 
      }
   }
}
