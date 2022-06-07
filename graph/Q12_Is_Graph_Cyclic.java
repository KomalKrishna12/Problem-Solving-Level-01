import java.io.*;
import java.util.*;

// in this problem we check that any graph is cyclic or not
// so we use breadth first search 
// check for each vertex like we did get connected components
public class Q12_Is_Graph_Cyclic {
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

   static class Pair {
      int v;
      String psf;

      Pair(int v, String psf) {
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
         int wt = Integer.parseInt(parts[2]);
         graph.get(v1).add(new Edge(v1, v2, wt));
         graph.get(v2).add(new Edge(v2, v1, wt));
      }

      boolean[] visited = new boolean[vtces];

      for (int v = 0; v < vtces; v++) {
         if (visited[v] == false) {
            boolean isCycle = isCycle(graph, v, visited);
            if (isCycle) {
               System.out.println(true);
               return;
            }
         }
      }
      System.out.println(false);
   }

   public static boolean isCycle(ArrayList<ArrayList<Edge>> graph, int src, boolean[] visited) {
      // r m* w a*
      ArrayDeque<Pair> queue = new ArrayDeque<>();
      queue.add(new Pair(src, src + ""));

      while (queue.size() > 0) {
         Pair rem = queue.removeFirst();
         if (visited[rem.v] == true)
            return true;

         visited[rem.v] = true;
         for (Edge e : graph.get(rem.v)) {
            if (visited[e.nbr] == false) {
               queue.add(new Pair(e.nbr, rem.psf + e.nbr));
            }
         }

      }
      return false;
   }
}
