package datastructures.components;

/**
 * Double ended node with data, next and previous pointers.
 */
public class NodeDE<T> {
    public T data;
    public NodeDE<T> next;
    public NodeDE<T> prev;

    public NodeDE(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(").append(data).append(")");
        return new String(sb);
    }
}
