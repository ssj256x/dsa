package datastructures.exception;

/**
 * Exception for denoting a removal operation on an empty stack
 */
public class StackUnderflowError extends Exception{
    public StackUnderflowError(String msg) {
        super(msg);
    }

    public StackUnderflowError() {

    }
}
