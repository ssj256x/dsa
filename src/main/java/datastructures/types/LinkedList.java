package datastructures.types;

import datastructures.components.NodeSE;
import datastructures.interfaces.List;

import java.util.NoSuchElementException;

/**
 * Linked List with single ended nodes.
 *
 * @param <T> - Type of the Linked List
 */
public class LinkedList<T> implements List<T> {

    private NodeSE<T> head;
    private NodeSE<T> tail;
    private NodeSE<T> temp;
    private int size;

    public LinkedList() {
        head = null;
        tail = null;
        temp = null;
        size = 0;
    }

    @Override
    public void add(T data) {
        NodeSE<T> newNode = new NodeSE<>(data);

        if (head == null) head = tail = newNode;

        tail.next = newNode;
        tail = newNode;
        size++;
    }

    @Override
    public void addAtIndex(int index, T data) {
        checkIfInIndexRange(index, size);
        if (index == 0) {
            addAtFirst(data);
            return;
        }
        if (index == size() - 1) {
            addAtLast(data);
            return;
        }

        NodeSE<T> newNode = new NodeSE<>(data);
        NodeSE<T> current = head;
        NodeSE<T> prev = current;

        for (int i = 0; i < index; i++) {
            prev = current;
            current = current.next;
        }

        newNode.next = current;
        prev.next = newNode;
        size++;
    }

    @Override
    public void addAtFirst(T data) {
        NodeSE<T> newNode = new NodeSE<>(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    @Override
    public void addAtLast(T data) {
        NodeSE<T> newNode = new NodeSE<>(data);
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    @Override
    public T remove(T data) {
        return removeFromIndex(indexOf(data));
    }

    @Override
    public T removeFromIndex(int index) {
        checkIfInIndexRange(index, size);
        if (index == 0) removeFromFirst();

        temp = head;
        T data;

        for (int i = 0; i < index - 1; i++) temp = temp.next;

        data = temp.next.data;
        temp.next = temp.next.next;
        size--;

        return data;
    }

    @Override
    public T removeFromFirst() {
        T data = head.data;
        head = head.next;
        size--;
        return data;
    }

    @Override
    public T removeFromLast() {
        return removeFromIndex(size - 1);
    }

    @Override
    public T removeAll(T data) {
        if (!contains(data)) throw new NoSuchElementException();
        while (contains(data)) remove(data);
        return data;
    }

    @Override
    public T get(int index) {
        checkIfInIndexRange(index, size);
        temp = head;
        for (int i = 0; i < size; i++) temp = temp.next;
        return temp.data;
    }

    @Override
    public void setAtIndex(int index, T data) {
        checkIfInIndexRange(index, size);
        temp = head;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                temp.data = data;
                return;
            }
            temp = temp.next;
        }
    }

    @Override
    public int indexOf(T data) {
        temp = head;
        for (int i = 0; i < size; i++) {
            if (temp.data == data) return i;
            temp = temp.next;
        }
        throw new NoSuchElementException();
    }

    @Override
    public List<Integer> allIndicesOf(T data) {
        List<Integer> foundIndices = new LinkedList<>();
        for (int i = 0; i < size; i++) if (this.get(i).equals(data)) foundIndices.add(i);
        if (foundIndices.size() == 0) throw new NoSuchElementException();
        return foundIndices;
    }

    @Override
    public boolean contains(T data) {
        return checkIfContains(head, data) != null;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void reverse() {
        NodeSE<T> prev = null;
        NodeSE<T> current = head;
        NodeSE<T> next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    /**
     * Recursive function to check if the list contains an element.
     *
     * @param current - Current Node.
     * @param data    - Data to be compared.
     * @return The traversed node / recursive call
     */
    private NodeSE<T> checkIfContains(NodeSE<T> current, T data) {
        if (current == null || current.data.equals(data)) return current;
        return checkIfContains(current.next, data);
    }

    @Override
    public String toString() {
        if (head == null) return "[]";

        StringBuilder sb = new StringBuilder();
        temp = head;

        while (temp != null) {
            sb.append(temp);
            temp = temp.next;
            sb.append("->");
        }
        return sb.substring(0, sb.lastIndexOf(")") + 1);
    }
}
