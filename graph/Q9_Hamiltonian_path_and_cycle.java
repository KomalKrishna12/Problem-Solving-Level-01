import java.io.*;
import java.util.*;

// a path is hamilonian if it contains all the vertex
// and if a hamiltonian path end vertex is connected with an edge with src than it is a hamiltonian cycle
public class Q9_Hamiltonian_path_and_cycle {
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

        int src = Integer.parseInt(br.readLine());

        // here we use HashSet instead of boolean array to check that the vertex is
        // visited or not
        HashSet<Integer> visited = new HashSet<>();
        hamiltonian(graph, src, visited, src + "", src);
    }

    // osrc : original source to check that the last vertex of path nabour is src or
    // not
    // to check hamiltonian cycle
    public static void hamiltonian(ArrayList<ArrayList<Edge>> graph, int src, HashSet<Integer> visited,
            String psf, int osrc) {

        // visited size is less than graph size bcoz in path we send as adding src in calling time
        // while in visited we add src in the function
        // so visited hashset size will be less than graph size
        if (visited.size() == graph.size() - 1) {
            System.out.print(psf);

            boolean closeEdgeFound = false;
            for (Edge e : graph.get(src)) {
                if (e.nbr == osrc)
                    closeEdgeFound = true;

            }
            if (closeEdgeFound)
                System.out.println("*"); // means edge is their so hamiltonian cycle
            else
                System.out.println(".");

            return;
        }
        visited.add(src);
        for (Edge e : graph.get(src)) {
            if (visited.contains(e.nbr) == false) {
                hamiltonian(graph, e.nbr, visited, psf + e.nbr, osrc);
            }
        }
        visited.remove(src);
    }
}
