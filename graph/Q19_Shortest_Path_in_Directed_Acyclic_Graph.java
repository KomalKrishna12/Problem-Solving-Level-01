import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Q19_Shortest_Path_in_Directed_Acyclic_Graph {
    static class Pair {
        int v;
        int wt;

        Pair(int v, int wt) {
            this.v = v;
            this.wt = wt;
        }
    }

    public static void main(String[] args) {
        int n = 6;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<Pair>());

        adj.get(0).add(new Pair(1, 2));
        adj.get(0).add(new Pair(4, 1));
        adj.get(1).add(new Pair(2, 3));
        adj.get(2).add(new Pair(3, 6));
        adj.get(4).add(new Pair(2, 2));
        adj.get(4).add(new Pair(5, 4));
        adj.get(5).add(new Pair(3, 1));

        shortestPath(adj, 0, n);
    }

    static void shortestPath(ArrayList<ArrayList<Pair>> adj, int src, int n) {

        Stack<Integer> st = new Stack<>();

        int[] minDis = new int[n];
        Arrays.fill(minDis, Integer.MAX_VALUE);

        boolean[] visited = new boolean[n];

        for (int v = 0; v < n; v++) {
            if (visited[v] == false) {
                topologicalSort(adj, v, visited, st);
            }
        }

        while(st.size() > 0){
            Integer i = st.pop();
            if(minDis[i] != Integer.MAX_VALUE){
                for(Pair p : adj.get(i)){
                    if(minDis[p.v] > minDis[i] + p.wt){
                        minDis[p.v] = minDis[i] + p.wt;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++)
        {
            if (minDis[i] == Integer.MAX_VALUE)
                System.out.print( "INF ");
            else
                System.out.print( minDis[i] + " ");
        }

    }

    static void topologicalSort(ArrayList<ArrayList<Pair>> adj, int src, boolean[] visited, Stack<Integer> st) {
        visited[src] = true;
        for(Pair p : adj.get(src)){
            if(visited[p.v] == false) topologicalSort(adj, p.v, visited, st);
        }
        st.push(src);
    }
}
