import java.util.ArrayList;

//Minheap
public class Heap<T> {
    private ArrayList<priority<T>> heap;
    private ArrayList<T> heapsort;

    public Heap() {
        heap = new ArrayList<>();
        heapsort = new ArrayList<>();
    }

    public void insert(T value, int priority) {
        priority<T> e = new priority<T>(value, priority);
        heap.add(e);
        int childIndex = heap.size() - 1;
        int parentIndex = (childIndex - 1) / 2;
        while (parentIndex >= 0 && heap.get(childIndex).priority < heap.get(parentIndex).priority) {
            priority<T> temp = heap.get(childIndex);
            heap.set(childIndex, heap.get(parentIndex));
            heap.set(parentIndex, temp);
            childIndex = parentIndex;
            parentIndex = (childIndex - 1) / 2;
        }
    }

    public T getmin() throws queueException {
        if (isEmpty()) {
            throw new queueException();
        }
        return heap.get(0).value;
    }

    public T removeMin() throws queueException {
        if (isEmpty()) {
            throw new queueException();
        }
        priority<T> removed = heap.get(0);
        T ans = removed.value;
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        int parentIndex = 0;
        int leftChild = 2 * parentIndex + 1;
        int rightChild = 2 * parentIndex + 2;
        while (leftChild < heap.size()) {
            int minIndex = parentIndex;
            if (leftChild < heap.size() && heap.get(leftChild).priority < heap.get(minIndex).priority) {
                minIndex = leftChild;
            }
            if (rightChild < heap.size() && heap.get(rightChild).priority < heap.get(minIndex).priority) {
                minIndex = rightChild;
            }
            if (minIndex == parentIndex) {
                break;
            }
            priority<T> temp = heap.get(minIndex);
            heap.set(minIndex, heap.get(parentIndex));
            heap.set(parentIndex, temp);
            parentIndex = minIndex;
            leftChild = 2 * parentIndex + 1;
            rightChild = 2 * parentIndex + 2;
        }
        heapsort.add(ans);
        return ans;
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.size() == 0 ? true : false;
    }

    public void Heapsort() {
        for (int i = 0; i < heapsort.size(); i++) {
            System.out.print(heapsort.get(i) + " ");
        }
    }
}