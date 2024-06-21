public class hashnode<K, V> {
    K key;
    V value;
    hashnode<K, V> next;

    hashnode(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
