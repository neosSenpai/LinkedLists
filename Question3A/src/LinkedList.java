public class LinkedList {
    Node head;

    /**
     * Appending the input data to the end of the linked list.
     * @param data
     */
    public void append(int data) {
        //If there is no head to the linked list. Create a new head.
        if (head == null) {
            head = new Node(data);
            return;
        }
        /*
         * Node current used as a pointer and transcends down the linked list
         * until current.next is equal to null thus indicating the end of the
         * linked list. Once the end is reached add the input data to the new node.
         */
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(data);
    }

    /**
     * Method to prepend data to the Linked List
     * @param data
     */
    public void prepend(int data) {
        Node newHead = new Node(data); //creating a newHead node
        newHead.next = head; //basically moves the head node to newHead.next thus no longer making it the headNode
        head = newHead; //because the head node was modes newHead becomes the new head node and thus we are required to assign head to newHead

    }

    /**
     * Method to the input data
     * @param data
     */
    public void deleteWithValue(int data) {
        if (head == null) return;
        Node current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    /**
     * Method to swap node x and node y
     * @param x
     * @param y
     */
    public void swapNodes(int x, int y) {
        if (head == null) return; //If there is no head in the Linked list thus the list is empty
        if (x == y) return;

        Node currentX = head;
        Node prevX = null;
        //Searching for X
        while (currentX.next != null && currentX.data != x) {
            prevX = currentX;
            currentX = currentX.next;
        }

        Node currentY = head;
        Node prevY = null;
        //Searching for Y
        while (currentY.next != null && currentY.data != y) {
            prevY = currentY;
            currentY = currentY.next;
        }
        //If either X or Y is not within the Linked List
        if (currentX == null || currentY == null) {
            return;
        }
        //If
        if (prevX == null) {
            head = currentY;
        } else {
            prevX.next = currentY;
        }
        if (prevY == null) {
            head = currentX;
        } else {
            prevY.next = currentX;
        }

        //Swap
        Node temp = currentX.next;
        currentX.next = currentY.next;
        currentY.next = temp;

    }

    /**
     * Method to print the Linked list
     */
    public void printList()
    {
        Node current = head;
        while (current != null)
        {
            System.out.print(current.data +" ");
            current = current.next;
        }
    }

}

