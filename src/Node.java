import java.util.List;

/**
 * A class encapsulating a single node of
 * a linked array list
 * @param <T>
 */
public class Node<T> {
    /**
     * An array containing the data in this node
     */
    private T[] data;

    /**
     * A pointer to the previous node in this list
     */
    private Node<T> prev;

    /**
     * A pointer to the next node in this list
     */
    private Node<T> next;

    /**
     * A constructor for an empty node
     * @param size the size of the array in this node
     */
    public Node(int size) {
        this.data = (T[]) new Object[size];
    }

    /**
     * A constructor for a node with one element
     * @param size the size of the array in this node
     * @param elem a single element to put in this node
     */
    public Node(int size, T elem) {
        this.data = (T[]) new Object[size];
        this.data[0] = elem;
    }

    /**
     * A constructor for a node with multiple elements
     * @param size the size of the array in this node
     * @param elems an array of elements to put in this node
     */
    public Node(int size, T[] elems) {
        this.data = (T[]) new Object[size];
        System.arraycopy(elems, 0, this.data, 0, elems.length);
    }

    /**
     * A constructor for a node with multiple elements
     * @param size the size of the array in this node
     * @param elems a list of elements to put in this node
     */
    public Node(int size, List<T> elems) {
        this.data = (T[]) new Object[size];
        System.arraycopy(elems.toArray(), 0, this.data, 0, elems.size());
    }
}
