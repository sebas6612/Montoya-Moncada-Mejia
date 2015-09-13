/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package comun;

/**
 *
 * @author usuario
 */
public class Node<E> {

    /**
     * The item stored in this node.
     */
    private E item;
    /**
     * The node following this one.
     */
    private Node<E> next;

    /**
     * Put item in a node with no next node.
     */
    public Node(E item) {
        this.item = item;
        next = null;
    }

    /**
     * Put item in a node with the specified next node.
     */
    public Node(E item, Node<E> next) {
        this.item = item;
        this.next = next;
    }

    /**
     * Return the item stored in this node.
     */
    public E getItem() {
        return item;
    }

    /**
     * Return the next node.
     */
    public Node<E> getNext() {
        return next;
    }

    /**
     * Replace the item stored in this node.
     */
    public void setItem(E item) {
        this.item = item;
    }

    /**
     * Set the next node.
     */
    public void setNext(Node<E> next) {
        this.next = next;
    }
}
