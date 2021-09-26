package datastructures.types;

import java.util.Arrays;
import java.util.Comparator;

@SuppressWarnings("unchecked")
public class MinHeap<T> {

    private int size;
    private final int maxSize;
    private final T[] heap;
    private static final int FRONT = 0;
    private final Comparator<? super T> comparator;

    public MinHeap(int maxSize, Comparator<? super T> comparator) {
        this.maxSize = maxSize;
        this.size = 0;
        this.heap = (T[]) new Object[maxSize];
        this.comparator = comparator;
//        heap[0] =
    }

    private int parent(int pos) {
        return pos / 2;
    }

    private int left(int pos) {
        return 2 * pos + 1;
    }

    private int right(int pos) {
        return 2 * pos + 2;
    }

    private void swap(int i, int j) {
        T temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void minHeapify(int node) {
        int left = left(node);
        int right = right(node);
        int smallest = node;

        if(left < size && comparator.compare(heap[left], heap[smallest]) < 0)
            smallest = left;
        if(right < size && comparator.compare(heap[right], heap[smallest]) < 0)
            smallest = right;

        if(smallest != node) {
            swap(smallest, node);
            minHeapify(smallest);
        }
    }

    public void insert(T data) {
        if(size >= maxSize) {
            System.out.println("Heap is Full!");
            return;
        }

        heap[++size] = data;
        int current = size;

        while(comparator.compare(heap[current], heap[parent(current)]) < 0) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public void buildMinHeap() {
        for (int i = size / 2; i >= 0; i--) minHeapify(i);
    }

    public Object peek() {
        return heap[FRONT];
    }

    public T extractMin() {
        T popped = heap[FRONT];
        swap(FRONT, size--);
        minHeapify(FRONT);
        return popped;
    }

    @Override
    public String toString() {
        return "MinHeap{" +
                "size=" + size +
                ", maxSize=" + maxSize +
                ", heap=" + Arrays.toString(heap) +
                ", comparator=" + comparator +
                '}';
    }
}