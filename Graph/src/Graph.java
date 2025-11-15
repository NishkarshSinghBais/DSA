import java.util.*;

public class Graph {

    public static class Edge {
        int src;
        int dest;

        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(List<List<Integer>> adj, List<Edge> edges,
                                   int vertices, boolean directed){
        for (int i=0; i<vertices; i++){
            adj.add(new ArrayList<>());
        }
        for (Edge edge : edges){
            adj.get(edge.src).add(edge.dest);
            if ( !directed ){
                adj.get(edge.dest).add(edge.src);
            }
        }
    }

    public static void printGraph(List<List<Integer>> adj){
        for (int i=0; i<adj.size(); i++){
            System.out.println(i + " -> " + adj.get(i));
        }
    }

    public static List<List<Integer>> printNeighbours(List<List<Integer>> adj){
        List<List<Integer>> list = new ArrayList<>();
        for (int i=0; i<adj.size(); i++){
            List<Integer> neighbour = new ArrayList<>(adj.get(i));
            list.add(neighbour);
        }
        return list;
    }

    public static List<Integer> bfs(List<List<Integer>> adj){
        List<Integer> list = new ArrayList<>();
        boolean[] vis = new boolean[adj.size()];
        Queue<Integer> q = new LinkedList<>();

        q.offer(1);
        vis[1] = true;

        while ( !q.isEmpty() ){
            int curr = q.poll();
            list.add(curr);

            for (int neighbour : adj.get(curr)){
                if ( !vis[neighbour] ){
                    q.offer(neighbour);
                    vis[neighbour] = true;
                }
            }
        }
        return list;
    }

    public static List<Integer> dfs(List<List<Integer>> adj){
        List<Integer> list = new ArrayList<>();
        boolean[] vis = new boolean[adj.size()];
        helperDfs(1, adj, vis, list);
        return list;
    }

    public static void helperDfs(int node, List<List<Integer>> adj,
                                          boolean[] vis, List<Integer> list){
        vis[node] = true;
        list.add(node);

        for (int n : adj.get(node)){
            if ( !vis[n] ){
                helperDfs(n, adj, vis, list);
            }
        }
    }

    public static void main(String[] args) {
        int v = 8;
        List<List<Integer>> adj = new ArrayList<>();
        List<Edge> edges = new ArrayList<>();

        edges.add(new Edge(1, 2));
        edges.add(new Edge(1, 3));
        edges.add(new Edge(2, 4));
        edges.add(new Edge(2, 5));
        edges.add(new Edge(3, 6));
        edges.add(new Edge(6, 7));


        createGraph(adj, edges, v, false);
        List<Integer> dfs = dfs(adj);
        System.out.println(dfs);
    }
}
