package datastructures.exception;

/**
 * Error to denote if the Queue is empty and a removal operation is attempted
 */
public class QueueUnderflowError extends Exception {
    public QueueUnderflowError(String msg) {
        super(msg);
    }

    public QueueUnderflowError() {

    }
}
