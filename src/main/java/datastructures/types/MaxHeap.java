package datastructures.types;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO : Make an interface and generalize the use of heap
 */
public class MaxHeap {

    private int size;
    private int maxSize;
    private List<Integer> maxHeap;

    MaxHeap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        this.maxHeap = new ArrayList<>();
        maxHeap.add(Integer.MAX_VALUE);
    }

    MaxHeap(List<Integer> heap, int maxSize) {
        this.maxHeap = heap;
        this.maxSize = maxSize;
        this.size = heap.size();
        heap.add(0, Integer.MAX_VALUE);
    }

    private int parent(int pos) {
        return pos / 2;
    }

    private int leftChild(int pos) {
        return 2 * pos;
    }

    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    private boolean isLeaf(int pos) {
        return pos >= (size / 2) && pos <= size;
    }

    private void swap(int i, int j) {
        int temp = maxHeap.get(i);
        maxHeap.set(i, maxHeap.get(j));
        maxHeap.set(j, temp);
    }

    /**
     * TODO : There is an issue when this function is called on a given list
     * @param pos - pos
     */
    private void maxHeapify(int pos) {
        if (isLeaf(pos)) return;

        int left = leftChild(pos);
        int right = rightChild(pos);

        if (maxHeap.get(pos) < maxHeap.get(left) || maxHeap.get(pos) < maxHeap.get(right)) {
            if (maxHeap.get(left) > maxHeap.get(right)) {
                swap(left, pos);
                maxHeapify(left);
            } else {
                swap(right, pos);
                maxHeapify(right);
            }
        }
    }

    public void maxHeapify1(int pos) {
        int left = 2 * pos;
        int right = 2 * pos + 1;
        int n = maxHeap.size();
        int largest = pos;

        if(left < n && maxHeap.get(left) > maxHeap.get(largest))
            largest = left;

        if(right < n && maxHeap.get(right) > maxHeap.get(largest))
            largest = right;

        if(largest != pos) {
            swap(pos, largest);
            maxHeapify1(largest);
        }
    }

    public void buildMaxHeap() {
        for (int i = size / 2; i > 0; i--) {
            maxHeapify1(i);
        }
    }

    public void insert(Integer data) {
        if (size == maxSize) throw new IndexOutOfBoundsException();

        maxHeap.add(data);
        size++;
        int current = size;

        while (maxHeap.get(current) > maxHeap.get(parent(current))) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public Integer peekMax() {
        return maxHeap.get(1);
    }

    public void restMaxSizeTo(int newSize) {
        if(newSize < size) throw new UnsupportedOperationException("New max size cannot be less than current size of heap");
        this.maxSize = newSize;
    }

    /**
     * Algorithm for heap sort:
     *  1. Build max heap
     *  2. Swap the max element (i.e. heap[0] with last element
     *  3. Decrease size of heap by 1 and maxHeapify at the first element of heap.
     *  4. Repeat until the size of list is equal to 1.
     *
     *  In this way the entire array will be sorted in ascending order
     */
    public void sort() {
        int heapSize = size;
        buildMaxHeap();
        for(int i = size - 1; i > 1; i--) {
            swap(i, 1);
            size--;
            maxHeapify(1);
        }
        size = heapSize;
    }

    @Override
    public String toString() {
        return "Heap{" +
                "size=" + size +
                ", maxSize=" + maxSize +
                ", maxHeap=" + maxHeap +
                '}';
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(7);
        list.add(4);
        list.add(3);
        list.add(6);
        list.add(5);
        list.add(10);

        MaxHeap heap = new MaxHeap(list,7);
//        heap.insert(1);
//        heap.insert(7);
//        heap.insert(4);
//        heap.insert(3);
//        heap.insert(6);
//        heap.insert(5);
//        heap.insert(10);
        heap.buildMaxHeap();
        System.out.println(heap);
    }

}
