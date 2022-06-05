
// we have given vertices, edghes and then src, nbr and weight
// we have to print all the connected components
// means src which is connected through it's nabours
// we use same approach which we used in find paths to reach destination
// craeted boolean array to get info abount vertices
// craete loop for each vertices
// if that is not visited then find its path 
import java.io.*;
import java.util.*;

public class Q5_Get_Connected_Component_of_Graph {
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

    ArrayList<ArrayList<Integer>> comps = new ArrayList<>();

    boolean[] visited = new boolean[vtces];
    for (int v = 0; v < vtces; v++) {
      if (visited[v] == false) {
        ArrayList<Integer> comp = new ArrayList<>();
        drawConnectedComponet(graph, v, comp, visited);
        comps.add(comp);
      }
    }

    System.out.println(comps);
  }

  public static void drawConnectedComponet(ArrayList<ArrayList<Edge>> graph, int src, ArrayList<Integer> comp,
      boolean[] visited) {

        visited[src] = true;
        comp.add(src);
        for(Edge edge : graph.get(src)){
          if(visited[edge.nbr] == false){
            drawConnectedComponet(graph, edge.nbr, comp, visited);
          }
        }

  }
}
