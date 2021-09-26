package datastructures.types;

import java.util.Arrays;
import java.util.Scanner;

public class Kruskal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();

        Graph graph = new Graph(v, e);

        while (e-- > 0) {
            graph.addEdge(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }

//        System.out.println(graph);

        graph.generateMST();
        graph.printGraph();
    }
}

class Edge implements Comparable<Edge> {
    int src;
    int dest;
    int weight;

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "src=" + src +
                ", dest=" + dest +
                ", weight=" + weight +
                '}';
    }
}

class Graph {
    private final int v;
    private final Edge[] edges;
    private final Edge[] result;
    private int currSize;

    Graph(int v, int e) {
        this.v = v;
        this.edges = new Edge[e];
        this.result = new Edge[v];
        this.currSize = 0;

        for (int i = 0; i < edges.length; i++)
            edges[i] = new Edge();

        for(int i = 0; i < result.length; i++)
            result[i] = new Edge();
    }

    public void addEdge(int src, int dest, int weight) {
        edges[currSize].src = src;
        edges[currSize].dest = dest;
        edges[currSize].weight = weight;
        currSize++;
    }

    public void generateMST() {

        Arrays.sort(edges);
        Disjoint disjoint = new Disjoint(v);

        int i = 0;
        int e = 0;

        while (e < v - 1) {
            Edge nextEdge = edges[i++];

            int x = disjoint.find(nextEdge.src);
            int y = disjoint.find(nextEdge.dest);

            if (x != y) {
                result[e++] = nextEdge;
                disjoint.union(x, y);
            }
        }
    }

    public void printGraph() {
        for (Edge e : result) {
            System.out.printf("%d -> %d = %d%n", e.src, e.dest, e.weight);
        }
    }

    @Override
    public String toString() {
        return "Graph{" +
                "v=" + v +
                ", edges=" + Arrays.toString(edges) +
                ", result=" + Arrays.toString(result) +
                ", currSize=" + currSize +
                '}';
    }
}

class Node {
    int parent;
    int rank;

    Node(int parent, int rank) {
        this.parent = parent;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Node{" +
                "parent=" + parent +
                ", rank=" + rank +
                '}';
    }
}

class Disjoint {
    private final Node[] parents;

    Disjoint(int size) {
        parents = new Node[size + 1];

        for (int i = 0; i < parents.length; i++)
            parents[i] = new Node(-1, 0);
    }

    public int find(int v) {
        if (parents[v].parent != -1)
            parents[v].parent = find(parents[v].parent);
        return v;
    }

    public void union(int u, int v) {

        int uRoot = find(u);
        int vRoot = find(v);

        if (uRoot == vRoot) return;

        if (parents[uRoot].rank > parents[vRoot].rank)
            parents[vRoot].parent = uRoot;
        else if (parents[uRoot].rank < parents[vRoot].rank)
            parents[uRoot].parent = vRoot;
        else {
            parents[uRoot].parent = vRoot;
            parents[vRoot].rank++;
        }
    }

    @Override
    public String toString() {
        return "Disjoint{" +
                "parents=" + Arrays.toString(parents) +
                '}';
    }
}