package datastructures.types;

import datastructures.interfaces.List;

import java.util.NoSuchElementException;

@SuppressWarnings("unchecked")
public class DynamicArray<T> implements List<T> {

    private T[] array;
    private int last;
    private int size;

    public DynamicArray() {
        array = (T[]) new Object[10];
        size = array.length;
        last = 0;
    }

    @Override
    public void add(T data) {
        if (array.length > size - 1) expandArray();
        array[last++] = data;
    }

    @Override
    public void addAtIndex(int index, T data) {

        checkIfInIndexRange(index, last);

        if (index == size - 1) {
            add(data);
            return;
        }
        shiftArrayElementsForward(index);
        array[index] = data;
        last++;
    }

    @Override
    public void addAtFirst(T data) {
        shiftArrayElementsForward(0);
        array[0] = data;
        last++;
    }

    @Override
    public void addAtLast(T data) {
        add(data);
    }

    @Override
    public T remove(T data) {
        return removeFromIndex(indexOf(data));
    }

    @Override
    public T removeFromIndex(int index) {

        checkIfInIndexRange(index, last);

        T data = array[index];
        shiftArrayElementsBackward(index);
        last--;
        return data;
    }

    @Override
    public T removeFromFirst() {
        return removeFromIndex(0);
    }

    @Override
    public T removeFromLast() {
        T data = array[last - 1];
        array[last] = null;
        last--;
        return data;
    }

    @Override
    public T removeAll(T data) {
        List<Integer> allIndices = allIndicesOf(data);
        for (int i = 0; i < allIndices.size(); i++) removeFromIndex(allIndices.get(i));
        return data;
    }

    @Override
    public T get(int index) {
        checkIfInIndexRange(index, last);
        return array[index];
    }

    @Override
    public void setAtIndex(int index, T data) {
        checkIfInIndexRange(index, last);
        shiftArrayElementsForward(index);
        array[index] = data;
        last++;
    }

    @Override
    public int indexOf(T data) {
        for (int i = 0; i < last; i++) {
            if (array[i].equals(data)) return i;
        }
        throw new NoSuchElementException();
    }

    @Override
    public List<Integer> allIndicesOf(T data) {
        List<Integer> allIndices = new DynamicArray<>();
        for (int i = 0; i < last; i++) if (array[i].equals(data)) allIndices.add(i);
        if (allIndices.size() == 0) throw new NoSuchElementException();
        return allIndices;
    }

    @Override
    public boolean contains(T data) {
        for (int i = 0; i < last; i++) if (array[i].equals(data)) return true;
        return false;
    }

    @Override
    public void clear() {
        last = 0;
        array = null;
    }

    @Override
    public int size() {
        return last;
    }

    @Override
    public boolean isEmpty() {
        return last == 0 || array == null;
    }

    @Override
    public void reverse() {
        int head = 0;
        int tail = last;
        T temp;
        for (int i = 0; i < tail / 2; i++) {
            temp = this.get(head);
            this.setAtIndex(head, this.get(tail));
            this.setAtIndex(tail, temp);
            head++;
            tail--;
        }
    }

    /**
     * To expand the array if he array gets full and increase it to twice it's current size
     */
    private void expandArray() {
        T[] newArray = (T[]) new Object[2 * size];
        System.arraycopy(array, 0, newArray, 0, size);
        size = newArray.length;
        array = newArray;
    }

    /**
     * To shift the array elements forward from the given index
     *
     * @param index - The passed index
     */
    private void shiftArrayElementsForward(int index) {
        if (index + 1 == size) expandArray();
        if (last - index >= 0) System.arraycopy(array, index, array, index + 1, last - index);
    }

    /**
     * To shift array elements backwards from the given index
     *
     * @param index - The passed index
     */
    private void shiftArrayElementsBackward(int index) {
        if (last + 1 - index >= 0) System.arraycopy(array, index + 1, array, index, last + 1 - index);
    }

    @Override
    public String toString() {
        if (this.isEmpty()) return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < last; i++) {
            if (i == last - 1) {
                sb.append(array[i]).append("]");
                break;
            }
            sb.append(", ");
        }

        sb.append("LAST : ")
                .append(last)
                .append(", SIZE : ")
                .append(size);

        return new String(sb);
    }
}
