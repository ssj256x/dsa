package datastructures.exception;

/**
 * Exception for denoting overflow in a Queue
 */
public class QueueOverflowError extends Exception{
    public QueueOverflowError(String msg) {
        super(msg);
    }

    public QueueOverflowError() {

    }
}
