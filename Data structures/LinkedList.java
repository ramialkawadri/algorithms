import java.util.NoSuchElementException;

public class LinkedList<E> {
    class Node {
        public E data;
        public Node next;
    }

    private Node head;
    
    public LinkedList() {
        head = null;
    }

    public Object getFirst() {
        if (head == null) throw new NoSuchElementException();
        return head.data;
    }

    public void addFirst(E element) {
        Node newNode = new Node();
        newNode.data = element;
        newNode.next = head;
        head = newNode;
    }

    public E removeFirst() {
        if (head == null) throw new NoSuchElementException();
        E element = head.data;
        head = head.next;
        return element;
    }
}
