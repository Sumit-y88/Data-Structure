import java.util.*;

class Graph {
    private int V;                    // number of vertices
    private LinkedList<Integer> adj[]; // adjacency list

    Graph(int v) {
        V = v;
        adj = new LinkedList[V];
        for (int i = 0; i < v; i++)
            adj[i] = new LinkedList<>();
    }

    // Add edge
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // DFS Utility (recursive)
    void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int n : adj[v]) {
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    // DFS function
    void DFS(int start) {
        boolean visited[] = new boolean[V];
        DFSUtil(start, visited);
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);

        System.out.println("DFS Traversal:");
        g.DFS(0);
    }
}
