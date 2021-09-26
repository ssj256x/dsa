package datastructures.interfaces;

/**
 * Interface for the Stack.
 *
 * @param <T> - The type of he Stack.
 */
public interface Stack<T> {

    /**
     * To add a data to the Stack.
     *
     * @param data - Data to be added.
     */
    void push(T data);

    /**
     * To remove the data from the Stack
     *
     * @return The removed data
     */
    T pop();

    /**
     * To check the data at the top of the stack.
     *
     * @return The fetched data.
     */
    T peek();

    /**
     * To check if the Stack is empty
     *
     * @return true or false based o result.
     */
    boolean isEmpty();

    /**
     * To check if the Stack is full.
     *
     * @return true or false based o result.
     */
    boolean isFull();
}
