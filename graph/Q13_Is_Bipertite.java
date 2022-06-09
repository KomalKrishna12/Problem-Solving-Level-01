import java.util.*;
import java.io.*;

// graph will be bipertite if it devide into two sets and botha are exclusive mutual and includion
// means if graph is not cyclic then it will be bypertite
// if graph is cyclic and it has odd vertexes then it'll not bipertite
// if graph is cyclic and it has even vertexes then it'll be bipertite
public class Q13_Is_Bipertite {
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
        int level;

        Pair(int v, String psf, int level) {
            this.v = v;
            this.psf = psf;
            this.level = level;
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

        // we use to craete boolean array to get updated about visited verteces
        // here we use int array fill it with -1
        // if it is visited then store its level no
        int[] visited = new int[vtces];
        Arrays.fill(visited, -1);

        for (int v = 0; v < vtces; v++) {
            if (visited[v] == -1) {
                boolean isBipartite = checkIfGraphIsBipertite(graph, v, visited);
                if (isBipartite == false) {
                    System.out.println(false);
                    return;
                }
            }
        }

        System.out.println(true);
    }

    public static boolean checkIfGraphIsBipertite(ArrayList<ArrayList<Edge>> graph, int src, int[] visited) {
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(src, src + "", 0));

        while(queue.size() > 0){
            Pair remPair = queue.removeFirst();

            if(visited[remPair.v] != -1){
                if(visited[remPair.v] != remPair.level) return false;
            }
            else{
                 visited[remPair.v] = remPair.level;
            }

            for(Edge e : graph.get(remPair.v)){
                if(visited[e.nbr] == -1) queue.add(new Pair(e.nbr, remPair.psf + e.nbr, remPair.level + 1));
            }
        }
        return true;
    }
}
