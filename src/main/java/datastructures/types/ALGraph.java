package datastructures.types;

import java.util.Queue;

/**
 * A Graph using Adjacency List
 */
public class ALGraph {
    private final int v;
    private final java.util.LinkedList<Integer>[] graph;

    public ALGraph(int v) {
        this.v = v;
        graph = new java.util.LinkedList[v];
        for(int i = 0; i < v; i++) {
            graph[i] = new java.util.LinkedList<>();
        }
    }

    public void addEdge(int u, int w) {
        graph[u].add(w);
    }

    public void bfs(int s) {
        boolean[] visited = new boolean[v];
        Queue<Integer> queue = new java.util.LinkedList<>();
        visited[s] = true;
        queue.add(s);

        while (!queue.isEmpty()) {
            s = queue.poll();
            System.out.print(s + " ");

            java.util.LinkedList<Integer> adjList = graph[s];

            for(int n : adjList) {
                if(!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        ALGraph graph;

        graph = new ALGraph(6);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,3);
        graph.addEdge(1,3);
        graph.addEdge(2,3);
        graph.addEdge(2,4);
        graph.addEdge(2,0);
        graph.addEdge(3,1);
        graph.addEdge(3,2);
        graph.addEdge(3,5);
        graph.bfs(0);
    }
}
