package Marquee.BinarySearch.HashTable;

public class HashMapImplementation<K, V> {
    class Entry<K, V>{
        private V val;
        private K key;

        //Constructor
        Entry(K key, V val){
            this.val = val;
            this.key = key;
        }
        // Getters and Setters as the variables are private
        public void setVal(V val){
            this.val = val;
        }
        public V getVal(){
            return val;
        }
        public void setKey(K key){
            this.key = key;
        }
        public K getKey(){
            return key;
        }
    }

    GenericHashTable<Entry<K, V>> ght = new GenericHashTable<>();
    public boolean put(K key, V val){
        return ght.insert(new Entry<>(key, val));
    }
}
