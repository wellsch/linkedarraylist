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
     * The number of elements in this arraylist
     */
    private int size;

    /**
     * A constructor for an empty node
     * @param size the size of the array in this node
     */
    Node(int size) {
        this.data = (T[]) new Object[size];
        this.size = 0;
    }

    /**
     * A constructor for a node with one element
     * @param size the size of the array in this node
     * @param elem a single element to put in this node
     */
    Node(int size, T elem) {
        this.data = (T[]) new Object[size];
        this.data[0] = elem;
        this.size = 1;
    }

    /**
     * Returns the next node in the linked array list
     *
     * @return the next node in the linked array list
     */
    Node<T> getNext() {
        return next;
    }

    /**
     * Returns the previous node in the linked array list
     *
     * @return the previous node in the linked array list
     */
    Node<T> getPrev() {
        return prev;
    }

    /**
     * Sets next to the input node
     *
     * @param next the next node in the list
     */
    void setNext(Node<T> next) {
        this.next = next;
    }

    /**
     * Set prev to the input node
     *
     * @param prev the previous node in the list
     */
    void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    /**
     * Adds an element to the end of this array.
     *
     * @param elem an element to be added to the end
     * @return the node to which the elem is added
     */
    Node<T> add(T elem) {
        // if this node is full
        if (this.size == this.data.length) {
            // add to next node
            if (this.next != null) {
                return this.next.add(elem);
            }
            // create new next node
            else {
                this.next = new Node<>(this.size, elem);
                return this.next;
            }
        }
        // insert at proper spot
        else {
            this.data[size] = elem;
            this.size++;
            return this;
        }
    }

    /**
     * Adds an element at the input index.
     *
     * @param idx the desired index for
     *           the element to be added.
     * @param elem the element to be added.
     * @return the node to which the element is added.
     * @throws IndexOutOfBoundsException if the index is
     * not a valid index in the array.
     */
    Node<T> add(int idx, T elem) throws IndexOutOfBoundsException {
        // shift to next node if this node is full and idx is further
        if (idx > this.data.length && this.data.length == this.size) {
            return this.next.add(idx - this.size, elem);
        }
        // throw exception if it's too far and this node is not full
        else if (idx > this.size) {
            throw new IndexOutOfBoundsException("");
        }
        // can relegate to the add method if we're adding to the end
        else if (idx == this.size) {
            return this.add(elem);
        }
        // otherwise iterate through elements
        else {
            // shift elements
            T temp = elem;
            for (int i = idx + 1; i <= this.size; i++) {
                this.data[i - 1] = temp;
                temp = this.data[i];
            }
            this.data[this.size] = temp;
            this.size++;
            return this;
        }
    }


}
