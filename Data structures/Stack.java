import java.util.LinkedList;

// Stack implemented with linked lists.
public class Stack<E>{
    LinkedList<E> values;

    public Stack() {
        values = new LinkedList<>();
    }

    public void push(E element) {
        values.addLast(element);
    }

    public E pop() {
        return values.removeLast();
    }

    public int size() {
        return values.size();
    }
}
