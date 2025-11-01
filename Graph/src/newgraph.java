import java.util.*;

public class newgraph {

    static class Edge{

        int src;
        int dst;

        public Edge(int s, int d){
            this.src = s;
            this.dst = d;

        }
    }

    public static void createGraph(ArrayList<ArrayList<Integer>> adj, ArrayList<Edge> edges, int vertices){
        for (int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<>());
        }

            for (Edge edge : edges){
                adj.get(edge.src).add(edge.dst);
            }
    }

    // Q1. Print Graph

    public static ArrayList<ArrayList<Integer>> printGraph(ArrayList<ArrayList<Integer>> adj, int vertex){
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < adj.size(); i++) {
            ArrayList<Integer> neighbour = new ArrayList<>(adj.get(i));
            list.add(neighbour);
        }
        return list;
    }

    // Q2. Print Neighbor

    public static ArrayList<Integer> printNeighbour(ArrayList<ArrayList<Integer>> adj, int vertex){
        ArrayList<Integer> list = new ArrayList<>();
        for (int neighbor : adj.get(vertex)){
            list.add(neighbor);
        }
        return list;
    }

    // Q3. BFS

    public static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj, int V){
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] vis = new boolean[V];

        queue.offer(0);
        vis[0] = true;

        while ( !queue.isEmpty() ){
            int cur = queue.poll();
            list.add(cur);

            for (int neighbor : adj.get(cur)){
                if ( !vis[neighbor] ){
                    queue.offer(neighbor);
                    vis[neighbor] = true;
                }
            }
        }
        return list;
    }

    // Q4. DFS

    public static ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] vis = new boolean[adj.size()];
        dfs(0, adj, vis, list );
        return list;
    }
    public static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, ArrayList<Integer> list){
        vis[node] = true;
        list.add(node);

        for (int n : adj.get(node)){
            if ( !vis[n] ){
                dfs(n, adj, vis, list);
            }
        }
    }

    // Q5.

    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ArrayList<Edge> edges = new ArrayList<>();

        edges.add(new Edge(0,1));
        edges.add(new Edge(0,2));
        edges.add(new Edge(1,0));
        edges.add(new Edge(1,3));
        edges.add(new Edge(2,0));
        edges.add(new Edge(2,4));
        edges.add(new Edge(3,1));
        edges.add(new Edge(3,4));
        edges.add(new Edge(3,5));
        edges.add(new Edge(4,2));
        edges.add(new Edge(4,3));
        edges.add(new Edge(4,5));
        edges.add(new Edge(5,3));
        edges.add(new Edge(5,4));

        createGraph(adj, edges, 6);

        System.out.println(printNeighbour(adj, 4));

        System.out.println(printGraph(adj, 6));

        System.out.println(bfs(adj, 6));

        System.out.println(dfsOfGraph(adj));

    }
    
}
