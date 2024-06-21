import java.util.ArrayList;

public class hashmap<K, V> {
    ArrayList<hashnode<K, V>> buckets;
    int count;
    int numBuckets;

    public hashmap() {
        buckets = new ArrayList<>();
        numBuckets = 20;
        for (int i = 0; i < numBuckets; i++) {
            buckets.add(null);
        }
    }

    private void rehash() {
        ArrayList<hashnode<K, V>> temp = buckets;
        buckets = new ArrayList<>();
        numBuckets *= 2;
        for (int i = 0; i < numBuckets; i++) {
            buckets.add(null);
        }
        count = 0;
        for (int i = 0; i < temp.size(); i++) {
            hashnode<K, V> head = buckets.get(i);
            while (head != null) {
                K key = head.key;
                V value = head.value;
                insert(key, value);
                head = head.next;
            }
        }
    }

    public void insert(K key, V value) {
        int index = key.hashCode() % numBuckets;
        hashnode<K, V> head = buckets.get(index);
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        head = buckets.get(index);
        hashnode<K, V> newNode = new hashnode<>(key, value);
        newNode.next = head;
        buckets.set(index, newNode);
        count++;
        double loadFactor = (1.0 * count) / numBuckets;
        if (loadFactor >= 0.7) {
            rehash();
        }
    }

    public int size() {
        return count;
    }

    public V getvalue(K key) {
        int index = key.hashCode() % numBuckets;
        hashnode<K, V> head = buckets.get(index);
        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public V removekey(K key) {
        int index = key.hashCode() % numBuckets;
        hashnode<K, V> head = buckets.get(index);
        hashnode<K, V> prev = null;
        while (head != null) {
            if (head.key.equals(key)) {
                if (prev == null) {
                    buckets.set(index, head.next);
                } else {
                    prev.next = head.next;
                }
                count--;
                return head.value;
            }
            prev = head;
            head = head.next;
        }
        return null;
    }
}
