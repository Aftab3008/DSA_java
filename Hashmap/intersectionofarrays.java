import java.util.ArrayList;
import java.util.HashMap;

public class intersectionofarrays {
    public static ArrayList<Integer> arrayintersection(int[] arr1, int[] arr2) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        ArrayList<Integer> output = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            if (map.containsKey(arr1[i])) {
                continue;
            }
            map.put(arr1[i], true);
        }
        // System.out.println(map.size());
        for (int i = 0; i < arr2.length; i++) {
            if (map.containsKey(arr2[i])) {
                if (!output.contains(arr2[i])) {
                    output.add(arr2[i]);
                }
            }
        }
        return output;
    }

    public static void main(String[] args) {
        int[] nums1 = { 2, 6, 8, 5, 4, 3 };
        int[] nums2 = { 2, 3, 4, 7 };
        ArrayList<Integer> output = arrayintersection(nums1, nums2);
        for (int i = 0; i < output.size(); i++) {
            System.out.print(output.get(i) + " ");
        }
    }
}
