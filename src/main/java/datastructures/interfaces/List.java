package datastructures.interfaces;

/**
 * Simple List Interface with functional.
 *
 * @param <T>
 */
public interface List<T> {

    /**
     * To add a data to List.
     *
     * @param data - Data to be stored.
     */
    void add(T data);

    /**
     * To add a data at a particular index.
     *
     * @param index - index where data is supposed to be stored.
     * @param data  - Data to be added.
     */
    void addAtIndex(int index, T data);

    /**
     * To add data at the beginning of the list.
     *
     * @param data - Data to be added.
     */
    void addAtFirst(T data);

    /**
     * To add data at the end of the List.
     *
     * @param data - Data to be added.
     */
    void addAtLast(T data);

    /**
     * Removes the first occurrence passed data from the List.
     *
     * @param data - Data to be removed.
     * @return The removed data.
     */
    T remove(T data);

    /**
     * To remove the data from the passed index.
     *
     * @param index - The index of the data to be removed
     * @return The removed data
     */
    T removeFromIndex(int index);

    /**
     * Removes the first element from the List.
     *
     * @return The removed data.
     */
    T removeFromFirst();

    /**
     * To remove the last element from List
     *
     * @return The removed data.
     */
    T removeFromLast();

    /**
     * To remove a given data from the entire list.
     *
     * @param data - The data to be removed.
     * @return The removed data.
     */
    T removeAll(T data);

    /**
     * To get data at the given index from the List.
     *
     * @param index - Index of data to be received.
     */
    T get(int index);

    /**
     * To set an element at a given index.
     *
     * @param index - The index data to replace
     * @param data  - The data
     */
    void setAtIndex(int index, T data);

    /**
     * To return the index of the passed data.
     *
     * @param data - Data whose index is to be found
     * @return Index of the passed data
     */
    int indexOf(T data);

    /**
     * To find all indices of the passed data.
     *
     * @param data - The data whose indices are to be found.
     * @return List of found indices.
     */
    List<Integer> allIndicesOf(T data);

    /**
     * To check if a given data is present in the List.
     *
     * @param data - Data to be checked.
     * @return true or false based on data.
     */
    boolean contains(T data);

    /**
     * To clear the List of all data.
     */
    void clear();

    /**
     * To get the size of the list.
     *
     * @return The size of the List.
     */
    int size();

    /**
     * To check if the list is empty.
     *
     * @return true or false based on the result.
     */
    boolean isEmpty();

    /**
     * To reverse the order of elements in the List.
     */
    void reverse();

    /**
     * To check if the array is between 0 and 'last'
     *
     * @param index - THe passed index
     */
    default void checkIfInIndexRange(int index, int last) {
        if (index < 0 || index >= last) throw new IndexOutOfBoundsException();
    }
}
