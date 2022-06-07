import java.io.*;
import java.util.*;
// This is also BFS in the form of spread infection
// so given graph represting person and their connectivity
// given source perwson means it is affected in 1 unit of time
// given t we have to count how many people get infected in t time
// so we use BFS
// whenever wee mark any person as infected then increase the count and add their nabours
// when time exceed the t time then simple break and print count of total no of infected ppl
public class Q14_Spread_Of_Infection {
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
         int time;
         Pair(int v, int time){
             this.v = v;
             this.time = time;
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
        }
  
        int src = Integer.parseInt(br.readLine());
        int t = Integer.parseInt(br.readLine());
        
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        int[] visited = new int[vtces];
        queue.add(new Pair(src, 1));
        int count = 0; // count infected people

        while(queue.size() > 0){
            Pair remPair = queue.removeFirst();

            if(visited[remPair.v] != 0){
                // means this person is already infected so continue
                continue;
            }
            visited[remPair.v] = remPair.time;
            if(remPair.time > t) break; // means time exceed so break
            count++; // increase count of infected people and add their nebours

            for(Edge e : graph.get(remPair.v)){
                if(visited[e.nbr] == 0) queue.add(new Pair(e.nbr, remPair.time + 1));
            }
        }

        System.out.println(count);
     }
}
