// to print all path we simply take a string variable and add src in it
// after visiting nbr mark it as not visited so that next path can be found
import java.util.*;
import java.io.*;

public class Q3_Print_all_paths_using_Depth_First_Search {
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
        int dest = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[vtces];
        printAllPaths(graph, src, dest, visited, src + "");
    }

    public static void printAllPaths(ArrayList<ArrayList<Edge>> graph, int src, int dest, boolean[] visited,
            String psf) {
            if(src == dest) {
                System.out.println(psf);
                return;
            }

            visited[src] = true;
            for(Edge edge : graph.get(src)){
                if(visited[edge.nbr] == false){
                    printAllPaths(graph, edge.nbr, dest, visited, psf + edge.nbr);
                }
            }
            visited[src] = false;
    }
}
