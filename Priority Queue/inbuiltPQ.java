import java.util.PriorityQueue;

public class inbuiltPQ {
    public static void main(String[] args) {
        int arr[] = { 10, 29, 33, 24, 44, 6, 3 };
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }
        System.out.println(pq.peek());
        for (int i = 0; i < arr.length; i++) {
            System.out.print(pq.poll() + " ");
        }

    }
}
