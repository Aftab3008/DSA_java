public class testHeap {
    public static void main(String[] args) throws queueException {
        Heap<Integer> heap = new Heap<>();
        heap.insert(1, 1);
        heap.insert(5, 5);
        heap.insert(3, 3);
        System.out.println(heap.getmin());
        while (!heap.isEmpty()) {
            heap.removeMin();
        }
        // System.out.println(x);
        // System.out.println(heap.getmin());
        heap.Heapsort();
    }
}
