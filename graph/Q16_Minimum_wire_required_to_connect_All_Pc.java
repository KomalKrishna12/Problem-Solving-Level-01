import java.io.*;
import java.util.*;
// Prim's algorithmn
// here we use MST (Minimum Spanning Tree)
// it is simlar like DIJktra ALgo
// but here we use acquired vertex instead of psf so it'll add the conecetd vertex
// in wt it'll give wt of current edge
public class Q16_Minimum_wire_required_to_connect_All_Pc {
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
    static class Pair implements Comparable<Pair>{
        int v;
        int av;
        int wt;
        Pair(int v, int av, int wt){
            this.v = v;
            this.av = av;
            this.wt = wt;
        }
        @Override
        public int compareTo(Q16_Minimum_wire_required_to_connect_All_Pc.Pair o) {
            return this.wt - o.wt;
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
            graph.get(v2).add(new Edge(v1, v1, wt));
        }

        boolean[] visited = new boolean[vtces];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        // intially it started from vertex 0 and it is starting vertex so it's prev vertex which is 
        // acquiring vertex is -1 and wt is 0
        pq.add(new Pair(0, -1, 0));

        while(pq.size() > 0){
            Pair rem = pq.remove();

            if(visited[rem.v] == true) continue;

            visited[rem.v] = true;

            if(rem.av != -1){
                System.out.println("[" + rem.v + "-" + rem.av + "@" + rem.wt + "]");
            }

            for(Edge e : graph.get(rem.v)){
                if(visited[e.nbr] == false){
                    // in place of av we pass rem vertex becoz that will be it's source vertex
                    pq.add(new Pair(e.nbr, rem.v, e.wt));
                }
            }
        }
    }
}
