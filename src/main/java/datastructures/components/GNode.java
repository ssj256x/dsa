package datastructures.components;

import java.util.Comparator;

public class GNode implements Comparator<GNode> {

    int node;
    int cost;

    public GNode() {
        node = 0;
        cost = 0;
    }

    public GNode(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compare(GNode o1, GNode o2) {
        return Integer.compare(o1.cost, o2.cost);
    }

    @Override
    public String toString() {
        return "GNode{" +
                "node=" + node +
                ", cost=" + cost +
                '}';
    }
}
