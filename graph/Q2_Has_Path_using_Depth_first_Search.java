import java.io.*;
import java.util.*;
public class Q2_Has_Path_using_Depth_first_Search {
    static class Edge {
        int src;
        int nbr;
        int wt;
  
        Edge(int src, int nbr, int wt){
           this.src = src;
           this.nbr = nbr;
           this.wt = wt;
        }
     }
     public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  
        int vtces = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        //ArrayList<Edge>[] graph = new ArrayList[vtces];
        for(int i = 0; i < vtces; i++){
           //graph[i] = new ArrayList<>();
           graph.add(new ArrayList<>());
        }
  
        int edges = Integer.parseInt(br.readLine());
        for(int i = 0; i < edges; i++){
           String[] parts = br.readLine().split(" ");
           int v1 = Integer.parseInt(parts[0]);
           int v2 = Integer.parseInt(parts[1]);
           int wt = Integer.parseInt(parts[2]);
           graph.get(v1).add(new Edge(v1, v2, wt));
           graph.get(v2).add(new Edge(v2, v1, wt));
        }
  
        int src = Integer.parseInt(br.readLine());
        int dest = Integer.parseInt(br.readLine());
  
        // solution
        boolean[] visited = new boolean[vtces];
        boolean hasPath = hasPath(graph, src, dest, visited);

        System.out.println(hasPath);
      }

      public static boolean hasPath(ArrayList<ArrayList<Edge>> graph, int src, int dest, boolean[] visited){
          if(src == dest) return true;

          visited[src] = true;

          for(Edge edge : graph.get(src)){
              if(visited[edge.nbr] == false){
                  boolean hasNbrPath = hasPath(graph, edge.nbr, dest, visited);
                  if(hasNbrPath) return true;
              }
          }

          return false;
      }
}
