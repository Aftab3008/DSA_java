public class heapsort {
    public static void Heapsort(int[] arr) {

        // Build heap
        int n = arr.length;
        for (int i = (n / 2) - 1; i >= 0; i--) {
            downheapify(arr, i, n);
        }
        // Remove elements

        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            downheapify(arr, 0, i);
        }
    }

    public static void downheapify(int[] arr, int i, int n) {
        int parent = i;
        int leftChild = 2 * parent + 1;
        int rightChild = 2 * parent + 2;
        while (leftChild < n) {
            int minIndex = parent;
            if (leftChild < n && arr[leftChild] < arr[minIndex]) {
                minIndex = leftChild;
            }
            if (rightChild < n && arr[rightChild] < arr[minIndex]) {
                minIndex = rightChild;
            }
            if (minIndex == parent) {
                return;
            }
            int temp = arr[parent];
            arr[parent] = arr[minIndex];
            arr[minIndex] = temp;
            parent = minIndex;
            leftChild = 2 * parent + 1;
            rightChild = 2 * parent + 2;
        }
    }

    /*
     * No.of non-leaf nodes is (n/2)
     * No.of leaf nodes is (n-(n/2))
     * Non-leaf nodes from (n/2)-1 to 0
     */

    public static void main(String[] args) {
        int arr[] = { 9, 8, 7, 10, 11, 12, 6, 5, 4, 3, 2, 1 };
        Heapsort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
