package datastructures.types.graphs;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ArticulationPoint {

    public static void main(String[] args) {
        System.out.println("Articulation points in first graph ");
        Graph g1 = new Graph(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
//        g1.findArticulationPoints();
        g1.findBridges();
        System.out.println();

        System.out.println("Articulation points in Second graph");
        Graph g2 = new Graph(4);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(2, 3);
//        g2.findArticulationPoints();
        g2.findBridges();
        System.out.println();

        System.out.println("Articulation points in Third graph ");
        Graph g3 = new Graph(7);
        g3.addEdge(0, 1);
        g3.addEdge(1, 2);
        g3.addEdge(2, 0);
        g3.addEdge(1, 3);
        g3.addEdge(1, 4);
        g3.addEdge(1, 6);
        g3.addEdge(3, 5);
        g3.addEdge(4, 5);
//        g3.findArticulationPoints();
        g3.findBridges();


    }
}

class Graph {
    private final int n;
    private final LinkedList<Integer>[] graph;
    private int time;

    Graph(int n) {
        this.n = n;
        this.graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        time = 0;
    }

    void addEdge(int u, int v) {
        graph[u].add(v);
        graph[v].add(u);
    }

    /**
     * This function finds all articulation points and prints them
     */
    void findArticulationPoints() {
        int[] disc = new int[n];
        Arrays.fill(disc, -1);
        int[] low = new int[n];
        Arrays.fill(low, -1);
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        boolean[] ap = new boolean[n];
        time = 0;
        for (int i = 0; i < n; i++) {
            if (disc[i] == -1)
                dfs(i, disc, low, parent, ap);
        }

        for (int i = 0; i < n; i++) {
            if (ap[i])
                System.out.print(i + " ");
        }
    }

    /**
     * The following algorithm is finding Articulation Points in a graph.
     * <p>
     * When the function starts the current disc[u] and the low[u] is marked with
     * value of time as this is the earliest it was discovered and it will be same for
     * low[u]
     * <p>
     * We set the number of children for this node to be 0 and then iterate over the subgraph
     * of that node.
     * <p>
     * If it is not discovered we increase the children by 1, mark the parent of this node v
     * as u, i.e. parent[v] = u, then we again call dfs on this node, this ends when all the nodes
     * in the subgraph are visited, we then store the low value for this node w.r.t. to the root
     * for the sub graph u and chose the min(low[u], low[v]). Now if this is a root node and the
     * number of children > 1 we mark this as the articulation point in ap[u]. If its not parent
     * and the low[v] >= disc[u] we have a "back edge" and we mark ap[u] as true.
     * <p>
     * If the node was discovered and the node is the parent of u then we store the min(low[u], disc[v])
     * <p>
     * There are 2 important conditions for checking if a node is an articulation point
     * 1. If a node is a root node and the number of children > 1.
     * <p>
     * 2. If node u is not a root node of DFS tree and it has a child v such that no vertex
     * in the subtree rooted at v has a back edge to one of the ancestors of u
     *
     * @param u      - Current node being traversed.
     * @param disc   - Array storing the discovery time of a node. -1 being undiscovered.
     * @param low    - For tracking back edge of node.
     * @param parent - Stores the parent node for the given node.
     * @param ap     - Stores the articulation point after complete traversal.
     */
    void dfs(int u, int[] disc, int[] low, int[] parent, boolean[] ap) {
        disc[u] = low[u] = time++;
        int children = 0;

        for (int v : graph[u]) {
            if (disc[v] == -1) {
                children++;
                parent[v] = u;
                dfs(v, disc, low, parent, ap);
                low[u] = Math.min(low[u], low[v]);
                if (parent[u] == -1 && children > 1)
                    ap[u] = true;
                else if (parent[u] != -1 && low[v] >= disc[u]) // check for back edge
                    ap[u] = true;
            } else if (v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    void findBridges() {
        int[] disc = new int[n];
        Arrays.fill(disc, -1);
        int[] low = new int[n];
        Arrays.fill(low, -1);
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        List<Pair<Integer, Integer>> bridges = new ArrayList<>();
        time = 0;
        for (int i = 0; i < n; i++) {
            if (disc[i] == -1)
                dfs(i, disc, low, parent, bridges);
        }

        System.out.println("Bridges : " + bridges);
    }

    void dfs(int u, int[] disc, int[] low, int[] parent, List<Pair<Integer, Integer>> bridges) {
        disc[u] = low[u] = time++;

        for (int v : graph[u]) {
            if (disc[v] == -1) {
                parent[v] = u;
                dfs(v, disc, low, parent, bridges);
                low[u] = Math.min(low[v], low[u]);

                if (low[v] > disc[u])
                    bridges.add(new Pair<>(u, v));

            } else if (v != parent[u])
                low[u] = Math.min(low[u], disc[v]);
        }
    }
}

