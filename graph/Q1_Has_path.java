import java.io.*;
import java.util.*;
// in this question we have to check that whaeather their is any path from src to des ot not
// we can use recursion in this problem same like we did in flood fill 
public class Q1_Has_path{
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
        ArrayList<Edge>[] graph = new ArrayList[vtces]; 
        for(int i = 0; i < vtces; i++){
           graph[i] = new ArrayList<>();
        }
  
        int edges = Integer.parseInt(br.readLine());
        for(int i = 0; i < edges; i++){
           String[] parts = br.readLine().split(" ");
           int v1 = Integer.parseInt(parts[0]);
           int v2 = Integer.parseInt(parts[1]);
           int wt = Integer.parseInt(parts[2]);
           graph[v1].add(new Edge(v1, v2, wt));
           graph[v2].add(new Edge(v2, v1, wt));
        }
  
        int src = Integer.parseInt(br.readLine());
        int dest = Integer.parseInt(br.readLine());
  
        // this visited array will mark true in that src which is already visited so we'll not go into loop
        boolean[] visited = new boolean[vtces];
        boolean path = hashPath(graph, src, dest, visited);
        System.out.println(path);
      }

      // fisrtly check that the src or des is same or not
      // if same then return true
      // now mark the visited[src] as true to avoid looping
      // now create a for loop on graph[src] and check the edges
      // if the nbr of edge is not visited than call edge.nbr as src 
      public static boolean hashPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited){
          if(src == dest) return true;
          visited[src] = true;
          for(Edge edges : graph[src]){
              if(visited[edges.nbr] == false){
                  if(hashPath(graph, edges.nbr, dest, visited) == true){
                      return true;
                  }
              }
          }
          return false;
      }
}