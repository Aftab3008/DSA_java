import java.util.ArrayList;
import java.util.HashMap;

public class RemoveDuplicates {
    public static ArrayList<Integer> removeduplicates(int[] arr) {
        ArrayList<Integer> output = new ArrayList<>();
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                continue;
            }
            output.add(arr[i]);
            map.put(arr[i], true);
        }
        return output;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 3, 4, 5, 6, 3, 1 };
        ArrayList<Integer> output = removeduplicates(arr);
        for (int i = 0; i < output.size(); i++) {
            System.out.print(output.get(i) + " ");
        }
    }
}
