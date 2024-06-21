import java.util.HashMap;

public class intersection {
    public static void printIntersection(int arr1[], int arr2[]) {
        HashMap<Integer, Integer> maps = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            if (maps.containsKey(arr1[i])) {
                int value = maps.get(arr1[i]);
                maps.put(arr1[i], value + 1);
            } else {
                maps.put(arr1[i], 1);
            }
        }
    }

    public static void main(String[] args) {
        int arr1[] = { 1, 3, 4, 2, 2, 5, 7, 4, 9 };
        int arr2[] = { 8, 4, 3, 2, 4, 2, 7, 8 };
        printIntersection(arr1, arr2);
    }
}
