package datastructures.tryout;

import datastructures.components.GNode;
import datastructures.types.MinHeap;

public class Dijkstra {
    public static void main(String[] args) {
        MinHeap<GNode> minHeap = new MinHeap<>(8, new GNode());
        minHeap.insert(new GNode(0, 5));
        minHeap.insert(new GNode(0, 3));
        minHeap.insert(new GNode(0, 16));
        minHeap.insert(new GNode(0, 11));
        minHeap.insert(new GNode(0, 6));
        minHeap.insert(new GNode(0, 7));
        minHeap.insert(new GNode(0, 4));
        minHeap.insert(new GNode(0, 1));

        System.out.println(minHeap);
    }
}
