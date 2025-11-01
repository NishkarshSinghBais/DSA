import java.util.*;

public class graph {

    static class Edge{
        int src;
        int dest;

        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));


        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));

        graph[6].add(new Edge(6,5));
    }

    public static void bfs(ArrayList<Edge>[] graph, int V){
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[V];

        q.offer(0);

        while (!q.isEmpty()){
            int cur = q.poll();
            if ( !vis[cur] ){
                System.out.print(cur + " ");
                vis[cur] = true;
                for (int i = 0; i < graph[cur].size(); i++) {
                    Edge e = graph[cur].get(i);
                    q.offer(e.dest);
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge>[] graph, int cur, boolean[] vis){
        System.out.print(cur + " ");
        vis[cur] = true;

        for (int i = 0; i < graph[cur].size(); i++) {
            Edge e = graph[cur].get(i);
            if (!vis[e.dest]){
                dfs(graph, e.dest, vis);
            }
        }
    }

    public static void printAllPath(ArrayList<Edge>[] graph, boolean[] vis, int cur, String path, int target){
        if ( cur == target ){
            System.out.println(path);
            return;
        }
        for (int i = 0; i < graph[cur].size(); i++) {
            Edge e = graph[cur].get(i);
            if ( !vis[e.dest] ){
                vis[cur] = true;
                printAllPath(graph, vis, e.dest, path+e.dest, target);
                vis[cur] = false;
            }
        }
    }
    public static void main(String[] args) {

        int V = 7;

        boolean[] vis = new boolean[V];

        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        // Print 2`s Neighbours
//        for (int i = 0; i < graph[2].size(); i++) {
//            Edge e = graph[2].get(i);
//            System.out.println(e.src + " " + e.dest + " , " + e.wt);
//        }

//        bfs(graph, V);
//        System.out.println();
//        dfs(graph, 0, vis);

        int start = 0;
        int target = 5;

        printAllPath(graph, vis, start, "", target);

    }
}
