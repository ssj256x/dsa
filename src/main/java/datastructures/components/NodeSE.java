package datastructures.components;

/**
 * Single ended node with data and next pointers.
 */
public class NodeSE<T> {
    public T data;
    public NodeSE<T> next;

    public NodeSE(T data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(").append(data).append(")");
        return new String(sb);
    }
}
