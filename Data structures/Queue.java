import java.util.LinkedList;

// Stack implemented with linked lists.
public class Queue<E>{
    LinkedList<E> values;

    public Queue() {
        values = new LinkedList<>();
    }

    public void push(E element) {
        values.addLast(element);
    }

    public E pop() {
        return values.removeFirst();
    }

    public int size() {
        return values.size();
    }
}

