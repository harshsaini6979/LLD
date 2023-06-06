package HashMap;

public class MyHashMap<K, V> {
    private static final int INITIAL_SIZE = 1<<4;
    private static final int MAXIMUM_SIZE = 1<<30;

    Entry[] hashmap;

    public MyHashMap() {
        hashmap = new Entry[INITIAL_SIZE];
    }

    public MyHashMap(int size) {
        int cap = tableSize(size);
        hashmap = new Entry[cap];
    }

    final int tableSize(int cap) {
        int n = cap-1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;

        if (n<0)
            return 1;
        else if(n>=MAXIMUM_SIZE)
            return MAXIMUM_SIZE;
        return n+1;
    }

    public void put(K key, V val) {
        int hashCode = key.hashCode() % (hashmap.length);
        Entry node = hashmap[hashCode];

        if (node == null) {
            Entry newNode = new Entry(key, val);
            hashmap[hashCode] = newNode;
        }
        else {
            Entry prev = node;
            while (node != null) {
                if (node.key == key){
                    node.value = val;
                    return;
                }
                prev = node;
                node = node.next;
            }
            Entry newNode = new Entry(key, val);
            prev.next = newNode;
        }
    }

    public V get(K key) {
        int hashCode = key.hashCode() % (hashmap.length);
        Entry node = hashmap[hashCode];

        while (node != null) {
            if (node.key.equals(key))
                return (V)node.value;
            node = node.next;
        }

        return null;
    }
}
