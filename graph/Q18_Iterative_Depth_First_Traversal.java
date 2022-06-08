import java.io.*;
import java.util.*;
// like we use queue in BFS, for itertive depth first search we use stack
// so it'll reduce time compare to recursive dfs
public class Q18_Iterative_Depth_First_Traversal {
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
           // here v1 is directing to v2 and v1 is directing to v1 so it is undirected
           // if only one vertex is directing then it'll called as directed graph
        }
  
        int src = Integer.parseInt(br.readLine());
  
        boolean[] visited = new boolean[vtces];
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(src, src + ""));

        while(st.size() > 0){
            Pair rem = st.pop();

            if(visited[rem.v] == true) continue;
            visited[rem.v] = true;

            System.out.println(rem.v + "@" + rem.psf);

            for(Edge e : graph.get(rem.v)){
                if(visited[e.nbr] == false){
                    st.push(new Pair(e.nbr, rem.psf + e.nbr));
                }
            }
        }

     }
}
