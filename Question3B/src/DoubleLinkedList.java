/**
 * Class Node used in Double Linked List
 * @param <E>
 */
class Node<E> {

    private E element;
    private Node<E> next;
    private Node<E> prev;

    /**
     * Node constructor with 3 parameters e for element, p for previous, n for next.
     * @param e
     * @param p
     * @param n
     */
    public Node(E e, Node<E> p, Node<E> n) {
        element = e;
        prev = p;
        next = n;
    }

    /**
     * Method that returns the element inside the node
     * @return
     */
    public E getElement() {
        return element;
    }

    /**
     * Get method to get the previous node
     * @return
     */
    public Node<E> getPrev() {
        return prev;
    }

    /**
     * Method to get next node
     * @return
     */
    public Node<E> getNext() {
        return next;
    }

    /**
     * Setter method to set the previous node to the input node.
     * This method becomes important later on in the swapNodes method.
     * @param p
     */
    public void setPrev(Node<E> p) {
        prev = p;
    }

    /**
     * Setter method that sets the next node to the input node.
     * Again the method becomes very handy in the swapNodes method.
     * @param n
     */
    public void setNext(Node<E> n) {
        next = n;
    }
}
public class DoubleLinkedList<E> {

    private Node<E> header; //header for the DLL
    private Node<E> header1; //header1 used within the getNode method
    private Node<E> trailer; //trailer for the DLL
    private int size = 0;

    /**
     * Constructor for the DLL. Creates a header, the header being a dummy node with null values. Header1 used for the getNode method.
     * Creates a trailer, the trailer node also being a dummy node with null values.
     * Calling the header.setNext method to set the next Node to be the trailer thus allowing us to insert nodes inbetween the header and trailer dummy nodes.
     */
    public DoubleLinkedList() {
        header = new Node<>(null, null, null);    //Create Header
        header1 = header;
        trailer = new Node<>(null, header, null);    //trailer is preceded by header
        header.setNext(trailer);                         //header is followed by trailer
    }

    /**
     * Getter method to obtain the size of the DLL list
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * Boolean method to check if the list is empty or not
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Method for returning the element for the first node within the list. If the list is empty return null
     * @return
     */
    public E first() {
        if (isEmpty()) return null;
        return header.getNext().getElement();           //First Element proceeding the header
    }

    /**
     * Method for returning the element in the last node of the DLL. If the list is empty return null
     * @return
     */
    public E last() {
        if (isEmpty()) return null;
        return trailer.getPrev().getElement();          //Last Element before the trailer
    }

    /**
     * Method for adding a node with element e to the beginning of the DLL
     * @param e
     */
    public void addFirst(E e) {
        addBetween(e, header, header.getNext());
    }

    /**
     * Method for adding a node with element e to the end of the DLL
     * @param e
     */
    public void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer);
    }

    /**
     * Method to remove the first node proceeding the header. If list is empty return null
     * @return
     */
    public E removeFirst() {
        if (isEmpty()) return null;
        return remove(header.getNext());
    }

    /**
     * Method to remove the last node preceding the trailer dummy node
     * @return
     */
    public E removeLast() {
        if (isEmpty()) return null;
        return remove(trailer.getPrev());
    }

    /**
     * Public method to swap two nodes inside a DLL.
     * @param list; list to swap
     * @param c1; first node index to swap
     * @param c2 ; second node index to swap with c1
     * @return
     */
    public void swap(DoubleLinkedList<E> list, int c1, int c2) {
        Node<E> n2 = list.getNode(c1);  //Assigning n2 to node at index c1
        Node<E> n3 = list.getNode(c2);  //Assigning n3 to node at index c2
        swapNode(n2, n3); //Swapping nodes
    }

    /**
     * Getter method to get Node at index n
     * @param n
     * @return
     */
    public Node<E> getNode(int n) {
        if (isEmpty()) throw new //If list is empty throw IllegalStateException
                IllegalStateException("List is empty");
                header1 = header; //Header 1 as a pointer
                while (n > 0) {
                    if (header1.getNext() != null) { //If we have not reached the trailer
                        header1 = header1.getNext(); //Increment pointer
                        n = n-1; //Decrement n until we reach n
                    } else {
                        throw new IllegalStateException("List does not have sufficient node");
                    }
                }
        return header1;
    }

    /**
     * Method from the book to add a node between two nodes.
     * @param e
     * @param predecessor
     * @param successor
     */
    private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        Node<E> newest = new Node<>(e, predecessor, successor); //Creating a new node between two other nodes.
        predecessor.setNext(newest); //Set the predecessor node's setNext to the new node
        successor.setPrev(newest); //Set successor setPrev to the new node
        size++;
    }

    /**
     * Method to remove a node
     * @param node
     * @return
     */
    private E remove(Node<E> node) {
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }

    /**
     * Method to swap node x and node y
     * @param x
     * @param y
     */
    private void swapNode(Node<E> x, Node<E> y) {
        if (x == y) { //If the two nodes are the same
            return;
        } else {
            //if they are adjacent nodes
            if (x.getNext() == y) {
                swapAdjacent(x, y);
            } else if (y.getNext() == x) {
                swapAdjacent(y, x);
            } else {
                Node<E> temp = x.getPrev();

                //Set x prev to y prev
                x.setPrev(y.getPrev());
                //Set y prev to temp (which == x.prev)
                y.setPrev(temp);
                //Get x.next in a temp node
                temp = (Node<E>) x.getNext();
                //set x.next to y.next
                x.setNext(y.getNext());
                //Set y.next to temp
                y.setNext(temp);
            }

            //Reattach Neighboring Nodes
            x.getPrev().setNext(x);
            x.getNext().setPrev(x);
            y.getPrev().setNext(y);
            y.getNext().setPrev(y);

        }

    }

    /**
     * Method to swap adjacent nodes
     * @param x
     * @param y
     */
    private void swapAdjacent(Node<E> x, Node<E> y) {
        x.setNext(y.getNext());
        y.setPrev(x.getPrev());
        x.setPrev(y);
        y.setNext(x);
    }

    /**
     * Boolean method to check if the node has has a previous node that is not header[
     * @param v
     * @return
     */
    private boolean hasPrev(Node<E> v) {
        return (v.getPrev() != header) && (v != header);
    }

    /**
     * Boolean method to check if the node has a next node that is not the trailer
     * @param v
     * @return
     */
    private boolean hasNext(Node<E> v) {
        return (v.getNext() != trailer) && (v != trailer);
    }


}