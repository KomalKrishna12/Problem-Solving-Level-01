// we have given vertices in the name of students and edges in form of group
// given k means k groups
// now we have to make pairs of 2 student or vertices so that both student from diff groups
// so first find all paths using previous code and than using nested for loop 
// find all pairs
import java.io.*;
import java.util.ArrayList;

public class Q8_Perfect_Friends {
    public static class Edge {
        int v;
        int n;

        Edge(int v, int n) {
            this.v = v;
            this.n = n;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (int e = 0; e < k; e++) {
            String line = br.readLine();
            String[] parts = line.split(" ");

            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);

            graph.get(v1).add(new Edge(v1, v2));
            graph.get(v2).add(new Edge(v2, v1));

            ArrayList<ArrayList<Integer>> comps = new ArrayList<>();

            boolean[] visited = new boolean[n];
            for (int v = 0; v < n; v++) {
                if (visited[v] == false) {
                    ArrayList<Integer> comp = new ArrayList<>();
                    drawConnectedComponet(graph, v, comp, visited);
                    comps.add(comp);
                }
            }
            
            int pairs = 0;

            for(int i = 0; i < comps.size(); i++){
                for(int j = i + 1; j < comps.size(); j++){
                    pairs += comps.get(i).size() * comps.get(j).size();
                }
            }

            System.out.println(pairs);
        }
    }
    public static void drawConnectedComponet(ArrayList<ArrayList<Edge>> graph, int src, ArrayList<Integer> comp,
      boolean[] visited) {

        visited[src] = true;
        comp.add(src);
        for(Edge edge : graph.get(src)){
          if(visited[edge.n] == false){
            drawConnectedComponet(graph, edge.n, comp, visited);
          }
        }

  }
}
