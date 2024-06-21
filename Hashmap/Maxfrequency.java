import java.util.HashMap;
import java.util.Set;

public class Maxfrequency {
    public static int maxfrequency(int arr[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                int value = map.get(arr[i]) + 1;
                map.put(arr[i], value);
            } else {
                map.put(arr[i], 0);
            }
        }
        int max = Integer.MIN_VALUE;
        int maxkey = Integer.MIN_VALUE;
        Set<Integer> keys = map.keySet();
        for (Integer key : keys) {
            if (max < map.get(key)) {
                max = map.get(key);
                maxkey = key;
            }
        }
        return maxkey;
    }

    public static void main(String[] args) {
        int arr[] = { 32, 14, 14, 76, 14, 32, 29, 32 };
        int max = maxfrequency(arr);
        System.out.println(max);
    }

}
