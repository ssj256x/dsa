package datastructures.interfaces;

/**
 * Interface for a Queue
 *
 * @param <T> - The type of the Queue.
 */
public interface Queue<T> {

    /**
     * To add data at the end of Queue.
     *
     * @param data - Data to be added.
     */
    void enqueue(T data);

    /**
     * To remove an element from the first of the Queue.
     *
     * @return The removed data.
     */
    T dequeue();

    /**
     * To get the data at the head of the Queue.
     *
     * @return The fetched data
     */
    T peekHead();

    /**
     * To get the data at the tail of the Queue.
     *
     * @return The fetched data.
     */
    T peekTail();

    /**
     * To check if the Queue is empty
     *
     * @return true or false based o result.
     */
    boolean isEmpty();

    /**
     * To check if the Queue is full.
     *
     * @return true or false based o result.
     */
    boolean isFull();
}
