import java.util.ArrayList;

public class Q1_Graph_and_its_representation {

    public static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static void main(String[] args) {

        int vces = 7;

        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

        for(int i = 0; i < vces; i++){
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(new Edge(0, 1, 10));
        graph.get(1).add(new Edge(1, 0, 10));

        graph.get(0).add(new Edge(0, 3, 10));
        graph.get(3).add(new Edge(3, 0, 10));

        graph.get(1).add(new Edge(1, 2, 10));
        graph.get(2).add(new Edge(2, 1, 10));

        graph.get(2).add(new Edge(2, 3, 10));
        graph.get(3).add(new Edge(3, 2, 10));

        graph.get(3).add(new Edge(3, 4, 10));
        graph.get(4).add(new Edge(4, 3, 10));

        graph.get(4).add(new Edge(4, 5, 10));
        graph.get(5).add(new Edge(5, 4, 10));

        graph.get(5).add(new Edge(5, 6, 10));
        graph.get(6).add(new Edge(6, 5, 10));

        graph.get(4).add(new Edge(4, 6, 10));
        graph.get(6).add(new Edge(6, 4, 10)); 

    }
}
