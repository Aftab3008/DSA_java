import java.util.HashMap;
import java.util.Set;

public class hashmapIntro {

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("abc", 2);
        map.put("def", 3);
        System.out.println(map.get("abc"));
        if (map.containsKey("abc")) {
            System.out.println("Key is present");
        }
        if (map.containsKey("abcd")) {
            System.out.println("Key is present");
        }
        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println(key + " " + map.get(key));
        }
        System.out.println(map.containsValue(2));
        map.remove("def");
        map.put("abc", 3);
        System.out.println(map.get("abc"));
        System.out.println(map.size());
    }

}
