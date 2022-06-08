import java.util.*;
import java.io.*;

// Topological sort
// now we have dircted graph
// we have to write them in that order if u and v is edge and u is directing to v
// that means u is dependent on v so firstly print v then u
// so we use same get connected method
// run loop for all vetex
// after marking adding in postorder we add src ito stack
// if we print in postorder their are chances of not dependent vertex after any edge so we use atack
// so we get correct order
public class Q17_Order_of_Compilation {
    static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
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
        }

        boolean[] visited = new boolean[vtces];
        Stack<Integer> st = new Stack<>();
        for (int v = 0; v < vtces; v++) {
            if (visited[v] == false) {
                topologicalSort(graph, v, visited, st);
            }
        }

        while (st.size() > 0) {
            System.out.println(st.pop());
        }
    }

    public static void topologicalSort(ArrayList<ArrayList<Edge>> graph, int src, boolean[] visited,
            Stack<Integer> st) {
        visited[src] = true;
        for(Edge e : graph.get(src)){
            if(visited[e.nbr] == false){
                topologicalSort(graph, e.nbr, visited, st);
            }
        }        
        st.push(src);
    }
}
