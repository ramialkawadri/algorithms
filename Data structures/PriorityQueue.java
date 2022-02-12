import java.util.ArrayList;

// PriorityQueue using Max Heap
public class PriorityQueue<T extends Comparable<T>> {
    ArrayList<T> heap;

    public PriorityQueue() {
        heap = new ArrayList<>();
    }

    public void push(T val) {
        heap.add(val);
        int currentIndex = heap.size() - 1, 
            parentIndex = getParentIndex(currentIndex);

        while (hasParent(currentIndex) && 
                heap.get(currentIndex).compareTo(heap.get(parentIndex)) > 0) {
            swap(currentIndex, parentIndex);
            currentIndex = parentIndex;
            parentIndex = getParentIndex(currentIndex);
        }
    }

    public T pop() {
        if (heap.size() == 0) throw new IndexOutOfBoundsException();

        T returnVal = heap.get(0);

        // Removing last element and putting it at root
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        // Bubbling down
       int currentIndex = 0; 
       while (hasLeftChild(currentIndex)) {
           int rightChild = getRightChild(currentIndex);
           int leftChild = getLeftChild(currentIndex);

           if (hasRightChild(currentIndex) &&
                   heap.get(leftChild).compareTo(heap.get(rightChild)) < 0) {
               if (heap.get(currentIndex).compareTo(heap.get(rightChild)) < 0) {
                    swap(currentIndex, rightChild);
                    currentIndex = rightChild;
                    continue;
               } else break;
           } else {
               if (heap.get(currentIndex).compareTo(heap.get(leftChild)) < 0) {
                   swap(currentIndex, leftChild);
                   currentIndex = leftChild;
               } else break;
           }
        }

        return returnVal;
    }

    public T peek() {
        if (!isEmpty()) return heap.get(0);
        throw new IndexOutOfBoundsException();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return heap.size();
    }

    private int getLeftChild(int index) {
        return index * 2 + 1;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChild(index) < size();
    }

    private int getRightChild(int index) {
        return index * 2 + 2;
    }

    private boolean hasRightChild(int index) {
        return getRightChild(index) < size();
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private boolean hasParent(int index) {
        return index > 0;
    }

    private void swap(int index1, int index2) {
        T temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }
}

